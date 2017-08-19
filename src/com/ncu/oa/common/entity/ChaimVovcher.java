package com.ncu.oa.common.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * ChaimVovcher entity. @author MyEclipse Persistence Tools
 */

public class ChaimVovcher implements java.io.Serializable {

	// Fields

	private Integer cvId;
	
	@JSONField(serialize = false)
	private Role role;
	
	@JSONField(serialize = false)
	private User user;
	
	private Date cvCreateTime;
	private Date cvModifyTime;
	private String cvStatus;
	private String formType;
	
	
	@JSONField(serialize=false)
	private Set checkResults = new HashSet(0);
	
	@JSONField(serialize=false)
	private Set leaveForms = new HashSet(0);
	
	@JSONField(serialize=false)
	private Set expenseForms = new HashSet(0);
	
	@JSONField(serialize=false)
	private Set overtimeForms = new HashSet(0);

	// Constructors

	/** default constructor */
	public ChaimVovcher() {
	}

	/** minimal constructor */
	public ChaimVovcher(Date cvCreateTime, String cvStatus) {
		this.cvCreateTime = cvCreateTime;
		this.cvStatus = cvStatus;
	}

	/** full constructor */
	public ChaimVovcher(Role role, User user, Date cvCreateTime,
			Date cvModifyTime, String cvStatus, String formType,
			Set checkResults, Set leaveForms, Set expenseForms,
			Set overtimeForms) {
		this.role = role;
		this.user = user;
		this.cvCreateTime = cvCreateTime;
		this.cvModifyTime = cvModifyTime;
		this.cvStatus = cvStatus;
		this.formType = formType;
		this.checkResults = checkResults;
		this.leaveForms = leaveForms;
		this.expenseForms = expenseForms;
		this.overtimeForms = overtimeForms;
	}

	// Property accessors

	public Integer getCvId() {
		return this.cvId;
	}

	public void setCvId(Integer cvId) {
		this.cvId = cvId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCvCreateTime() {
		return this.cvCreateTime;
	}

	public void setCvCreateTime(Date cvCreateTime) {
		this.cvCreateTime = cvCreateTime;
	}

	public Date getCvModifyTime() {
		return this.cvModifyTime;
	}

	public void setCvModifyTime(Date cvModifyTime) {
		this.cvModifyTime = cvModifyTime;
	}

	public String getCvStatus() {
		return this.cvStatus;
	}

	public void setCvStatus(String cvStatus) {
		this.cvStatus = cvStatus;
	}

	public String getFormType() {
		return this.formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public Set getCheckResults() {
		return this.checkResults;
	}

	public void setCheckResults(Set checkResults) {
		this.checkResults = checkResults;
	}

	public Set getLeaveForms() {
		return this.leaveForms;
	}

	public void setLeaveForms(Set leaveForms) {
		this.leaveForms = leaveForms;
	}

	public Set getExpenseForms() {
		return this.expenseForms;
	}

	public void setExpenseForms(Set expenseForms) {
		this.expenseForms = expenseForms;
	}

	public Set getOvertimeForms() {
		return this.overtimeForms;
	}

	public void setOvertimeForms(Set overtimeForms) {
		this.overtimeForms = overtimeForms;
	}

	@Override
	public String toString() {
		return "ChaimVovcher [cvId=" + cvId + ", role=" + role
				+ ", cvCreateTime=" + cvCreateTime + ", cvModifyTime="
				+ cvModifyTime + ", cvStatus=" + cvStatus + ", formType="
				+ formType + ", checkResults=" + checkResults + ", leaveForms="
				+ leaveForms + ", expenseForms=" + expenseForms
				+ ", overtimeForms=" + overtimeForms + "]";
	}

}