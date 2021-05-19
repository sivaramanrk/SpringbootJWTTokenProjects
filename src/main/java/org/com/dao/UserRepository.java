package org.com.dao;

import org.com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//public interface UserRepository extends CrudRepository<User, Integer>{

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
	@Query(value = "select u From User u where u.firstName=:firstName and u.password=:password")
	public User findusernameandpassword(@Param("firstName") String firstName,@Param("password") String password);

}
