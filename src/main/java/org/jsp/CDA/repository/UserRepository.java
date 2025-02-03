package org.jsp.CDA.repository;

import java.util.Optional;

import org.jsp.CDA.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsernameAndPassword(String username, String password);

}
