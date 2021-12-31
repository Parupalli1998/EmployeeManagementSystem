package com.cg.ems.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.error.ErrorInfo;
import com.cg.ems.exception.StatusReportException;
import com.cg.ems.model.StatusReport;
import com.cg.ems.service.StatusReportServiceImp;

@RestController
public class StatusReportController {
	@Autowired
	StatusReportServiceImp service;
	
	@ExceptionHandler(StatusReportException.class)
	public @ResponseBody ErrorInfo getStatusReportExeptionHandler5(Exception e, HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(), e.getMessage(),req.getRequestURI());
	}
	
	@GetMapping("/getsr")
	public List<StatusReport> getSR() throws StatusReportException{
		return service.getSR();
	}
	
	@PostMapping("/screate")
	public void createStatusReport(@RequestBody StatusReport statusreport) throws StatusReportException{
		service.createStatusReport(statusreport);
	}
	
	@GetMapping("/getsr/{userid}/{compid}")
	public List<StatusReport> getAllStatusReport(@PathVariable("userid") int userId,@PathVariable("compid") int complianceId) throws StatusReportException{
		return service.getAllStatusReport(userId, complianceId);
	}

}





