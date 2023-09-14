package com.STS.pdf;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.STS.DTO.CustumerInvoiceGenerateDto;
import com.STS.Entity.StockManage;

@Service
public class Datamaper {
	
	
	@Autowired
	private SpringTemplateEngine springTemplateEngine;

	@Autowired
	private DocumentGEnerator documentGEnerator;
	
	public void setData(CustumerInvoiceGenerateDto byproductByid) {
		
		
		
       
        
	    Context context = new Context();
	    Map<String, Object> data = new HashMap<>();
	    data.put("stockList", byproductByid); // Use "employees" to match the template variable name
	    context.setVariables(data);
	    String finalHtml = springTemplateEngine.process("template", context);
	    
	    documentGEnerator.htmlToPdf(finalHtml);
	}


}
