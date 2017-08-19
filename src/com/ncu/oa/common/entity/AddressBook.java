package com.ncu.oa.common.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * AddressBook entity. @author MyEclipse Persistence Tools
 */

public class AddressBook implements java.io.Serializable {

	// Fields

	private Integer abId;
	
	@JSONField(serialize=false)
	private User user;
	
	private String abDepartment;
	private String abRole;
	private String abTelephone;
	private String abName;
	// Constructors

	/** default constructor */
	public AddressBook() {
	}

	/** minimal constructor */
	public AddressBook(User user) {
		this.user = user;
	}

	/** full constructor */
	public AddressBook(Integer abId, User user, String abDepartment,
			String abRole, String abTelephone, String abName) {
		super();
		this.abId = abId;
		this.user = user;
		this.abDepartment = abDepartment;
		this.abRole = abRole;
		this.abTelephone = abTelephone;
		this.abName = abName;
	}

	// Property accessors
	
	public Integer getAbId() {
		return this.abId;
	}

	

	public void setAbId(Integer abId) {
		this.abId = abId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAbDepartment() {
		return this.abDepartment;
	}

	public void setAbDepartment(String abDepartment) {
		this.abDepartment = abDepartment;
	}

	public String getAbRole() {
		return this.abRole;
	}

	public void setAbRole(String abRole) {
		this.abRole = abRole;
	}

	public String getAbTelephone() {
		return this.abTelephone;
	}

	public void setAbTelephone(String abTelephone) {
		this.abTelephone = abTelephone;
	}

	public String getAbName() {
		return abName;
	}

	public void setAbName(String abName) {
		this.abName = abName;
	}
	
}