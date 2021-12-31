package com.cg.ems.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dept_tbl")
public class Department {
	@Id
	int departId;
	@Column(name="d_name")
	String departName;
	
	@OneToOne(mappedBy="department",cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id")
	Employee employee;
	
	@OneToOne(mappedBy = "department")
	@JoinColumn(name="comp_id")
	Compliance compliance;
	
	@OneToOne(mappedBy = "department")
	@JoinColumn(name="sts_id")
	StatusReport statusreport;
	
	public Department() {
		super();
	}
	
	public Department(int departId, String departName) {
		super();
		this.departId = departId;
		this.departName = departName;
	}
	
	public int getDepartId() {
		return departId;
	}
	public void setDepartId(int departId) {
		this.departId = departId;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	@Override
	public String toString() {
		return "Department [departId=" + departId + ", departName=" + departName + "]";
	}
	
}
