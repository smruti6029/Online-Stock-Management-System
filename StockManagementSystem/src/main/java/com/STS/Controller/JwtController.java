package com.STS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.STS.Model.JwtRequest;
import com.STS.Model.JwtResponse;
import com.STS.Service.UserDataServiceImpl;



@RestController
public class JwtController {
	
	@Autowired
	private UserDataServiceImpl dataService;
	
	
	
	
	
	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public JwtResponse<?> generateTokan(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		System.out.println(jwtRequest);
		
		
		System.out.println("inside Controller");
		
		JwtResponse token=null;
		try
		{
		 token = dataService.generateToken(jwtRequest);
		 token.setId(HttpStatus.OK.value());
		 return new JwtResponse<>("Token Generate Succesfully", token,HttpStatus.OK.value());
		}
		catch (Exception e) {
			
			e.printStackTrace();
			return new JwtResponse<>("Inside catch ","",HttpStatus.BAD_REQUEST.value());
		}
		
		
		
		
			
		
		
	}

}
