package com.STS.pdf;



import java.io.FileOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfWriter;

@Service
public class DocumentGEnerator {

	
	
	public byte[] htmlToPdf(String htmlContent) {
	    try {
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        PdfWriter pdfWriter = new PdfWriter(outputStream);

	        DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, true, false);
	        ConverterProperties converterProperties = new ConverterProperties();
	        converterProperties.setFontProvider(defaultFontProvider);

	        HtmlConverter.convertToPdf(htmlContent, pdfWriter, converterProperties);

	        // You can return the PDF content as a byte array if needed
	        byte[] pdfBytes = outputStream.toByteArray();

	        // Optionally, save the PDF to a file
	        try (FileOutputStream fileOutputStream = new FileOutputStream("/home/rapidsoft/invoice.pdf")) {
	            fileOutputStream.write(pdfBytes);
	        }

	        return pdfBytes;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}
