package it.federicomollica.service;

import it.federicomollica.dto.UserLoginRequestDto;
import it.federicomollica.dto.UserRegisterDto;
import it.federicomollica.model.User;

public interface UserService {
	void registerUser(UserRegisterDto userRegisterDto);
	boolean loginUser(UserLoginRequestDto userLoginRequestDto);
	boolean existsUserEmail(String email);
	User findUserByEmail(String email);
}
