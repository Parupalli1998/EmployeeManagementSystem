package com.cg.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.IEmployeeRepository;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.model.Employee;

@Service
public class EmployeeServiceImp implements IEmployeeService{
	@Autowired
	IEmployeeRepository dao;
	
	
	public Employee addEmployee(Employee emp) throws EmployeeException{
		if(dao.existsById(emp.getUserId())) {
			throw new EmployeeException("User Id already exits");
		}else {
		Employee e = dao.save(emp);
		return e;
	}
		
			}
			
			
	
	public void deleteEmployee(int id) throws EmployeeException
	{
		if(dao.existsById(id)) {
		this.dao.deleteById(id);
		}
		else {
			throw new EmployeeException("Employee with this ID not found!!");
		}
		
	}
	
	public Employee updateEmployee(Employee emp) throws EmployeeException{
		if(dao.existsById(emp.getUserId())) {
			
		Employee e = dao.save(emp);
		return e;
	}
		else {
			throw new EmployeeException("employee id not exists");
		}
	}
	
	public List<Employee> getAllEmployees() throws EmployeeException{
		List<Employee> empList = dao.findAll();
		if(empList.isEmpty()) {
			throw new EmployeeException("No Employee is there");
		}else {
		return empList;
	}
	}
	public Employee getEmployeeById(int userId) throws EmployeeException
	{
		if(dao.existsById(userId)) {
		Employee emp = dao.findById(userId).get();
		return emp;
	}else {
		throw new EmployeeException("No Employee with this Id exists");
	}
	}
	
	public int getEmployeeCount() throws EmployeeException
	{ 
		
		int e = (int) dao.count();
		if(e==0) {
			throw new EmployeeException("Table is empty");
			
		}else {
		return e;
	}
	}
		
	}
	

