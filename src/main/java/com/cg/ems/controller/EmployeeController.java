package com.cg.ems.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.error.ErrorInfo;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.model.Employee;
import com.cg.ems.service.IEmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	IEmployeeService service;
	
	@ExceptionHandler(EmployeeException.class)
	public @ResponseBody ErrorInfo getComplianceExeptionHandler4(Exception e, HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(), e.getMessage(),req.getRequestURI());
	}
	
	@PostMapping("/addemp")
	public Employee addEmployee(@RequestBody Employee emp) throws EmployeeException {
		Employee e =service.addEmployee(emp);
		return e;
	}
	
	@DeleteMapping("/delemp/{userId}")
	public void deleteEmployee(@PathVariable("userId") int id) throws EmployeeException{
		this.service.deleteEmployee(id);
	}
	
	@PutMapping("/updateemp")
	public Employee updateEmployee(@RequestBody Employee emp) throws EmployeeException {
		return service.updateEmployee(emp);	
	}
	
	@GetMapping("/allemp")
	public List<Employee> getAllEmployees() throws EmployeeException {
		List<Employee> eList=  service.getAllEmployees();
		return eList;
	}
	
	@GetMapping("/getemp/{userId}")
	public Employee getEmployeeById(@PathVariable ("userId")int userId) throws EmployeeException
	{
		return service.getEmployeeById(userId);
	}
	
	@GetMapping("/empcount")
	public int getEmployeeCount() throws EmployeeException
	{
		return service.getEmployeeCount();
	}

}


