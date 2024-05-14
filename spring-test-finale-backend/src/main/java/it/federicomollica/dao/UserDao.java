package it.federicomollica.dao;

import org.springframework.data.repository.CrudRepository;

import it.federicomollica.model.User;

public interface UserDao extends CrudRepository<User, Integer> {
	User findByEmailAndPassword(String email, String password);
	boolean existsByEmail(String email);
	User findByEmail(String email);
}
