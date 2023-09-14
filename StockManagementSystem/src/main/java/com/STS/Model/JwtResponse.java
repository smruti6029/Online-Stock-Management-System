package com.STS.Model;

public class JwtResponse<T> {

private String meassage;

private Object response;

private Integer id;

public Object getMeassage() {
	return meassage;
}

public void setMeassage(String meassage) {
	this.meassage = meassage;
}

public Object getResponse() {
	return response;
}

public void setResponse(Object response) {
	this.response = response;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public JwtResponse() {
	super();
	// TODO Auto-generated constructor stub
}

public JwtResponse(String meassage, Object response, Integer id) {
	super();
	this.meassage = meassage;
	this.response = response;
	this.id = id;
}




	

}
