package org.jsp.CDA.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.entities.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

	Optional<User> findByUsernameAndPassword(String username, String password);

	User saveUser(User user);

	List<User> findAllUsers();

	Optional<User> findUserById(int id);

	void delete(int id);

}
