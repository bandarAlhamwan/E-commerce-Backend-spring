package com.bandar.ecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.bandar.ecommerce.entity.Product;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long>{

	// to find the below localhost:8080/api/products/search/findByCategoryId?id=2
	Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
	
	@Query("select p from Product p where lower(p.name) like lower(concat('%', :searchText, '%'))" +
			"or lower(p.description) like lower(concat('%', :searchText, '%'))")
	Page<Product> doMyCustomFancyStuff(@RequestParam("searchText") String searchText, Pageable pageable);
	
	// Select * from Product P where P.name like CONCAT('%', :name, '%')
	//http://localhost:8080/api/products/search/findByNameContaining?name=java
	Page<Product> findByNameContaining(@RequestParam("name") String name , Pageable pageable);
	
}
