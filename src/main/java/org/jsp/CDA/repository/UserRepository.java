package org.jsp.CDA.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsernameAndPassword(String username, String password);

	List<User> findByName(String name);
	
	@Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
	List<User> findAllByName(@Param("name") String name);

	@Query("SELECT u FROM User u WHERE u.username LIKE %:username%")
	List<User> findAllByUsername(String username);

}
