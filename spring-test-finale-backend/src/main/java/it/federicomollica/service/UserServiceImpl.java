package it.federicomollica.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.federicomollica.dao.UserDao;
import it.federicomollica.dto.UserLoginRequestDto;
import it.federicomollica.dto.UserRegisterDto;
import it.federicomollica.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void registerUser(UserRegisterDto userRegisterDto) {
		String password = DigestUtils.sha256Hex(userRegisterDto.getPassword());
		userRegisterDto.setPassword(password);

		User user = new User();
		user.setFirstname(userRegisterDto.getFirstname());
		user.setLastname(userRegisterDto.getLastname());
		user.setEmail(userRegisterDto.getEmail());
		user.setPassword(password);

		userDao.save(user);

	}

	@Override
	public boolean loginUser(UserLoginRequestDto userLoginRequestDto) {
		User user = new User();
		user.setEmail(userLoginRequestDto.getEmail());
		user.setPassword(userLoginRequestDto.getPassword());
		String passwordHash = DigestUtils.sha256Hex(user.getPassword());

		User userCredential = userDao.findByEmailAndPassword(user.getEmail(), passwordHash);
		return userCredential != null ? true : false;
	}

	@Override
	public boolean existsUserEmail(String email) {
		return userDao.existsByEmail(email);
	}

	@Override
	public User findUserByEmail(String email) {
		return userDao.findByEmail(email);
	}

}
