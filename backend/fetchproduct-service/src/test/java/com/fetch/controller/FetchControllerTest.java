package com.fetch.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fetch.model.Product;
import com.fetch.service.FetchService;

@SpringBootTest
public class FetchControllerTest {

	@Autowired
	FetchController fetchController;
	
	@MockBean
	FetchService fetchService;
	
	@Test
	@DisplayName("testing getProductByid in FetchController By mocking service")
	void getProductByIdTest() {
		Product pk=new Product();
		Product p=new Product();
		p.setProductId(1);
		p.setProductName("grocery");
		p.setproductDescription("for daily needs");
		p.setCreatedBy("sanket");
		p.setUpdatedBy("sanket");
		
		when(fetchService.getProductById(1)).thenReturn(p);
		
		assertEquals(p.getproductDescription(),fetchController.getProductById(1).getproductDescription());
		assertEquals(p.getUpdatedBy(),fetchController.getProductById(1).getUpdatedBy());
		}
	
	
	@Test
	@DisplayName("testing getProductsForcurrent month fetchcontroller by mocking service")
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
		when(fetchService.getProductsInMonth(11)).thenReturn(ar);
		
		assertEquals(ar.size(),fetchController.getProductsForCurrentMonth(11).size());
		
		}
	

	@Test
	@DisplayName("testing getProducts By  month fetchcontroller  By start end by mocking service")
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
		when(fetchService.getProductsBetweentheMonths(11, 11)).thenReturn(ar);
		
		assertEquals(ar.size(),fetchController.getProductsByMonth(11, 11).size());
		
		}
	
	
	
}
