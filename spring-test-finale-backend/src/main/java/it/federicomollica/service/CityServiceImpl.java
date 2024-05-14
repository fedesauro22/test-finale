package it.federicomollica.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.federicomollica.dao.CityDao;
import it.federicomollica.dto.CityDto;
import it.federicomollica.model.City;

@Service
public class CityServiceImpl implements CityService {
	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	CityDao cityDao;
	
	@Override
	public List<CityDto> getAllCities() {
		List<City> cities = (List<City>) cityDao.findAll();
		List<CityDto> cityDtos = new ArrayList<>();
		cities.forEach(city-> cityDtos.add(modelMapper.map(city, CityDto.class)));

		return cityDtos;
	}
	
	@Override
	public boolean existsCityName(String name) {
		return cityDao.existsByName(name);
	}

	@Override
	public CityDto getCityDto(String name) {
		City city = cityDao.findByName(name);
		CityDto cityDto = modelMapper.map(city, CityDto.class);
		return cityDto;
	}

}
