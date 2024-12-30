package com.example.controller;

import java.sql.Date;
import java.text.DateFormat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.InvalidMonthException;
import com.example.exception.MyCustomException;
import com.example.model.Product;
import com.example.repository.AddRespository;
import com.example.service.AddProductService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AddController {

	@Autowired
	private AddRespository addRepository;
	
	@Autowired
	private AddProductService addProductService;

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
//		Product p=null;
//		System.out.println(product);
//	
//		try {
//		 p=addRepository.save(product);
//		}
//		catch(Exception e) {
//			throw new MyCustomException("There is problem with db");
//		}
//	
//		return p;
		System.out.println("In the addcontroller addproduct");
		Product p=this.addProductService.AddProduct(product);
		System.out.println("exiting the addcontroller addproduct");
	    return new ResponseEntity<Product>(p,HttpStatus.CREATED);
		
		
		
	    }
	
	@GetMapping("/product")
	public List<Product> getAllProducts(){
		List<Product> p=addRepository.findAll();
		return p;
	}
		
		
	
	
	@GetMapping("/getproductbyid/{id}")
	public Product getProductById(@PathVariable("id") int id){
    System.out.println("Entering AddController getProductByid");
	Product p=addProductService.getProductById(id);
	System.out.println("Exiting Addcontroller getProductById");
	return p;
	
	}
	
	@GetMapping("/product/{begin_m}/{end_m}")
	public List<Product> getProductsByMonth(@PathVariable("begin_m") int start,
			@PathVariable("end_m") int end){
		List<Product> p;
		System.out.println("entering into AddproductController getProductsByMonth");
		 p= addProductService.getProductsByMonth(start, end);
		 if(p.isEmpty()) {
			 throw new MyCustomException("There is no data end backend");
		 }
		return p;
	}
	
	@GetMapping("/getproductsinmonth/{m}")
	public List<Product> getProductsForCurrentMonth(@PathVariable("m") int m){
		List<Product> p;
		  System.out.println("Entering AddController getProductByMonth1");
		 p=addProductService.getProductsInMonth(m);
		 if(p.isEmpty()) {
			 throw new MyCustomException("There is no data end backend");
		 }
		  System.out.println("Entering AddController getProductsByMonth");
		
		return p;
	}
	
	
	@GetMapping("/getproductsbydate/{d}")
	public List<Product> getProductsByDate(@PathVariable("d") String m){
		List<Product> p;
		  System.out.println("Entering AddController getProductByDate");
		  System.out.println(m); 
		  p=addRepository.getProductsByDate(m);
		  if(p.isEmpty()) {
			  throw new MyCustomException("There is no data in backend");
		  }
		 
		  System.out.println("Entering AddController getProductsByDate");
         
		  return p;
		  
     }
	
	@GetMapping("/getproductsbyname/{d}")
	public List<Product> getProductsByName(@PathVariable("d") String m){
		List<Product> p;
		  System.out.println("Entering AddController getProductByName");
		  System.out.println(m); 
		 p=addRepository.getProductsByString(m);
		 if(p.isEmpty()) {
			  throw new MyCustomException("There is no data in backend");
		  }
		  System.out.println("Entering AddController getProductsByName");
         
		  return p;
		  
     }
	
	@DeleteMapping("/product/{id}")
	public Product deleteProduct(@PathVariable("id") int id) {
		Optional<Product> ps=addRepository.findById(id);
		Product p=ps.get();
		System.out.println(p);
		addRepository.delete(p);
		return p;
	}
	
	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable("id") int id,@RequestBody Product pk) {
		Product p=addRepository.findById(id).get();
		p.setProductName(pk.getProductName());
		p.setproductDescription(pk.getproductDescription());
		p.setCreatedBy(pk.getCreatedBy());
		p.setUpdatedBy(pk.getUpdatedBy());
		Product prr=addRepository.save(p);
		return prr;
	}
	
	@GetMapping("/getbystring/{st}")
	public List<Product> findByContainingString(@PathVariable("st") String st){
		List<Product> p=addRepository.getProductsByString(st);
		System.out.println(p);
		return p;
	}
	
	
	
	
	
	
	
}
