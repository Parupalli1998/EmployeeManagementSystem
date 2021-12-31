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
@Table(name="status_tbl")
public class StatusReport {
	@Id
	int statusId;
	@Column(name="s_cmts")
	String comments;
	@Column(name="s_details")
	String details;
	@Column(name="s_date")
	LocalDate createDate;
	@Column(name="s_userid")
	int userId;
	@Column(name="s_compid")
	int complianceId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="deptid")
	Department department;
	
	public StatusReport() {
		super();
	}

	public StatusReport(int statusId, String comments, String details, LocalDate createDate, int userId,
			int complianceId, Department department) {
		super();
		this.statusId = statusId;
		this.comments = comments;
		this.details = details;
		this.createDate = createDate;
		this.userId = userId;
		this.complianceId = complianceId;
		this.department = department;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getComplianceId() {
		return complianceId;
	}

	public void setComplianceId(int complianceId) {
		this.complianceId = complianceId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "StatusReport [statusId=" + statusId + ", comments=" + comments + ", details=" + details
				+ ", createDate=" + createDate + ", userId=" + userId + ", complianceId=" + complianceId
				+ ", department=" + department + "]";
	}
	
	
	
	
	

}
