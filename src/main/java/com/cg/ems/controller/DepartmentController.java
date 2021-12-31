package com.cg.ems.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.error.ErrorInfo;
import com.cg.ems.exception.DepartmentException;
import com.cg.ems.model.Department;
import com.cg.ems.service.IDepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	IDepartmentService service;
	@ExceptionHandler(DepartmentException.class)
	public @ResponseBody ErrorInfo getDepartment(Exception e, HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(), e.getMessage(),req.getRequestURI());
	}


	
	@PostMapping("/adddept/{departId}")
	public void  addDepartment(@RequestBody Department department) throws DepartmentException{
		service.addDepartment(department);
	}		
	
	@GetMapping("/getdept")
	public List<Department> getallDepartments() throws DepartmentException{
		List<Department> dList = service.getallDepartments();
		return dList;
	}
	
	@GetMapping("/deptcount")
	public int getallDepartCount()throws DepartmentException {
		int d = (int)service.getallDepartCount();
		return d;
	}
	
	@DeleteMapping("/deldept/{id}")
	public boolean deleteDepartment(@PathVariable("id") int departId) throws DepartmentException {
		return service.deleteDepartment(departId);
	}

}
