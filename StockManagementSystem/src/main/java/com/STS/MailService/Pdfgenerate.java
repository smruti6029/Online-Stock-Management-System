package com.STS.MailService;

import com.STS.Entity.StockManage;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class Pdfgenerate {
	
	
	public void generatePdf(StockManage byproductByid) throws Exception
	
	{
		
		try
		{
	String path="invoice.pdf";
	PdfWriter pdfWriter=new PdfWriter(path);  
	
	PdfDocument pdfdocument =new PdfDocument(pdfWriter);
	pdfdocument.setDefaultPageSize(PageSize.A4);
	
	Document document = new Document(pdfdocument); 
	
	document.add(new Paragraph("Order placed Succesfully"));
	document.add(new Paragraph(byproductByid.getProduct_name()));
	document.add(new Paragraph(byproductByid.getCustomer_id().getFirstname()+" "+byproductByid.getCustomer_id().getLastname()));
	
	document.add(new Paragraph(byproductByid.getProduct_brand()));
	document.add(new Paragraph(byproductByid.getPrice()));
	
	
	
	
	document.close();
		}
		catch (Exception e) {
			
		}
	}
}

