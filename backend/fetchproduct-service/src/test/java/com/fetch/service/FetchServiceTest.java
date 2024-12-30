package com.fetch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fetch.model.Product;
import com.fetch.repository.FetchRepository;

@SpringBootTest
public class FetchServiceTest {

	@Autowired
	FetchService fetchService;
	
	@MockBean
	private FetchRepository fetchRepository;
	
	@Test
	@DisplayName("testing getProductByid in Fetchservice By mocking repository")
	void getProductByIdTest() {
		Product pk=new Product();
		Product p=new Product();
		p.setProductId(1);
		p.setProductName("grocery");
		p.setproductDescription("for daily needs");
		p.setCreatedBy("sanket");
		p.setUpdatedBy("sanket");
		Optional op=Optional.of(p);
		
		when(fetchRepository.findById(1)).thenReturn(op);
		
		assertEquals(p.getproductDescription(),fetchService.getProductById(1).getproductDescription());
		assertEquals(p.getUpdatedBy(),fetchService.getProductById(1).getUpdatedBy());
		}
	
	
	@Test
	@DisplayName("testing getProductsForcurrent month fetchservice by mocking repostiroy")
	void getProductsForCurrentMonth() {
		Product p2=new Product();
		Product p=new Product();
		p.setProductId(1);
		p.setProductName("grocery");
		p.setproductDescription("for daily needs");
		p.setCreatedBy("sanket");
		p.setUpdatedBy("sanket");
		
		p2.setProductId(2);
		p2.setProductName("grocery1");
		p2.setproductDescription("for daily needs1");
		p2.setCreatedBy("sanket1");
		p2.setUpdatedBy("sanket1");
		
		ArrayList<Product> ar=new ArrayList<Product>();
		ar.add(p);
		ar.add(p2);
		when(fetchRepository.getProductsInMonth(11)).thenReturn(ar);
		
		assertEquals(ar.size(),fetchService.getProductsInMonth(11).size());
		
		}
	

	@Test
	@DisplayName("testing getProducts By  month fetchservice  By start end by mocking repository")
	void getProductsByMonthTest() {
		Product p2=new Product();
		Product p=new Product();
		p.setProductId(1);
		p.setProductName("grocery");
		p.setproductDescription("for daily needs");
		p.setCreatedBy("sanket");
		p.setUpdatedBy("sanket");
		
		p2.setProductId(2);
		p2.setProductName("grocery1");
		p2.setproductDescription("for daily needs1");
		p2.setCreatedBy("sanket1");
		p2.setUpdatedBy("sanket1");
		
		ArrayList<Product> ar=new ArrayList<Product>();
		ar.add(p);
		ar.add(p2);
		when(fetchRepository.getProductsBetweenMonths(11, 11)).thenReturn(ar);
		
		assertEquals(ar.size(),fetchService.getProductsBetweentheMonths(11, 11).size());
		
		}
}
