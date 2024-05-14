package it.federicomollica.dao;

import org.springframework.data.repository.CrudRepository;

import it.federicomollica.model.Precipitation;

public interface PrecipitationDao extends CrudRepository<Precipitation, Integer>{

}
