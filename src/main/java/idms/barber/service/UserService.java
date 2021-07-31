package idms.barber.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import idms.barber.model.User;

public interface UserService {

	List<User> findAll();
	User findeOne(int id);
	User save(User user);
	User delete(int id);
	User findByUsernameAndPassword(String username, String password);
	UserDetails loadUserByUsername(String username);
}
