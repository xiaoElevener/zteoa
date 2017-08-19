package com.ncu.oa.common.entity;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer dpId;
	
	
	private User user;
	
	private String dpName;
	
	
	@JSONField(serialize=false)
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String dpName) {
		this.dpName = dpName;
	}

	/** full constructor */
	public Department(User user, String dpName, Set users) {
		this.user = user;
		this.dpName = dpName;
		this.users = users;
	}

	// Property accessors

	public Integer getDpId() {
		return this.dpId;
	}

	public void setDpId(Integer dpId) {
		this.dpId = dpId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDpName() {
		return this.dpName;
	}

	public void setDpName(String dpName) {
		this.dpName = dpName;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Department [dpId=" + dpId + ", dpName=" + dpName + "]";
	}

	

}