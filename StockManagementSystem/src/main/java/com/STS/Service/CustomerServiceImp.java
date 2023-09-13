package com.STS.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.reactive.JettyResourceFactory;
import org.springframework.stereotype.Service;

import com.STS.DAO.CustomerDao;
import com.STS.DAO.StockManagemnetDao;
import com.STS.DTO.CustomerDto;
import com.STS.Entity.Customer;
import com.STS.Entity.StockManage;
import com.STS.MailService.EmailSendService;
import com.STS.Model.JwtRequest;
import com.STS.Model.JwtResponse;

import io.jsonwebtoken.JwtException;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private StockManagemnetDao managemnetDao;

	@Override
	public Integer SaveCustomer(CustomerDto customerDto) {

		CustomerDto dto = new CustomerDto();
		Customer convertDtoCustomer = dto.convertDto(customerDto);

		convertDtoCustomer.setDate(new Date());
		convertDtoCustomer.setIs_active(true);

		return customerDao.saveUser(convertDtoCustomer);

	}

	@Autowired
	private EmailSendService emailSendService;

	@Override
	public Integer productBuy(Integer productId, Integer CustumerId) {

		StockManage byproductByid = managemnetDao.getByproductByid(productId);

		if (byproductByid != null) {
			
			if(byproductByid.getIs_avilable()!=false)
			{
			Customer custumerDetalis = customerDao.getByID(CustumerId);

			if (custumerDetalis != null) {
				byproductByid.setIs_avilable(false);

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String frmDate = format.format(new Date());

				byproductByid.setDateofSale(frmDate);
				byproductByid.setCustomer_id(custumerDetalis);

				try {
					Integer updateStore = managemnetDao.updateStore(byproductByid);
					if(updateStore==1)
					{
					emailSendService.sendEmail(custumerDetalis, byproductByid);
					}
					
					return 1;
				} catch (Exception e) {

				}

			}
			}
			else
			{
			 System.out.println("Product Not Avilabe");
			}
		}

		return 0;
	}

}
