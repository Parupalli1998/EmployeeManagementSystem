package com.cg.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.model.Department;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Integer>{

	

	

}
