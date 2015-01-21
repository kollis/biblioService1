package com.sow.biblio.service.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name="EMPLOYEE", schema="SOWJANYA")
public class Employee2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="EMP_ID_GENERATOR", sequenceName="SOWJANYA.EMP_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_ID_GENERATOR")
	@Column(name="EMP_ID")
	private long empId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="DESIGNATION")
	private String designation;
	
	@ManyToOne (cascade = {CascadeType.PERSIST})
    @JoinColumn(name="DEPT_ID")
	private Department2 department;  
	
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Department2 getDepartment() {
		return department;
	}
	public void setDepartment(Department2 department) {
		this.department = department;
	}
}
