package it.federicomollica.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.federicomollica.dao.CityDao;
import it.federicomollica.dao.ForecastDao;
import it.federicomollica.dao.PrecipitationDao;
import it.federicomollica.dao.TemperatureDao;
import it.federicomollica.dao.UserDao;
import it.federicomollica.dto.ForecastSaveDto;
import it.federicomollica.dto.UserForecastDto;
import it.federicomollica.model.City;
import it.federicomollica.model.Forecast;
import it.federicomollica.model.Precipitation;
import it.federicomollica.model.Temperature;
import it.federicomollica.model.User;

@Service
public class ForecastServiceImpl implements ForecastService {
	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	ForecastDao forecastDao;

	@Autowired
	PrecipitationDao precipitationDao;

	@Autowired
	TemperatureDao temperatureDao;

	@Autowired
	CityDao cityDao;

	@Autowired
	UserDao userDao;

	@Override
	public void insertForecast(ForecastSaveDto forecastSaveDto) {
		Forecast forecast = new Forecast();
		Optional<City> cityOptional = cityDao.findById(forecastSaveDto.getCityId());
		Optional<User> userOptional = userDao.findById(forecastSaveDto.getUserId());
		if (cityOptional.isPresent() && userOptional.isPresent()) {
			City city = cityOptional.get();
			User user = userOptional.get();
			forecast.setCity(city);
			forecast.setDate_forecast(forecastSaveDto.getDate_forecast());
			forecast.setUser(user);
			List<Precipitation> precipitations = new ArrayList<>();
			forecastSaveDto.getPrecipitations()
					.forEach(precipitation -> precipitations.add(modelMapper.map(precipitation, Precipitation.class)));
			forecast.setPrecipitations(precipitations);
			List<Temperature> temperatures = new ArrayList<>();
			forecastSaveDto.getTemperatures()
					.forEach(temperature -> temperatures.add(modelMapper.map(temperature, Temperature.class)));
			forecast.setTemperatures(temperatures);
			forecastDao.save(forecast);

			for (Precipitation precipitation : precipitations) {
				precipitation.setForecast(forecast);
				precipitationDao.save(precipitation);
			}
			for (Temperature temperature : temperatures) {
				temperature.setForecast(forecast);
				temperatureDao.save(temperature);
			}
		}

	}

	@Override
	public List<UserForecastDto> getUserForecasts(int userId) {
		List<Forecast> forecasts = forecastDao.findByUserId(userId);
		List<UserForecastDto> forecastDtos = new ArrayList<>();
		forecasts.forEach(forecast -> forecastDtos.add(modelMapper.map(forecast, UserForecastDto.class)));
		return forecastDtos;
	}

}
