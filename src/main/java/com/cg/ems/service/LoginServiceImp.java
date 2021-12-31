package com.cg.ems.service;
	
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MissingPathVariableException;

import com.cg.ems.dao.ILoginRepository;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.exception.LoginException;
import com.cg.ems.model.User;

@Service
public class LoginServiceImp implements ILoginService{
	@Autowired
	ILoginRepository dao;
	
	@SuppressWarnings("unused")
	@Override
	 public User validateUser(User user) throws LoginException{
		
		if(dao.existsById(user.getUserId()))
		{
			Optional<User> us=dao.findById(user.getUserId());
			User u1 = us.get();
			if(u1.getPassword().equals(user.getPassword())&&u1.getRole().equals(user.getRole()) && u1.getResult()==user.getResult())
			return user;

		}
		throw new LoginException("User details are invalid");
	}
			
		public List<User> getallusers()
	{
		List<User> ulist =dao.findAll();
		return ulist;
	}
		}
	
	

