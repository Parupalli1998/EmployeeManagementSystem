package com.cg.ems.service;

import java.util.List;

import com.cg.ems.exception.DepartmentException;
import com.cg.ems.model.Department;

public interface IDepartmentService {
	public void addDepartment(Department department)throws DepartmentException;
	public List<Department> getallDepartments()throws DepartmentException;
	public int getallDepartCount()throws DepartmentException;
	public boolean deleteDepartment(int departId)throws DepartmentException;

}
