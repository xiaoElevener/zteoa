package com.ncu.oa.common.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ncu.oa.common.entity.Attendance;
import com.ncu.oa.common.entity.User;

public interface AttendanceDao {
	public boolean saveAttendance(Attendance Attendance);

	public boolean deleteAttendance(Attendance Attendance);

	public boolean updateAttendance(Attendance Attendance);

	public List findAllAttendances();

	public Attendance findAttendanceById(Integer id);
	
	/**
	 * 查询用户指定日期的考勤
	 * */
	public Attendance findAttendanceByUserAndDate(User user, Date date);

	/**
	 * 查询用户指定时间段的考勤记录
	 */
	public List findAttendancesByUserBtwDate(User user, Date fromDate, Date endDate);
	
	/**
	 * 统计查询
	 */
	public Integer findAttendanceStatistics(DetachedCriteria criteria); 
}
