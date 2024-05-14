package it.federicomollica.dto;

import java.util.List;

public class ForecastSaveDto {
	private String date_forecast;
	private List<TemperatureDto> temperatures;
	private List<PrecipitationDto> precipitations;
	private int userId;
	private int cityId;

	public String getDate_forecast() {
		return date_forecast;
	}

	public void setDate_forecast(String date_forecast) {
		this.date_forecast = date_forecast;
	}

	public List<TemperatureDto> getTemperatures() {
		return temperatures;
	}

	public void setTemperatures(List<TemperatureDto> temperatures) {
		this.temperatures = temperatures;
	}

	public List<PrecipitationDto> getPrecipitations() {
		return precipitations;
	}

	public void setPrecipitations(List<PrecipitationDto> precipitations) {
		this.precipitations = precipitations;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

}
