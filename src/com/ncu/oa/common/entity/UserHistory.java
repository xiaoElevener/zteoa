package com.ncu.oa.common.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * UserHistory entity. @author MyEclipse Persistence Tools
 */

public class UserHistory implements java.io.Serializable {

	// Fields

	private Integer uhId;
	private User user;
	
	@JSONField (format="yyyy-MM-dd")
	private Date uhStartTime;
	
	@JSONField (format="yyyy-MM-dd")
	private Date uhEndTime;
	
	private String uhEvent;

	// Constructors

	/** default constructor */
	public UserHistory() {
	}

	/** minimal constructor */
	public UserHistory(Date uhStartTime, Date uhEndTime, String uhEvent) {
		this.uhStartTime = uhStartTime;
		this.uhEndTime = uhEndTime;
		this.uhEvent = uhEvent;
	}

	/** full constructor */
	public UserHistory(User user, Date uhStartTime, Date uhEndTime,
			String uhEvent) {
		this.user = user;
		this.uhStartTime = uhStartTime;
		this.uhEndTime = uhEndTime;
		this.uhEvent = uhEvent;
	}

	// Property accessors

	public Integer getUhId() {
		return this.uhId;
	}

	public void setUhId(Integer uhId) {
		this.uhId = uhId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getUhStartTime() {
		return this.uhStartTime;
	}

	public void setUhStartTime(Date uhStartTime) {
		this.uhStartTime = uhStartTime;
	}

	public Date getUhEndTime() {
		return this.uhEndTime;
	}

	public void setUhEndTime(Date uhEndTime) {
		this.uhEndTime = uhEndTime;
	}

	public String getUhEvent() {
		return this.uhEvent;
	}

	public void setUhEvent(String uhEvent) {
		this.uhEvent = uhEvent;
	}

	@Override
	public String toString() {
		return "UserHistory [uhId=" + uhId + ", uhStartTime=" + uhStartTime
				+ ", uhEndTime=" + uhEndTime + ", uhEvent=" + uhEvent + "]";
	}

	
}