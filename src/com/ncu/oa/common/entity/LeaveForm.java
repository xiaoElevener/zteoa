package com.ncu.oa.common.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * LeaveForm entity. @author MyEclipse Persistence Tools
 */

public class LeaveForm implements java.io.Serializable {

	// Fields

	private Integer leFId;
	
	private ChaimVovcher chaimVovcher;
	
	private String leFReason;

	@JSONField(format = "yyyy-MM-dd")
	private Date leFStarttime;
	
	@JSONField(format = "yyyy-MM-dd")
	private Date leFEndtime;

	// Constructors

	/** default constructor */
	public LeaveForm() {
	}

	/** full constructor */
	public LeaveForm(Integer leFId, ChaimVovcher chaimVovcher,
			String leFReason, Date leFStarttime, Date leFEndtime) {
		this.leFId = leFId;
		this.chaimVovcher = chaimVovcher;
		this.leFReason = leFReason;
		this.leFStarttime = leFStarttime;
		this.leFEndtime = leFEndtime;
	}

	// Property accessors

	public Integer getLeFId() {
		return this.leFId;
	}

	public void setLeFId(Integer leFId) {
		this.leFId = leFId;
	}

	public ChaimVovcher getChaimVovcher() {
		return this.chaimVovcher;
	}

	public void setChaimVovcher(ChaimVovcher chaimVovcher) {
		this.chaimVovcher = chaimVovcher;
	}

	public String getLeFReason() {
		return this.leFReason;
	}

	public void setLeFReason(String leFReason) {
		this.leFReason = leFReason;
	}

	public Date getLeFStarttime() {
		return this.leFStarttime;
	}

	public void setLeFStarttime(Date leFStarttime) {
		this.leFStarttime = leFStarttime;
	}

	public Date getLeFEndtime() {
		return this.leFEndtime;
	}

	public void setLeFEndtime(Date leFEndtime) {
		this.leFEndtime = leFEndtime;
	}

}