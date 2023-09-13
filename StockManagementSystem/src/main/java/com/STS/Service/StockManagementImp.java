package com.STS.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.STS.DAO.StockManagemnetDao;
import com.STS.DTO.Pagination;
import com.STS.DTO.StockAvilableDto;
import com.STS.Entity.StockManage;

@Service
public class StockManagementImp implements StockManagement {
	
	@Autowired
	private StockManagemnetDao stockmanagemnetDao;
	
	@Override
	public Integer pruductAdd(StockAvilableDto avilableDto)
	{
		StockManage stockAdd = StockAvilableDto.stockdtoTostockEntity(avilableDto);
		
		String pruduct_id="";
		int count=1;
		
		while(true)
		{
			pruduct_id="";
		pruduct_id+=stockAdd.getProduct_brand()+"-"+count;
		StockManage checkByPruductId = stockmanagemnetDao.checkByPruductId(pruduct_id);
		if(checkByPruductId==null)
		{
			break;
		}
		count++;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String frmDate = format.format(new Date());
		stockAdd.setProductId(pruduct_id);
		stockAdd.setDateOfAdd(frmDate);
		stockAdd.setDateofSale(null);
		stockAdd.setIs_avilable(true);
		
		Integer saveProduct = stockmanagemnetDao.saveProduct(stockAdd);
		return saveProduct;
			
		
		
	}

	@Override
	public List<StockAvilableDto> getallProduct(Integer pageNumber, Integer pageSize) {
		
		Pagination<List<StockManage>> pagewisedata = stockmanagemnetDao.getAllproduct(pageNumber,pageSize);
		List<StockAvilableDto> productforsale = new ArrayList<>();
		
		
		List<StockManage> allproduct = pagewisedata.getData();
		if(allproduct!=null)
		{
		for(StockManage x:allproduct)
		{
			if(x.getIs_avilable()==true)
			{
				StockAvilableDto stockAvilableDto=new StockAvilableDto();
				StockAvilableDto entityTodto = StockAvilableDto.entityTodto(x);
				productforsale.add(entityTodto);		
				
			}
		}
		return productforsale;
		}
		else
		{
			return null;
		}
		
		
		
	}

}
