package com.STS.DTO;

import com.STS.Entity.Customer;
import com.STS.Entity.StockManage;

public class CustumerInvoiceGenerateDto {
	
	private String name;
		
	private String phoneNo;
	
	private String address;
	
	private String product_name;
	
	private String productId;
	
	private String dateofSale;
	
	private String product_type;;
	
	private String product_brand;;
	
	private String price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDateofSale() {
		return dateofSale;
	}

	public void setDateofSale(String dateofSale) {
		this.dateofSale = dateofSale;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getProduct_brand() {
		return product_brand;
	}

	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public CustumerInvoiceGenerateDto(String name, String phoneNo, String address, String product_name,
			String productId, String dateofSale, String product_type, String product_brand, String price) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.product_name = product_name;
		this.productId = productId;
		this.dateofSale = dateofSale;
		this.product_type = product_type;
		this.product_brand = product_brand;
		this.price = price;
	}

	public CustumerInvoiceGenerateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CustumerInvoiceGenerateDto convertForPdf(StockManage byproductByid, Customer customer) {
		
		CustumerInvoiceGenerateDto obj=new CustumerInvoiceGenerateDto();
		obj.setName(customer.getFirstname()+" "+customer.getLastname());
		obj.setAddress(customer.getAddress());
		obj.setDateofSale(byproductByid.getDateofSale());
		obj.setPhoneNo(byproductByid.getCustomer_id().getPhoneNo());
		obj.setProduct_brand(byproductByid.getProduct_brand());
		
		obj.setProduct_name(byproductByid.getProduct_name());
		
		obj.setProduct_type(byproductByid.getProduct_type());
		
		obj.setPrice(byproductByid.getPrice());
		
		obj.setProductId(byproductByid.getProductId());
		
		
		
		return obj;
	}
	

}
