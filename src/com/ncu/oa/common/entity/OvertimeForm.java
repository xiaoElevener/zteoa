package com.ncu.oa.common.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * OvertimeForm entity. @author MyEclipse Persistence Tools
 */

public class OvertimeForm implements java.io.Serializable {

	// Fields

	private Integer otFId;
	private ChaimVovcher chaimVovcher;
	
	@JSONField (format="yyyy-MM-dd")
	private Date otFDate;

	// Constructors

	/** default constructor */
	public OvertimeForm() {
	}

	/** full constructor */
	public OvertimeForm(Integer otFId, ChaimVovcher chaimVovcher, Date otFDate) {
		this.otFId = otFId;
		this.chaimVovcher = chaimVovcher;
		this.otFDate = otFDate;
	}

	// Property accessors

	public Integer getOtFId() {
		return this.otFId;
	}

	public void setOtFId(Integer otFId) {
		this.otFId = otFId;
	}

	public ChaimVovcher getChaimVovcher() {
		return this.chaimVovcher;
	}

	public void setChaimVovcher(ChaimVovcher chaimVovcher) {
		this.chaimVovcher = chaimVovcher;
	}

	public Date getOtFDate() {
		return this.otFDate;
	}

	public void setOtFDate(Date otFDate) {
		this.otFDate = otFDate;
	}

}