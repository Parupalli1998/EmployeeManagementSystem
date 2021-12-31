package com.cg.ems.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.error.ErrorInfo;
import com.cg.ems.exception.ComplianceException;
import com.cg.ems.model.Compliance;

import com.cg.ems.service.ComplianceServiceImp;

@RestController
public class ComplianceController {
	@Autowired
	ComplianceServiceImp service;
	
	@ExceptionHandler(ComplianceException.class)
	public @ResponseBody ErrorInfo getComplianceExeptionHandler4(Exception e, HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(), e.getMessage(),req.getRequestURI());
	}
	
	@PostMapping("/createco")
	public void createRL(@RequestBody Compliance co) throws ComplianceException{
		service.createRL(co);
	}
	
	
	@GetMapping("/getcomp")
	public List<Compliance> getAllRL() throws ComplianceException{
		return  service.getAllRL();
	}
	
	@GetMapping("/getrl/{id}")
	public List<Compliance> getAllRL(@PathVariable("id") int complianceId) {
		return service.getAllRL(complianceId);
	}


	
}
