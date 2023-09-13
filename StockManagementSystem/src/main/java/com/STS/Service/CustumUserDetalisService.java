package com.STS.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.STS.DAO.CustomerDao;
import com.STS.Entity.Customer;


@Service
public class CustumUserDetalisService implements UserDetailsService {


	@Autowired
   private CustomerDao customerDao;
   
   
	@Override
	public UserDetails loadUserByUsername(String UserName) throws UsernameNotFoundException {

		Customer customer = customerDao.getByName(UserName);
		if (customer != null) {

			return new User(customer.getGmail(), customer.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("user not found");
		}
		
		
	}

	

}
