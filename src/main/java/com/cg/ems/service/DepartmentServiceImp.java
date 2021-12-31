package com.cg.ems.service;

//import java.time.LocalDateTime;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.ExceptionHandler;

//import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.ems.dao.IDepartmentRepository;
//import com.cg.ems.error.ErrorInfo;
import com.cg.ems.exception.DepartmentException;
import com.cg.ems.model.Department;

@Service
public class DepartmentServiceImp implements IDepartmentService{
	@Autowired
	IDepartmentRepository dao;

	@Override
public void addDepartment(Department department)throws DepartmentException{
			if(dao.existsById(department.getDepartId())) 
				throw new DepartmentException("Department  ID already exits");
			
			else
				dao.save(department);
		}
	
	

	public List<Department> getallDepartments() throws DepartmentException{
		List<Department> dList = dao.findAll();
		if(dList.isEmpty()) {
			throw new DepartmentException("Department records not found");
		}
		else
		   return dList;
	}
	@Override
	public int getallDepartCount() throws DepartmentException {
			int d = (int)dao.count();
			if(d==0)
			{
				throw new DepartmentException("table is empty");
			}
			else
	        	return d;
		}
	
	@Override
	public boolean deleteDepartment(int departId)throws DepartmentException {
		
		
		if(dao.existsById(departId)) {
    		
    		dao.deleteById(departId);
    		return true;
    	}
		else {
			
			throw new DepartmentException("Department  not found");

			
    	    
		}
		
	}
	
	}

