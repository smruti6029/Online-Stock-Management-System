package com.STS.DTO;

import com.STS.Entity.StockManage;

public class StockAvilableDto {

	
	private Integer id=null;
	
	private String product_name;

	private String product_type;;

	private String product_brand;

	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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

	public StockAvilableDto(String product_name, String product_type, String product_brand, String price) {
		super();
		this.product_name = product_name;
		this.product_type = product_type;
		this.product_brand = product_brand;
		this.price = price;

	}

	public StockAvilableDto() {
		super();
	}
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static StockManage stockdtoTostockEntity(StockAvilableDto avilableDto)
	{
		StockManage stock=new StockManage();
		stock.setProduct_brand(avilableDto.getProduct_brand());
		stock.setProduct_name(avilableDto.getProduct_name());
		stock.setProduct_type(avilableDto.getProduct_type());
		stock.setPrice(avilableDto.getPrice());
		return stock;
		
		
	}
	
	
	public static StockAvilableDto entityTodto(StockManage avilableProduct)
	{
		StockAvilableDto stockDto=new StockAvilableDto();
		stockDto.setId(avilableProduct.getId());
		
		stockDto.setProduct_brand(avilableProduct.getProduct_brand());
		stockDto.setProduct_name(avilableProduct.getProduct_name());
		stockDto.setProduct_type(avilableProduct.getProduct_type());
		stockDto.setPrice(avilableProduct.getPrice());
		
		
		return stockDto;
		
		
	}
	
	
	
	
	
	
	
	

}
