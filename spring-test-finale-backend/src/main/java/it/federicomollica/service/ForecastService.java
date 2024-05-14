package it.federicomollica.service;

import java.util.List;

import it.federicomollica.dto.ForecastSaveDto;
import it.federicomollica.dto.UserForecastDto;

public interface ForecastService {

	void insertForecast(ForecastSaveDto forecastSaveDto);

	List<UserForecastDto> getUserForecasts(int userId);

}
