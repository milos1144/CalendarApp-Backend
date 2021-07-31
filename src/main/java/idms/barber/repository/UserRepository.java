package idms.barber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import idms.barber.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsernameAndPassword(String username, String password);

	@Query("SELECT u FROM User u WHERE u.id=:id")
	User findOne(@Param("id") int id);

	UserDetails findByUsername(String username);
	
	@Query("SELECT u FROM User u WHERE u.username=:username")
	User findUserByName(@Param("username") String username);
}
