package com.STS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.STS.DTO.CustomerDto;
import com.STS.Model.JwtResponse;
import com.STS.Service.CustomerService;

@RestController 
class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/signinCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody CustomerDto customerDto  ){
		
		try
		{
		Integer saveCustomer = customerService.SaveCustomer(customerDto);
		if(saveCustomer!=0)
		{
			return new ResponseEntity<String>("Add Susscefully",HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<String>("Add Falid",HttpStatus.BAD_REQUEST);
		}
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}}
	
	
	@GetMapping("/buyProduct/{pdoductId}/{customerId}")
	public JwtResponse<?> productBuy(@PathVariable("pdoductId") Integer pdoductId,@PathVariable("customerId") Integer customerId)
	{
		
		Integer productBuy = customerService.productBuy(pdoductId, customerId);
		if(productBuy!=null)
		{
			return new JwtResponse<>("Order Placed Successfully","Sent Mail to Your Gmail",HttpStatus.OK.value());
		}
		else
		{
		return new JwtResponse<>("Order Fallid","Try Again",HttpStatus.BAD_REQUEST.value());
		}
		
	}
		
	

}
