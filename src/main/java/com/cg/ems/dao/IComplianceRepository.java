package com.cg.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ems.model.Compliance;

@Repository
public interface IComplianceRepository extends JpaRepository<Compliance, Integer>{
	
	@Query("select u from Compliance u where u.complianceId=:u1")
	public List<Compliance> getAllRL(@Param("u1") int complianceId);
}