package com.fetch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fetch.Exception.NullDataException;
import com.fetch.model.Product;
import com.fetch.repository.FetchRepository;

@Service
public class FetchService {
	@Autowired
	private FetchRepository fetchRepository;
    
	public Product getProductById(int id) {
		System.out.println("Entering fetch service");
		
	Optional<Product> op=fetchRepository.findById(id);
	System.out.println(op);
	if(!op.isPresent()) {
		throw new NullDataException("Data for this id is not present in the database");
	}
	Product p=op.get();
	System.out.println("Exiting fetch service");
	return p;
	     
	}
	
	
	
	public List<Product> getProductsBetweentheMonths(int start,int end){
		System.out.println("Entering Fetchservice getProductsBetweentheMonths");
		List<Product> p=fetchRepository.getProductsBetweenMonths(start, end);
//		if(p.isEmpty()) {
//			throw new NullDataException("Produts for this months"+start+ "end" +end+" is empty");
//		}
		
		System.out.println("Exiting Fetchservice getProductsBetweentheMonths");
		return p;
	}
	
	
	public List<Product> getProductsInMonth(int m){
	List<Product> p=fetchRepository.getProductsInMonth(m);
	
	System.out.println("In the current month");
	System.out.println("coming from client");
	System.out.println(p);
	return p;
	}
}
