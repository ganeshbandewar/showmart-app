package com.example.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Product;

@FeignClient(name="fetchapp",url="http://localhost:8085/api/v1")
public interface fetchClient {

	    @GetMapping(path="/getproductbyid/{id}")
		public Product getProductById(@PathVariable("id") int id );
	    
	    @GetMapping(path="/product/{begin_m}/{end_m}")
		public List<Product> getProductsByMonth(@PathVariable("begin_m") int start,
				@PathVariable("end_m") int end);
	    
	    @GetMapping(path="/getproductsinmonth/{m}")
		public List<Product> getProductsForCurrentMonth(@PathVariable("m") int m);
	

}
