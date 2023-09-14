package com.STS.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.STS.DTO.StockAvilableDto;
import com.STS.Entity.Customer;
import com.STS.Model.JwtResponse;
import com.STS.Service.StockManagement;
import com.STS.ValidDation.AddStockValidation;


@RestController
public class StockAddController {

	@Autowired
	private StockManagement managementStock;

	@Autowired
	private AddStockValidation addStockValidation;

	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody StockAvilableDto avilableDto, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String header = request.getHeader("Authorization");

		Customer checkRole = addStockValidation.checkRole(header.substring(7));
		if (checkRole != null) {
			JwtResponse<?> check = addStockValidation.check(avilableDto);
			if (check.getId() == HttpStatus.OK.value())

			{
				Integer pruductAdd = managementStock.pruductAdd(avilableDto);
				if (pruductAdd > 0) {
					return new ResponseEntity<String>("Product add Succesfully", HttpStatus.CREATED);
				}
			}
			else{
				return new ResponseEntity<JwtResponse>(check, HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<String>("You Are Not Authorization For Using It", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Try Again",HttpStatus.BAD_REQUEST);

		

	}

	@CrossOrigin("*")
	@GetMapping("/getAllProduct")
	public JwtResponse<?> getAllProduct(
			@RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize) {
		{
			List<StockAvilableDto> getallProduct = managementStock.getallProduct(pageNumber, pageSize);
			if (getallProduct != null) {
				return new JwtResponse<>("Avilable Product", getallProduct, HttpStatus.OK.value());
			} else {
				return new JwtResponse<>("No Product Avilable", "No product", HttpStatus.BAD_REQUEST.value());
			}

		}

	}
}
