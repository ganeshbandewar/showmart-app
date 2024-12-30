package com.fetch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fetch.model.Product;
import com.fetch.repository.FetchRepository;
import com.fetch.service.FetchService;

@RestController
@RequestMapping("/api/v1")
public class FetchController {
	
	@Autowired
	FetchService fetchService;

	@GetMapping("/getproductbyid/{id}")
	public Product getProductById(@PathVariable("id") int id ){
		System.out.println("Entering fetch controller");
		Product p=this.fetchService.getProductById(id);
		System.out.println("Exiting fetch controller");
		return p;
	
	}
	
	
	@GetMapping("/product/{begin_m}/{end_m}")
	public List<Product> getProductsByMonth(@PathVariable("begin_m") int start,
			@PathVariable("end_m") int end){
		System.out.println("Entering FetchController getProductsByMonth");
		List<Product> p=fetchService.getProductsBetweentheMonths(start, end);
		
		System.out.println("Exiting FetchController getProductsByMonth");
		return p;
		
	}
	

	@GetMapping("/getproductsinmonth/{m}")
	public List<Product> getProductsForCurrentMonth(@PathVariable("m") int m){
		List<Product> p=fetchService.getProductsInMonth(m);
		System.out.println("tis"+p);
		
		
		return p;
	}
	
	
	
	
	
	
}
