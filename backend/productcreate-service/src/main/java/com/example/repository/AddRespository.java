package com.example.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Product;

public interface AddRespository extends JpaRepository<Product,Integer>{

	@Query(value="select * from Product p where DATE(p.created_date)=:m",nativeQuery=true)
	public List<Product> getProductsByDate(@Param("m") String m);
	
	@Query(value="select * from Product p where p.product_name=:m",nativeQuery=true)
	public List<Product> getProductsByNameOnly(@Param("m") String m);
	
	
	@Query(value="select * from Product p where p.product_name LIKE CONCAT('%', :m, '%')",nativeQuery=true)
	public List<Product> getProductsByString(@Param("m") String m);
	
//	select *from product where product_name like '%Ba%';
}
