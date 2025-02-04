package org.jsp.CDA.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.Dao.AdminstratorDao;
import org.jsp.CDA.Dao.FacultyDao;
import org.jsp.CDA.Dao.StudentDao;
import org.jsp.CDA.Dao.UserDao;
import org.jsp.CDA.email.Helper;
import org.jsp.CDA.email.OTPgenerator;
import org.jsp.CDA.email.SendEmailService;
import org.jsp.CDA.entities.Adminstrator;
import org.jsp.CDA.entities.Faculty;
import org.jsp.CDA.entities.Student;
import org.jsp.CDA.entities.User;
import org.jsp.CDA.responsestructure.ResponseStructure;
import org.jsp.CDA.service.UserService;
import org.jsp.CDA.util.Role;
import org.jsp.CDA.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;
	
	@Autowired
	private SendEmailService sms;
	@Autowired
	private AdminstratorDao ado;
	@Autowired
	private FacultyDao fdo;
	@Autowired
	private StudentDao sdao;

	@Override
	public ResponseEntity<?> login(String username, String password) {
		Optional<User> optional=dao.findByUsernameAndPassword(username,password);
		if(optional.isEmpty()) {
			throw new RuntimeException("Invalid credentials unable to login...");
		}
		User user=optional.get();
		 String otp = OTPgenerator.generateOTP(6);
	      sms.sendotp(user.getEmail(), otp);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("login successfull...").body(user).build());
	}

	

	@Override
	public ResponseEntity<?> findAllUsers() {
		List<User> ul=dao.findAllUsers();
		if(ul.isEmpty()) {
			throw new RuntimeException("No user found in the database");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("users found successfull...").body(ul).build());
	}

	@Override
	public ResponseEntity<?> findUserById(int id) {
		Optional<User> user=dao.findUserById(id);
		if(user.isEmpty()) {
			throw new RuntimeException("invalid user id");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("user found successfull...").body(user.get()).build());
	}

	@Override
	public ResponseEntity<?> delete(int id) {
		Optional<User> user=dao.findUserById(id);
		if(user.isEmpty()) {
			throw new RuntimeException("invalid user id");
		}
		dao.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("user found successfull...").body("deleted successfuly..").build());
	}



	@Override
	public ResponseEntity<?> saveUser(User user) {
		int otp=Helper.getOTP();
		user.setOtp(otp);
		user.setStatus(Status.INACTIVE);
		User user2 = dao.saveUser(user);
		if(user2.getRole() == Role.ADMINSTRATOR) {
			ado.saveAdminstrator(Adminstrator.builder().user(user2).build());
		}
		else if(user2.getRole() == Role.FACULTY) {
			fdo.saveFaculty(Faculty.builder().user(user2).build());
		}
		else {
			sdao.saveStudent(Student.builder().user(user2).build());
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("user saved successfull...").body(user2).build());
	}




	@Override
	public ResponseEntity<?> findUserByName(String name) {
		List<User> optional=dao.findByName(name);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid user name");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("user found successfull...").body(optional).build());
	}



	@Override
	public ResponseEntity<?> searchUserByName(String name) {
		List<User> optional=dao.searchByName(name);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid user name");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("user found successfull...").body(optional).build());
	
	}

	@Override
	public ResponseEntity<?> searchUserByUsername(String username) {
		List<User> optional=dao.searchUserByUsername(username);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid username");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("user found successfull...").body(optional).build());
	}
	
	

}
