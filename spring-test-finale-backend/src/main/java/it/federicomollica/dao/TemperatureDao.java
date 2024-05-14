package it.federicomollica.dao;

import org.springframework.data.repository.CrudRepository;

import it.federicomollica.model.Temperature;

public interface TemperatureDao extends CrudRepository<Temperature, Integer>{

}
