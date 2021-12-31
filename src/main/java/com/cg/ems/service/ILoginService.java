package com.cg.ems.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;

import com.cg.ems.exception.EmployeeException;
import com.cg.ems.exception.LoginException;
import com.cg.ems.model.User;

public interface ILoginService{
	
	public User validateUser(User user) throws LoginException;
	public List<User> getallusers();
	
	
}
