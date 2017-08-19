package com.ncu.oa.common.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String userId;
	private Department department;
	private String userName;
	private String userTelephone;
	private String userPassword;
	private String userStatus;
	private String userSex;

	@JSONField(format = "yyyy-MM-dd")
	private Date userBirthday;

	@JSONField(serialize = false)
	private Set checkResults = new HashSet(0);

	@JSONField(serialize = false)
	private Set attendances = new HashSet(0);

	@JSONField(serialize = false)
	private Set userFamilies = new HashSet(0);

	@JSONField(serialize = false)
	private Set userHistories = new HashSet(0);

	@JSONField(serialize = false)
	private Set chaimVovchers = new HashSet(0);

	@JSONField(serialize = false)
	private Set userSchedules = new HashSet(0);

	private Set roles = new HashSet(0);

	@JSONField(serialize = false)
	private Set addressBooks = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userId, String userName, String userPassword) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTelephone() {
		return this.userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Date getUserBirthday() {
		return this.userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public Set getCheckResults() {
		return this.checkResults;
	}

	public void setCheckResults(Set checkResults) {
		this.checkResults = checkResults;
	}

	public Set getAttendances() {
		return this.attendances;
	}

	public void setAttendances(Set attendances) {
		this.attendances = attendances;
	}

	public Set getUserFamilies() {
		return this.userFamilies;
	}

	public void setUserFamilies(Set userFamilies) {
		this.userFamilies = userFamilies;
	}

	public Set getUserHistories() {
		return this.userHistories;
	}

	public void setUserHistories(Set userHistories) {
		this.userHistories = userHistories;
	}

	public Set getChaimVovchers() {
		return this.chaimVovchers;
	}

	public void setChaimVovchers(Set chaimVovchers) {
		this.chaimVovchers = chaimVovchers;
	}

	public Set getUserSchedules() {
		return this.userSchedules;
	}

	public void setUserSchedules(Set userSchedules) {
		this.userSchedules = userSchedules;
	}

	public Set getRoles() {
		return this.roles;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}

	public Set getAddressBooks() {
		return this.addressBooks;
	}

	public void setAddressBooks(Set addressBooks) {
		this.addressBooks = addressBooks;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", department=" + department
				+ ", userName=" + userName + ", userTelephone=" + userTelephone
				+ ", userPassword=" + userPassword + ", userStatus="
				+ userStatus + ", userSex=" + userSex + ", userBirthday="
				+ userBirthday + ", roles=" + roles + "]";
	}
	
	

}