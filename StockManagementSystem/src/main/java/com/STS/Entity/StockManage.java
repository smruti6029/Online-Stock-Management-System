package com.STS.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stockmanage")
public class StockManage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "product_name")
	private String product_name;
	
	@Column(name = "product_id")
	private String productId;
	
	@Column(name = "add_date")
	private String dateOfAdd;
	
	
	@Column(name = "sale")
	private String dateofSale;
	
	
	@Column(name = "typeof_product")
	private String product_type;;
	
	
	@Column(name = "brand")
	private String product_brand;;
	
	@Column(name = "is_available")
	private Boolean is_avilable=true;
	
	@Column(name = "product_price")
	private String price;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer_id=null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDateOfAdd() {
		return dateOfAdd;
	}

	public void setDateOfAdd(String dateOfAdd) {
		this.dateOfAdd = dateOfAdd;
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

	public Boolean getIs_avilable() {
		return is_avilable;
	}

	public void setIs_avilable(Boolean is_avilable) {
		this.is_avilable = is_avilable;
	}

	public StockManage() {
		super();
		
	}

	public StockManage(int id, String product_name, String productId, String dateOfAdd, String dateofSale,
			String product_type, String product_brand, Boolean is_avilable) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.productId = productId;
		this.dateOfAdd = dateOfAdd;
		this.dateofSale = dateofSale;
		this.product_type = product_type;
		this.product_brand = product_brand;
		this.is_avilable = is_avilable;
	}

	

	public String getPrice() {
		return price;
	}

	public void setPrice(String price 	) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "StockManage [id=" + id + ", product_name=" + product_name + ", productId=" + productId + ", dateOfAdd="
				+ dateOfAdd + ", dateofSale=" + dateofSale + ", product_type=" + product_type + ", product_brand="
				+ product_brand + ", is_avilable=" + is_avilable + ", price=" + price + ", customer_id=" + customer_id
				+ "]";
	}

	public Customer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

