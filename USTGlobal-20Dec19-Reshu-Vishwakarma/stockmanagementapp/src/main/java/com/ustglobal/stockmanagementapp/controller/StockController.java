package com.ustglobal.stockmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ustglobal.stockmanagementapp.dto.ProductBean;
import com.ustglobal.stockmanagementapp.dto.StockResponse;
import com.ustglobal.stockmanagementapp.service.ProductService;

@RestController
@CrossOrigin(origins ="*", allowedHeaders = "*", allowCredentials = "true")
public class StockController {
	@Autowired
	ProductService productService;
	@GetMapping(path="/byname",produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse getProductByName(@RequestParam("name")String name) {
		StockResponse response = new StockResponse();
		ProductBean bean = productService.getProductByName(name);
		if(bean!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product Found");
			response.setBean(bean);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product Not Found");
		}
		return response;

	}
	@GetMapping(path="/bycategory",produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse getProductByCategory(@RequestParam("category")String category) {
		StockResponse response = new StockResponse();
		List<ProductBean> beans = productService.getProductByCategory(category);
		if(!beans.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product Found");
			response.setBeans(beans);

		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product Not Found");
		}
		return response;
	}
	@GetMapping(path="/bycompany",produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse getProductByCompany(@RequestParam("company")String company) {
		StockResponse response = new StockResponse();
		List<ProductBean> beans = productService.getProductByCompany(company);
		if(!beans.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product Found");
			response.setBeans(beans);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product Not Found");
		}
		return response;
	}
	@PostMapping(path="/addproduct", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse addProduct(@RequestBody ProductBean bean) {
		System.out.println("Name of Product is"+bean.getName());
		StockResponse response = new StockResponse();
		if(productService.addProduct(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product Added");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product Not Added");
		}
		return response;
	}
	@PutMapping(path = "/modifyproduct", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse modifyProduct(@RequestBody ProductBean bean) {
		StockResponse response = new StockResponse();
		if(productService.modifyProduct(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product Updated");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product Not Updated");
		}
		return response;
	}

	@GetMapping(path = "/generate",produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse generateBill(List<ProductBean> beans) {
		StockResponse response = new StockResponse();
		ProductBean bean = productService.generateBill(beans);
		if(bean!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product Updated");
			response.setBean(bean);		

		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product Not Updated");
		}
		return response;
	}
}
