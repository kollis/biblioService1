package com.sow.biblio.service.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name="DEPARTMENT", schema="SOWJANYA")
public class Department2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="DEPT_ID_GENERATOR", sequenceName="SOWJANYA.DEPT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPT_ID_GENERATOR")
	@Column(name="DEPT_ID")
	private long deptId;
	@Column(name="DEPT_NAME")
	private String deptName;
	@Column(name="DEPT_DESC")
	private String deptDesc;
	
	@OneToMany(mappedBy="department")
	@BatchSize(size=10)
	private Set<Employee2> employees;
	
	public Set<Employee2> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee2> employees) {
		this.employees = employees;
	}
	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
}
