package com.STS.Service;

import com.STS.DTO.CustomerDto;
import com.STS.Model.JwtRequest;
import com.STS.Model.JwtResponse;

public interface CustomerService {

	Integer SaveCustomer(CustomerDto customerDto);

	Integer productBuy(Integer productId,Integer CustumerId);


}
