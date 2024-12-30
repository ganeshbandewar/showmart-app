package com.fetch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fetch.model.Product;

public interface FetchRepository extends JpaRepository<Product,Integer>{
	@Query(value="select * from Product p where month(p.created_date)>= :start and month(p.created_date)<= :end",nativeQuery=true)
	public List<Product> getProductsBetweenMonths(@Param("start") int start,@Param("end") int end);
	
	@Query(value="select * from Product p where month(p.created_date)=:m",nativeQuery=true)
	public List<Product> getProductsInMonth(@Param("m") int m);
}
