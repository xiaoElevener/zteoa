package com.ncu.oa.common.entity;

/**
 * UserFamily entity. @author MyEclipse Persistence Tools
 */

public class UserFamily implements java.io.Serializable {

	// Fields

	private Integer ufId;
	private User user;
	private String ufRelationName;
	private String ufPersonName;
	private String ufPersonPhone;

	// Constructors

	/** default constructor */
	public UserFamily() {
	}

	/** minimal constructor */
	public UserFamily(String ufRelationName, String ufPersonName) {
		this.ufRelationName = ufRelationName;
		this.ufPersonName = ufPersonName;
	}

	/** full constructor */
	public UserFamily(User user, String ufRelationName, String ufPersonName,
			String ufPersonPhone) {
		this.user = user;
		this.ufRelationName = ufRelationName;
		this.ufPersonName = ufPersonName;
		this.ufPersonPhone = ufPersonPhone;
	}

	// Property accessors

	public Integer getUfId() {
		return this.ufId;
	}

	public void setUfId(Integer ufId) {
		this.ufId = ufId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUfRelationName() {
		return this.ufRelationName;
	}

	public void setUfRelationName(String ufRelationName) {
		this.ufRelationName = ufRelationName;
	}

	public String getUfPersonName() {
		return this.ufPersonName;
	}

	public void setUfPersonName(String ufPersonName) {
		this.ufPersonName = ufPersonName;
	}

	public String getUfPersonPhone() {
		return this.ufPersonPhone;
	}

	public void setUfPersonPhone(String ufPersonPhone) {
		this.ufPersonPhone = ufPersonPhone;
	}

	@Override
	public String toString() {
		return "UserFamily [ufId=" + ufId + ", ufRelationName="
				+ ufRelationName + ", ufPersonName=" + ufPersonName
				+ ", ufPersonPhone=" + ufPersonPhone + "]";
	}

	
}