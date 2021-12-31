package com.cg.ems.service;

import java.util.List;

import com.cg.ems.exception.ComplianceException;
import com.cg.ems.model.Compliance;

public interface IComplianceService {
	public void createRL(Compliance co) throws ComplianceException;
	public List<Compliance> getAllRL() throws ComplianceException;
	public List<Compliance> getAllRL(int complianceId) ;

}
