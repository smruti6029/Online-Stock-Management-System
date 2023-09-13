package com.STS.Service;

import java.util.List;

import com.STS.DTO.StockAvilableDto;

public interface StockManagement {

	Integer pruductAdd(StockAvilableDto avilableDto);


	List<StockAvilableDto> getallProduct(Integer pageNumber, Integer pageSize);


}
