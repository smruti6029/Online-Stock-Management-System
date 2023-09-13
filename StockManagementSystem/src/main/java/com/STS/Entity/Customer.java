package com.STS.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.STS.Enum.Role;

@Entity
@Table(name = "user")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name")
	private String firstname;
	
	
	@Column(name = "last_name")
	private String lastname;
	
	@Column(name = "email")
	private String gmail;
	
	@Column(name = "phone_number")
	private String phoneNo;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "registration_date")
	private Date date;
	
	@Enumerated(EnumType.STRING)
	private Role roleType=Role.USER;
	
	@Column(name = "is_active")
	private Boolean is_active;
	
	@OneToMany(mappedBy ="customer_id")
	private List<StockManage> avilable;
	
	
	@Column(name = "password")
	private String password;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer(Integer id, String firstname, String lastname, String gmail, String phoneNo, String address,
			Date date) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gmail = gmail;
		this.phoneNo = phoneNo;
		this.address = address;
		this.date = date;
	}

	public Customer() {
		super();
	}
	
	@Transient
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public String passwordEncoder(String password) {
		return passwordEncoder.encode(password);
	}

	
	public Boolean passwordMatcher(String password, String passwordInDB) {
		return passwordEncoder.matches(password,passwordInDB);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public Role getRoleType() {
		return roleType;
	}

	public void setRoleType(Role roleType) {
		this.roleType = roleType;
	}
	
	
	

}
