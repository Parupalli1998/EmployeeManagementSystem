package com.cg.ems.service;

import java.util.List;

import com.cg.ems.exception.StatusReportException;
import com.cg.ems.model.StatusReport;

public interface IStatusReportService {
	public List<StatusReport> getSR() throws StatusReportException;
	void createStatusReport(StatusReport statusreport) throws StatusReportException;
	public List<StatusReport> getAllStatusReport(int userId, int complianceId) throws StatusReportException;

}
