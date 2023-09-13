package com.STS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.STS.DAO.CustomerDao;
import com.STS.DTO.CustomerDto;
import com.STS.Entity.Customer;
import com.STS.Model.JwtRequest;
import com.STS.Model.JwtResponse;
import com.STS.Secutity.JwtUtil;

@Service
public class UserDataServiceImpl  {

	@Autowired
	private CustumUserDetalisService custumUserDetalisService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomerDao customerDao;
	
	
	
	public JwtResponse generateToken(JwtRequest jwtRequest) throws Exception {

		System.out.println("Inside Generate Tokan");

		Customer customerDetalis = customerDao.getByName(jwtRequest.getUsername());

		Customer customer = new Customer();

		if (customerDetalis != null) {

			if (customerDetalis.passwordMatcher(jwtRequest.getPassword(), customerDetalis.getPassword())) {

				JwtResponse jwtResponse = new JwtResponse();
				UserDetails userDetalis = this.custumUserDetalisService.loadUserByUsername(jwtRequest.getUsername());
				String token = this.jwtUtil.generateToken(userDetalis);
				System.out.println("tokan -" + token);
				String name = this.jwtUtil.getUsernameFromToken(token);

				jwtResponse.setResponse(token);
				return jwtResponse;
			} else {
				throw new Exception("User Not Found!!!");
			}

		} else {
			throw new Exception("User Not Found!!!");
		}
	}

	



}
