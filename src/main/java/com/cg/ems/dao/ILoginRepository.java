	package com.cg.ems.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ems.model.User;

@Repository
public interface ILoginRepository extends JpaRepository<User, Integer>{

	
	@Query("select u from User u where u.userId=:u1")
	public List<User> getUser(@Param("u1") int userId);
	@Query("select u from User u where u in :user1")
	public User validate(@Param ("user1")User user);
	
//	@Query("select u from user u where u.password=:u2")
//
//	public List<User> exitsByPassword(@Param("u2") String password);
//	
//	@Query("select u from user u where u.role=:u3")
//	public List<User> existsByRole(@Param ("u3")String role);
//	
//	@Query("select u from user u where u.result=:u4")
//	public List<User> existsByResult(int result);

	

}
