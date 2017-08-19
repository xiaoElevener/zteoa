package com.ncu.oa.common.entity;

import java.sql.Timestamp;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Attendance entity. @author MyEclipse Persistence Tools
 */

public class Attendance implements java.io.Serializable {

	// Fields

	private Integer atId;
	@JSONField(serialize = false)
	private User user;

	@JSONField(format = "yyyy-MM-dd")
	private Date atWorkdate;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Timestamp atSigntime;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Timestamp atLeavetime;

	private Boolean atCheckLate;
	private Boolean atCheckLeaveEarly;
	private Boolean atCheckVacation;
	private Boolean atCheckOvertime;

	// Constructors

	/** default constructor */
	public Attendance() {
	}

	/** minimal constructor */
	public Attendance(User user, Date atWorkdate, Boolean atCheckLate,
			Boolean atCheckLeaveEarly, Boolean atCheckVacation,
			Boolean atCheckOvertime) {
		this.user = user;
		this.atWorkdate = atWorkdate;
		this.atCheckLate = atCheckLate;
		this.atCheckLeaveEarly = atCheckLeaveEarly;
		this.atCheckVacation = atCheckVacation;
		this.atCheckOvertime = atCheckOvertime;
	}

	/** full constructor */
	public Attendance(User user, Date atWorkdate, Timestamp atSigntime,
			Timestamp atLeavetime, Boolean atCheckLate,
			Boolean atCheckLeaveEarly, Boolean atCheckVacation,
			Boolean atCheckOvertime) {
		this.user = user;
		this.atWorkdate = atWorkdate;
		this.atSigntime = atSigntime;
		this.atLeavetime = atLeavetime;
		this.atCheckLate = atCheckLate;
		this.atCheckLeaveEarly = atCheckLeaveEarly;
		this.atCheckVacation = atCheckVacation;
		this.atCheckOvertime = atCheckOvertime;
	}

	// Property accessors

	@Override
	public String toString() {
		return "Attendance [atId=" + atId + ", user=" + user + ", atWorkdate="
				+ atWorkdate + ", atSigntime=" + atSigntime + ", atLeavetime="
				+ atLeavetime + ", atCheckLate=" + atCheckLate
				+ ", atCheckLeaveEarly=" + atCheckLeaveEarly
				+ ", atCheckVacation=" + atCheckVacation + ", atCheckOvertime="
				+ atCheckOvertime + "]";
	}

	public Integer getAtId() {
		return this.atId;
	}

	public void setAtId(Integer atId) {
		this.atId = atId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getAtWorkdate() {
		return this.atWorkdate;
	}

	public void setAtWorkdate(Date atWorkdate) {
		this.atWorkdate = atWorkdate;
	}

	public Timestamp getAtSigntime() {
		return this.atSigntime;
	}

	public void setAtSigntime(Timestamp atSigntime) {
		this.atSigntime = atSigntime;
	}

	public Timestamp getAtLeavetime() {
		return this.atLeavetime;
	}

	public void setAtLeavetime(Timestamp atLeavetime) {
		this.atLeavetime = atLeavetime;
	}

	public Boolean getAtCheckLate() {
		return this.atCheckLate;
	}

	public void setAtCheckLate(Boolean atCheckLate) {
		this.atCheckLate = atCheckLate;
	}

	public Boolean getAtCheckLeaveEarly() {
		return this.atCheckLeaveEarly;
	}

	public void setAtCheckLeaveEarly(Boolean atCheckLeaveEarly) {
		this.atCheckLeaveEarly = atCheckLeaveEarly;
	}

	public Boolean getAtCheckVacation() {
		return this.atCheckVacation;
	}

	public void setAtCheckVacation(Boolean atCheckVacation) {
		this.atCheckVacation = atCheckVacation;
	}

	public Boolean getAtCheckOvertime() {
		return this.atCheckOvertime;
	}

	public void setAtCheckOvertime(Boolean atCheckOvertime) {
		this.atCheckOvertime = atCheckOvertime;
	}

}