package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.model.Product;
import com.example.service.AddProductService;

@SpringBootTest
public class AddControllerTest {

	@Autowired
	AddController addController;
	
	@MockBean
	AddProductService addProductService;
	
	@Test
	@DisplayName("Add product rest end point working or not")
	void testAddProduct() {
		Product pk=new Product();
		Product p=new Product();
		p.setProductName("grocery");
		p.setproductDescription("for daily needs");
		p.setCreatedBy("sanket");
		p.setUpdatedBy("sanket");
		
		when(addProductService.AddProduct(pk)).thenReturn(p);
		
		assertEquals(p.getproductDescription(),addController.addProduct(pk).getBody().getproductDescription());
		
		}
	
	
	@Test
	@DisplayName("testing getProductByid rest end point working or not")
	void testGetProductById() {
		Product pk=new Product();
		Product p=new Product();
		p.setProductId(1);
		p.setProductName("grocery");
		p.setproductDescription("for daily needs");
		p.setCreatedBy("sanket");
		p.setUpdatedBy("sanket");
		
		when(addProductService.getProductById(1)).thenReturn(p);
		
		assertEquals(p.getproductDescription(),addController.getProductById(1).getproductDescription());
		assertEquals(p.getUpdatedBy(),addController.getProductById(1).getUpdatedBy());
		}
	
	
	@Test
	@DisplayName("testing getProductByid rest end point working or not")
	void testGetProductsByMonth() {
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
		when(addProductService.getProductsInMonth(11)).thenReturn(ar);
		
		assertEquals(ar.size(),addController.getProductsForCurrentMonth(11).size());
		
		}
	
	
	
	
}
