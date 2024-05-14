package it.federicomollica.service;

import java.util.List;

import it.federicomollica.dto.CityDto;

public interface CityService {
	List<CityDto> getAllCities();
	boolean existsCityName(String name);
	CityDto getCityDto(String name);
}
