package com.ncu.oa.common.entity;

import java.util.Date;

/**
 * CheckResult entity. @author MyEclipse Persistence Tools
 */

public class CheckResult implements java.io.Serializable {

	// Fields

	private Integer ckId;
	private User user;
	private Role role;
	private ChaimVovcher chaimVovcher;
	private Date ckTime;
	private String ckResult;
	private String ckComm;

	// Constructors

	/** default constructor */
	public CheckResult() {
	}

	/** minimal constructor */
	public CheckResult(User user, Role role, ChaimVovcher chaimVovcher,
			Date ckTime, String ckResult) {
		this.user = user;
		this.role = role;
		this.chaimVovcher = chaimVovcher;
		this.ckTime = ckTime;
		this.ckResult = ckResult;
	}

	/** full constructor */
	public CheckResult(User user, Role role, ChaimVovcher chaimVovcher,
			Date ckTime, String ckResult, String ckComm) {
		this.user = user;
		this.role = role;
		this.chaimVovcher = chaimVovcher;
		this.ckTime = ckTime;
		this.ckResult = ckResult;
		this.ckComm = ckComm;
	}

	// Property accessors

	public Integer getCkId() {
		return this.ckId;
	}

	public void setCkId(Integer ckId) {
		this.ckId = ckId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public ChaimVovcher getChaimVovcher() {
		return this.chaimVovcher;
	}

	public void setChaimVovcher(ChaimVovcher chaimVovcher) {
		this.chaimVovcher = chaimVovcher;
	}

	public Date getCkTime() {
		return this.ckTime;
	}

	public void setCkTime(Date ckTime) {
		this.ckTime = ckTime;
	}

	public String getCkResult() {
		return this.ckResult;
	}

	public void setCkResult(String ckResult) {
		this.ckResult = ckResult;
	}

	public String getCkComm() {
		return this.ckComm;
	}

	public void setCkComm(String ckComm) {
		this.ckComm = ckComm;
	}

}