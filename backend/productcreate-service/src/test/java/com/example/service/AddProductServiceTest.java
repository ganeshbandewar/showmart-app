package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.feign.fetchClient;
import com.example.model.Product;

@SpringBootTest
public class AddProductServiceTest {

	@Autowired
	AddProductService addProductService;
	
	@MockBean
	private fetchClient fetcherClient;
	
	
	@Test
	@DisplayName("Testing getProductById in AddProductService")
	void testgetproductByid() {
		Product pk=new Product();
		Product p=new Product();
		p.setProductId(1);
		p.setProductName("grocery");
		p.setproductDescription("for daily needs");
		p.setCreatedBy("sanket");
		p.setUpdatedBy("sanket");
		
		when(fetcherClient.getProductById(1)).thenReturn(p);
		
		assertEquals(p.getproductDescription(),addProductService.getProductById(1).getproductDescription());
		
		}
	
	
	
	
	@Test
	@DisplayName("testing getProductByMonth start end rest end point working or not")
	void testGetProductsBystartendMonth() {
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
		when(fetcherClient.getProductsByMonth(11, 11)).thenReturn(ar);
		
		assertEquals(ar.size(),addProductService.getProductsByMonth(11, 11).size());
		
		}
	
	
	@Test
	@DisplayName("testing getProductInMonth By passingOnlyMonth")
	void getProductsInMonth () {
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
		when(fetcherClient.getProductsForCurrentMonth(11)).thenReturn(ar);
		
		assertEquals(ar.size(),addProductService.getProductsInMonth(11).size());
		
		}
	
	
	
}
