package it.federicomollica.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.federicomollica.model.Forecast;

public interface ForecastDao extends CrudRepository<Forecast, Integer>{

	List<Forecast> findByUserId(int userId);

}
