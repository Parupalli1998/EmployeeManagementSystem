package com.cg.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.IStatusReportRepository;
import com.cg.ems.exception.StatusReportException;
import com.cg.ems.model.StatusReport;

@Service
public class StatusReportServiceImp implements IStatusReportService {
	@Autowired
	IStatusReportRepository dao;
	
	public List<StatusReport> getSR() throws StatusReportException{
		List<StatusReport> sList = dao.findAll();
		if(sList.isEmpty()) {
			throw new StatusReportException("StatusReport is empty");
		}
		else {
			return sList;
		}
	}
	
	public void createStatusReport(StatusReport statusreport) throws StatusReportException{
		if(dao.existsById(statusreport.getStatusId()))
			throw new StatusReportException("StatusId is already present");
		else {
			dao.save(statusreport);
		}
	}
	
	
	public List<StatusReport> getAllStatusReport (int userId, int complianceId){
		List<StatusReport> sList = dao.getAllStatusReport(userId, complianceId);
		return sList;
	}

}
