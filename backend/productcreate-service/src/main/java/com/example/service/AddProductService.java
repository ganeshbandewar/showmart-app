package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.MyCustomException;
import com.example.feign.fetchClient;
import com.example.model.Product;
import com.example.repository.AddRespository;

@Service
public class AddProductService {

	@Autowired
	private fetchClient fetcherClient;
	
	@Autowired
	private AddRespository addRepository;
	
	public Product getProductById(int id){
		System.out.println("Entering Add Product service getProductById");
		System.out.println("calling client");
		Product p;
		try {
	     p=(Product)fetcherClient.getProductById(id);
		}
		catch(Exception e) {
			throw new MyCustomException(e.getMessage());
		}
		System.out.println("exiting client");
		System.out.println("Exiting Add Product service getProductById");
				return p;
		
	}
	

	public List<Product> getProductsByMonth(int start,int end){
		System.out.println("calling client");
		List<Product> p=null;
		try {
		 p=fetcherClient.getProductsByMonth(start, end);
		}
		catch(Exception e) {
			throw new MyCustomException("One of the service is not working in backend");
		}
		System.out.println("exiting client");
		return p;
	}
	
	public List<Product> getProductsInMonth(int m){
		System.out.println("calling client");
		List<Product> p=null;
		System.out.println("getProductsInmonth in service");
	     try {
		 p=fetcherClient.getProductsForCurrentMonth(m);}
	     catch(Exception e) {
	    	 System.out.println(e.getMessage());
	     throw new MyCustomException("One of the service is not working in backend");
	     }
		
		System.out.println("exiting client");
		
		return p;
		}
	
	
	public Product AddProduct(Product p) {
		Product pr;
		try {
		 pr=addRepository.save(p);}
		catch(Exception e) {
			throw new MyCustomException("Product add was unsuccessful");
		}
		return pr;
	}
	
	
}
