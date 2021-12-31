package com.cg.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ems.model.StatusReport;


@Repository
public interface IStatusReportRepository extends JpaRepository<StatusReport, Integer> {
	
	@Query("select s from StatusReport s where s.userId=:uid and s.complianceId=:cid")
	public List<StatusReport> getAllStatusReport(@Param("uid")int userId, @Param("cid")int complianceId);

}
