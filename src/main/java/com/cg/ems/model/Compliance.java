package com.cg.ems.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="comp_tbl")
public class Compliance {
	@Id
	int complianceId;
	@Column(name="c_rltype")
	String rltype;
	@Column(name="c_details")
	String details;
	@Column(name="c_date")
	LocalDate createDate;
	@Column(name="c_empcount")
	int empCount;
	@Column(name="c_stscount")
	int stsCount;
	@Column(name="c_status")
	String status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="deptid")
	Department department;
	
	public Compliance() {
		super();
	}
	
	public Compliance(int complianceId, String rltype, String details, LocalDate createDate, int empCount, int stsCount,
			String status) {
		super();
		this.complianceId = complianceId;
		this.rltype = rltype;
		this.details = details;
		this.createDate = createDate;
		this.empCount = empCount;
		this.stsCount = stsCount;
		this.status = status;
	}
	
//	public StatusReport getStatusreport() {
//		return statusreport;
//	}
//
//	public void setStatusreport(StatusReport statusreport) {
//		this.statusreport = statusreport;
//	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getComplianceId() {
		return complianceId;
	}

	public void setComplianceId(int complianceId) {
		this.complianceId = complianceId;
	}
	public String getRltype() {
		return rltype;
	}
	public void setRltype(String rltype) {
		this.rltype = rltype;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public int getEmpCount() {
		return empCount;
	}
	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}
	public int getStsCount() {
		return stsCount;
	}
	public void setStsCount(int stsCount) {
		this.stsCount = stsCount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Compliance [complianceId=" + complianceId + ", rltype=" + rltype + ", details=" + details
				+ ", createDate=" + createDate + ", empCount=" + empCount + ", stsCount=" + stsCount + ", status="
				+ status + "]";
	}
	
	

}
