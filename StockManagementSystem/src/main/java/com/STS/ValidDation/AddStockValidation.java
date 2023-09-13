package com.STS.ValidDation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.STS.DAO.CustomerDao;
import com.STS.DTO.StockAvilableDto;
import com.STS.Entity.Customer;
import com.STS.Enum.Role;
import com.STS.Model.JwtResponse;
import com.STS.Secutity.JwtUtil;

@Component
@ComponentScan(basePackages = {"com.STS","com.STS.Secutity"})
public class AddStockValidation {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private JwtUtil jwtUtil;
	
	

	

	public JwtResponse<?> check(StockAvilableDto avilableDto) {
		avilableDto.getPrice();
		avilableDto.getProduct_name();
		avilableDto.getProduct_brand();
		avilableDto.getProduct_type();

		if (avilableDto.getPrice() == null) {
			return new JwtResponse<>("provide price", avilableDto, HttpStatus.BAD_REQUEST.value());
		} else if (avilableDto.getProduct_name() == null) {
			return new JwtResponse<>("provide Name", avilableDto, HttpStatus.BAD_REQUEST.value());
		} else if (avilableDto.getProduct_type() == null) {
			return new JwtResponse<>("provide Product_type", avilableDto, HttpStatus.BAD_REQUEST.value());
		} else if (avilableDto.getProduct_brand() == null) {
			return new JwtResponse<>("provide Brand", avilableDto, HttpStatus.BAD_REQUEST.value());
		} else {
			return new JwtResponse<>("VAllid Pruduct", avilableDto, HttpStatus.OK.value());
		}
	}

	public Customer checkRole(String token) throws Exception {

		try {
			System.out.println("inside token");
			System.out.println(jwtUtil);
			String username = jwtUtil.getUsernameFromToken(token);
			System.out.println(token);
			Customer user = customerDao.getByName(username);
			if (user.getRoleType() == Role.ADMIN) {
				return user;
			} else {
				System.out.println("nullllll");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(("Inside Catch"));
			return null;
		}

	}

}
