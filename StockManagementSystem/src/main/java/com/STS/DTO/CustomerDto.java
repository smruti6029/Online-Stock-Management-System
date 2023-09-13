package com.STS.DTO;

import com.STS.Entity.Customer;

public class CustomerDto {
	

	
	private String firstname;
	
	
	private String lastname;
	
	private String gmail;
	
	private String phoneNo;
	
	private String address;
	
	
	private String password;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerDto(String firstname, String lastname, String gmail, String phoneNo, String address,
			 String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gmail = gmail;
		this.phoneNo = phoneNo;
		this.address = address;
		this.password = password;
	}

	public CustomerDto() {
		super();
	}
	
	
	public Customer convertDto(CustomerDto customerDto)
	{
		Customer customer=new Customer();
		customer.setFirstname(customerDto.getFirstname());
		customer.setLastname(customerDto.getLastname());
		customer.setGmail(customerDto.getGmail());
		customer.setAddress(customerDto.getAddress());
		customer.setPassword(customer.passwordEncoder(customerDto.getPassword()));
		customer.setPhoneNo(customerDto.getPhoneNo());	
		return customer;
	}
	
}
