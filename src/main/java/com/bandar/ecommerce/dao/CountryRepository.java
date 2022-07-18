package com.bandar.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.bandar.ecommerce.entity.Country;

@CrossOrigin("http://192.168.1.67:4200")
@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
public interface CountryRepository extends JpaRepository<Country, Integer> {
	
	// All countries: http://localhost:8080/api/countries
	// find countries by ID: http://localhost:8080/api/countries/3

}
