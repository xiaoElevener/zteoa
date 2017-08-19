package com.ncu.oa.common.service;

import java.util.Date;
import java.util.List;

import com.ncu.oa.common.entity.Ad_staticstics;
import com.ncu.oa.common.entity.Attendance;
import com.ncu.oa.common.entity.User;

public interface AttendanceService {
	/** 签到 */
	public void signIn(User user);

	/** 下班 */
	public void signOut(User user);

	/**
	 * 用户某年某月的考勤记录
	 */
	public List findAttendancesByUser(User user, int year, int month);

	/**
	 * 查询用户某年的考勤记录
	 */
	public List findAttendancesByUser(User user, int year);

	/**
	 * 用户请假
	 */
	public void askForLeave(User user, Date startDate, Date endDate);

	/**
	 * 用户加班
	 */
	public void workOvertime(User user, Date date);

	/**
	 * 统计考勤记录
	 */
	public Ad_staticstics findAttendanceStaticstics(User user, int year,
			int month);

	/**
	 * 统计所有员工考勤
	 */
	public List<Ad_staticstics> findAttendanceStaticstics(List<User> users,
			int year, int month);

	/**
	 * 判断是否签过到
	 */
	public boolean isSignIn(Date date,User user);
	
	/**
	 * 判断是否能签退
	 */
	public boolean isSignOut(Date date,User user);
}
