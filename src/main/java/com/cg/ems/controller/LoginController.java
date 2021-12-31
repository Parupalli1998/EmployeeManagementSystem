package com.cg.ems.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.error.ErrorInfo;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.exception.LoginException;
import com.cg.ems.model.User;
import com.cg.ems.service.ILoginService;

@RestController

public class LoginController {
	@Autowired
	ILoginService service;
	
	
	
	@ExceptionHandler(LoginException.class)
	public @ResponseBody ErrorInfo getComplianceExeptionHandler4(Exception e, HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(), e.getMessage(),req.getRequestURI());
	}
	
	@GetMapping("/allusers")
	public List<User> getallusers()
	{
		List<User> ulist = service.getallusers();
		return ulist;
	}
	
	@PostMapping("/validateBody")
	
	public User validateUser(@Validated @RequestBody User user) throws LoginException
	{
		User u= service.validateUser(user);
		return u;
			
		
	}
	

	
}
