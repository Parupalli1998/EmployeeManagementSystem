package com.cg.ems.service;

import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.ems.dao.IComplianceRepository;
import com.cg.ems.error.ErrorInfo;
import com.cg.ems.exception.ComplianceException;
import com.cg.ems.model.Compliance;

@Service
public class ComplianceServiceImp implements IComplianceService{
	@Autowired
	IComplianceRepository dao;
	
	@ExceptionHandler(ComplianceException.class)
	public @ResponseBody ErrorInfo getComplianceExeptionHandler4(Exception e, HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(), e.getMessage(),req.getRequestURI());
	}
	
	public void createRL(Compliance co) throws ComplianceException{
		if(dao.existsById(co.getComplianceId()))
			throw new ComplianceException("ComplianceId already exist");
		else
		{
			dao.save(co);
		}
	}
	
	public List<Compliance> getAllRL() throws ComplianceException {
		List<Compliance> cList = dao.findAll();
		if(cList.isEmpty()) {
			throw new ComplianceException("Compliance is empty");
		}
		else {
			return cList;
		}
	}
	
	public List<Compliance> getAllRL(int complianceId){
		return dao.getAllRL(complianceId);
	}
	

}
