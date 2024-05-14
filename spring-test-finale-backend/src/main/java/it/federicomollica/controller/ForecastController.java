package it.federicomollica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import it.federicomollica.dto.ForecastSaveDto;
import it.federicomollica.dto.UserForecastDto;
import it.federicomollica.service.ForecastService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/forecast")
public class ForecastController {

	@Autowired
	ForecastService forecastService;
	
	@PUT
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertForecast(@RequestBody ForecastSaveDto forecastSaveDto) {
		try {
			forecastService.insertForecast(forecastSaveDto);
			return Response.status(Response.Status.OK).build();
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserForecasts(@QueryParam("id") int userId) {
		try {
			List<UserForecastDto> userForecasts = forecastService.getUserForecasts(userId);
			return Response.status(Response.Status.OK).entity(userForecasts).build();
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
}


