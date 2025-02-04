package org.jsp.CDA.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.Dao.UserDao;
import org.jsp.CDA.entities.User;
import org.jsp.CDA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private UserRepository repo;

	@Override
	public Optional<User> findByUsernameAndPassword(String username, String password) {
		return repo.findByUsernameAndPassword(username,password);
	}

	@Override
	public User saveUser(User user) {
		return repo.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return repo.findAll();
	}

	@Override
	public Optional<User> findUserById(int id) {
		return repo.findById(id);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	@Override
	public List<User> searchByName(String name) {
		// TODO Auto-generated method stub
		return repo.findAllByName(name);
	}

	@Override
	public List<User> searchUserByUsername(String username) {
		// TODO Auto-generated method stub
		return repo.findAllByUsername(username);
	}

}
