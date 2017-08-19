package com.ncu.oa.common.entity;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * UserSchedule entity. @author MyEclipse Persistence Tools
 */

public class UserSchedule implements java.io.Serializable {

	// Fields

	private Integer scId;
	private User user;
	private String scName;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Timestamp scStartTime;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Timestamp scEndTime;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Timestamp scNotifyTime;
	private String scComm;

	// Constructors

	/** default constructor */
	public UserSchedule() {
	}

	/** minimal constructor */
	public UserSchedule(User user, String scName, Timestamp scStartTime,
			Timestamp scEndTime, Timestamp scNotifyTime) {
		this.user = user;
		this.scName = scName;
		this.scStartTime = scStartTime;
		this.scEndTime = scEndTime;
		this.scNotifyTime = scNotifyTime;
	}

	/** full constructor */
	public UserSchedule(User user, String scName, Timestamp scStartTime,
			Timestamp scEndTime, Timestamp scNotifyTime, String scComm) {
		this.user = user;
		this.scName = scName;
		this.scStartTime = scStartTime;
		this.scEndTime = scEndTime;
		this.scNotifyTime = scNotifyTime;
		this.scComm = scComm;
	}

	// Property accessors

	public Integer getScId() {
		return this.scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getScName() {
		return this.scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public Timestamp getScStartTime() {
		return this.scStartTime;
	}

	public void setScStartTime(Timestamp scStartTime) {
		this.scStartTime = scStartTime;
	}

	public Timestamp getScEndTime() {
		return this.scEndTime;
	}

	public void setScEndTime(Timestamp scEndTime) {
		this.scEndTime = scEndTime;
	}

	public Timestamp getScNotifyTime() {
		return this.scNotifyTime;
	}

	public void setScNotifyTime(Timestamp scNotifyTime) {
		this.scNotifyTime = scNotifyTime;
	}

	public String getScComm() {
		return this.scComm;
	}

	public void setScComm(String scComm) {
		this.scComm = scComm;
	}

	@Override
	public String toString() {
		return "UserSchedule [scId=" + scId + ", user=" + user + ", scName="
				+ scName + ", scStartTime=" + scStartTime + ", scEndTime="
				+ scEndTime + ", scNotifyTime=" + scNotifyTime + ", scComm="
				+ scComm + "]";
	}

}