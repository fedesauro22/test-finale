package it.federicomollica.dao;

import org.springframework.data.repository.CrudRepository;

import it.federicomollica.model.City;

public interface CityDao extends CrudRepository<City, Integer>{
	boolean existsByName(String name);
	City findByName(String name);
}
