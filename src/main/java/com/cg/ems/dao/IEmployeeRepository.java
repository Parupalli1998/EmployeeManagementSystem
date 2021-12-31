package com.cg.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

	//boolean existsById(Employee emp);

}
