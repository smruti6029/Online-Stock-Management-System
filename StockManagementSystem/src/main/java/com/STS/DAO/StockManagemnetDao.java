package com.STS.DAO;

import java.util.List;

import com.STS.DTO.Pagination;
import com.STS.Entity.StockManage;

public interface StockManagemnetDao {

	StockManage checkByPruductId(String pruduct_id);

	Integer saveProduct(StockManage stockAdd);
	
	StockManage getByproductByid(Integer productId);

	Integer updateStore(StockManage byproductByid);

//	Pagination<List<StockManage>> getAllproduct(Integer pageNumber, Integer pageSize);

	List<StockManage> getAllproduct();

	Pagination<List<StockManage>> getAllproduct(Integer pageNumber, Integer pageSize);

}
