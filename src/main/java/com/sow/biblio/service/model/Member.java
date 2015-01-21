package com.sow.biblio.service.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="MEMBER", schema="SOWJANYA")
public class Member implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEMBER_ID_GENERATOR", sequenceName="SOWJANYA.MEMBER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEMBER_ID_GENERATOR")
	@Column(name="MEMBER_ID")
	private long memberId;
	
	@Column(name="MEMBER_NAME")
	private String memberName;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ADDRESS_ID", updatable=true)
	private Address address;

	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="JOIN_DATE")
	private Calendar joinDate;

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Calendar getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Calendar joinDate) {
		this.joinDate = joinDate;
	}
}