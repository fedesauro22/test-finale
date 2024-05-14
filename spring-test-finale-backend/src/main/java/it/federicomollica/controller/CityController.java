package it.federicomollica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.federicomollica.dto.CityDto;
import it.federicomollica.service.CityService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/city")
public class CityController {
	
	@Autowired
	CityService cityService;
	
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCities() {
		try {
			List<CityDto> cityDtos  = cityService.getAllCities();
			return Response.status(Status.OK).entity(cityDtos).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/get/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCity(@PathParam("name") String name) {
		try {
			if(cityService.existsCityName(name)) {
				CityDto cityDto = cityService.getCityDto(name);
				return Response.status(Status.OK).entity(cityDto).build();
			}
			return Response.status(Status.BAD_REQUEST).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
}
