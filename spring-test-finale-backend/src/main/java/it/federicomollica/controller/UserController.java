package it.federicomollica.controller;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.federicomollica.dto.UserLoginRequestDto;
import it.federicomollica.dto.UserLoginResponseDto;
import it.federicomollica.dto.UserRegisterDto;
import it.federicomollica.model.User;
import it.federicomollica.service.UserService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUser(@Valid @RequestBody UserRegisterDto userRegisterDto) {
		try {
			if (!Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}",
					userRegisterDto.getPassword())) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			if (userService.existsUserEmail(userRegisterDto.getEmail())) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			userService.registerUser(userRegisterDto);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUtente(@RequestBody UserLoginRequestDto userLoginRequestDto) {
		try {
			if (userService.loginUser(userLoginRequestDto)) {
				return Response.status(Status.OK).entity(issueToken(userLoginRequestDto.getEmail())).build();
			}
			return Response.status(Status.BAD_REQUEST).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	private UserLoginResponseDto issueToken(String email) {
		byte[] secretKey = "enzomaccoeeelkkklwkekwkkrelkm232123213".getBytes();
		Key key = Keys.hmacShaKeyFor(secretKey);
		User userInformation = userService.findUserByEmail(email);
		Map<String, Object> map = new HashMap<>();
		map.put("id", userInformation.getId());
		map.put("firstname", userInformation.getFirstname());
		map.put("lastname", userInformation.getLastname());
		map.put("email", userInformation.getEmail());

		Date creation = new Date();
		Date end = java.sql.Timestamp.valueOf(LocalDateTime.now().plusMinutes(15L));
		String jwtToken = Jwts.builder()
								.setClaims(map)
								.setIssuer("http://localhost:8080")
								.setIssuedAt(creation)
								.setExpiration(end)
								.signWith(key)
								.compact();
		UserLoginResponseDto token = new UserLoginResponseDto();
		token.setToken(jwtToken);
		token.setTtl(end);
		token.setTokenCreationTime(creation);
		return token;
	}
}
