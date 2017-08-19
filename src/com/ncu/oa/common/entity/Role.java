package com.ncu.oa.common.entity;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	
	@JSONField(serialize = false)
	private Set chaimVovchers = new HashSet(0);
	
	@JSONField(serialize = false)
	private Set checkResults = new HashSet(0);
	
	@JSONField(serialize = false)
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String roleName) {
		this.roleName = roleName;
	}

	/** full constructor */
	public Role(String roleName, Set chaimVovchers, Set checkResults, Set users) {
		this.roleName = roleName;
		this.chaimVovchers = chaimVovchers;
		this.checkResults = checkResults;
		this.users = users;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set getChaimVovchers() {
		return this.chaimVovchers;
	}

	public void setChaimVovchers(Set chaimVovchers) {
		this.chaimVovchers = chaimVovchers;
	}

	public Set getCheckResults() {
		return this.checkResults;
	}

	public void setCheckResults(Set checkResults) {
		this.checkResults = checkResults;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}