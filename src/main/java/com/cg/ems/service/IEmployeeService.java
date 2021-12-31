package com.cg.ems.service;

import java.util.List;

import com.cg.ems.exception.EmployeeException;
import com.cg.ems.model.Employee;

public interface IEmployeeService {
	public Employee addEmployee(Employee emp) throws EmployeeException;
	public void deleteEmployee(int id) throws EmployeeException;
	public Employee updateEmployee(Employee emp) throws EmployeeException;
	public List<Employee> getAllEmployees() throws EmployeeException;
	public Employee getEmployeeById(int userId) throws EmployeeException;
	//public int getEmployeeCount() throws EmployeeException;
	public int getEmployeeCount() throws EmployeeException;

}