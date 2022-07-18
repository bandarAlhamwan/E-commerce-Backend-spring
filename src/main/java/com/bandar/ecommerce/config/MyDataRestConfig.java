package com.bandar.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.bandar.ecommerce.entity.Country;
import com.bandar.ecommerce.entity.Product;
import com.bandar.ecommerce.entity.ProductCategory;
import com.bandar.ecommerce.entity.State;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	
	private EntityManager entityManager;

	@Autowired
	public MyDataRestConfig(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

		HttpMethod[] httpUnsupportedActions = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE };

		// disable HTTP methods for Product: PUT , post , delete
	
		// disable HTTP methods for ProductCategory: PUT , post , delete
		disableHttpMethods(ProductCategory.class, config, httpUnsupportedActions);
		disableHttpMethods(Product.class, config, httpUnsupportedActions);
		disableHttpMethods(Country.class, config, httpUnsupportedActions);
		disableHttpMethods(State.class, config, httpUnsupportedActions);

		// call an internal helper method
		exposeIds(config);
	}



	private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] httpUnsupportedActions) {
		config.getExposureConfiguration()
				.forDomainType(theClass)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(httpUnsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(httpUnsupportedActions));
	}

	
	// Start Add entity id to the response
	public void exposeIds(RepositoryRestConfiguration config) {

		// get a list of all entity classes from the enitity manager
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

		// create an array of the entity types
		List<Class> entityClasses = new ArrayList<>();

		// get the entity types for the entities
		for (EntityType tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}

		// expose the entity ids for the array of entity/domain types
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
	}
	// End Add entity id to the response

}
