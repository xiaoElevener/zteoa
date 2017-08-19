package com.ncu.oa.common.entity;

/**
 * ExpenseForm entity. @author MyEclipse Persistence Tools
 */

public class ExpenseForm implements java.io.Serializable {

	// Fields

	private Integer exFId;
	private ChaimVovcher chaimVovcher;
	private Double exFAccount;
	private String exFReason;

	// Constructors

	/** default constructor */
	public ExpenseForm() {
	}

	/** full constructor */
	public ExpenseForm(Integer exFId, ChaimVovcher chaimVovcher,
			Double exFAccount, String exFReason) {
		this.exFId = exFId;
		this.chaimVovcher = chaimVovcher;
		this.exFAccount = exFAccount;
		this.exFReason = exFReason;
	}

	// Property accessors

	public Integer getExFId() {
		return this.exFId;
	}

	public void setExFId(Integer exFId) {
		this.exFId = exFId;
	}

	public ChaimVovcher getChaimVovcher() {
		return this.chaimVovcher;
	}

	public void setChaimVovcher(ChaimVovcher chaimVovcher) {
		this.chaimVovcher = chaimVovcher;
	}

	public Double getExFAccount() {
		return this.exFAccount;
	}

	public void setExFAccount(Double exFAccount) {
		this.exFAccount = exFAccount;
	}

	public String getExFReason() {
		return this.exFReason;
	}

	public void setExFReason(String exFReason) {
		this.exFReason = exFReason;
	}

}