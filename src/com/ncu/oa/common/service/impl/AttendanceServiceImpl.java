package com.ncu.oa.common.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncu.oa.common.dao.AttendanceDao;
import com.ncu.oa.common.entity.Ad_staticstics;
import com.ncu.oa.common.entity.Attendance;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.service.AttendanceService;
import com.ncu.oa.common.util.CalendarUtil;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	// 迟到时间8点
	public static final Integer LATE_TIME = 8;

	// 早退时间18点
	public static final Integer EARLY_LEAVE_TIME = 18;

	@Autowired
	private AttendanceDao attendanceDao;

	/**
	 * 用户签到
	 */
	@Override
	public void signIn(User user) {
		Attendance attendance = new Attendance();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		attendance.setUser(user);
		attendance.setAtSigntime(timestamp);

		// 设置时分秒为零
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(timestamp);
		calendar = CalendarUtil.cleanCalendar(calendar);

		// 判断用户是否签过到
		if (attendanceDao.findAttendanceByUserAndDate(user, calendar.getTime()) != null)
			return;

		attendance.setAtWorkdate(calendar.getTime());
		// 设置状态
		attendance.setAtCheckLate(false);
		attendance.setAtCheckLeaveEarly(false);
		attendance.setAtCheckOvertime(false);
		attendance.setAtCheckVacation(false);

		// 判断是否迟到
		int hour = timestamp.getHours();
		if (hour > LATE_TIME) {
			attendance.setAtCheckLate(true);
		}
		attendanceDao.saveAttendance(attendance);
	}

	/***
	 * 用户签退
	 */
	@Override
	public void signOut(User user) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		// 设置时分秒为零
		calendar.setTime(timestamp);
		calendar = CalendarUtil.cleanCalendar(calendar);
		Attendance attendance = attendanceDao.findAttendanceByUserAndDate(user,
				calendar.getTime());
		if (attendance != null) {
			attendance.setAtLeavetime(timestamp);
			if (hour < EARLY_LEAVE_TIME) {
				attendance.setAtCheckLeaveEarly(true);
			}
			attendanceDao.updateAttendance(attendance);
		}

	}

	/**
	 * 查询自己的考勤记录(年月)
	 */
	@Override
	public List findAttendancesByUser(User user, int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1); // 月份减1
		calendar = CalendarUtil.cleanCalendar(calendar);

		Date fromDate = calendar.getTime();
		calendar.add(Calendar.MONTH, 1);
		Date endDate = calendar.getTime();

		List list = attendanceDao.findAttendancesByUserBtwDate(user, fromDate,
				endDate);
		return list;

	}

	/**
	 * 查询自己的考勤记录(月)
	 */
	@Override
	public List findAttendancesByUser(User user, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, 0, 1); // 月份减1
		calendar = CalendarUtil.cleanCalendar(calendar);
		Date fromDate = calendar.getTime();
		calendar.add(Calendar.YEAR, 1);
		Date endDate = calendar.getTime();
		List list = attendanceDao.findAttendancesByUserBtwDate(user, fromDate,
				endDate);
		return list;
	}

	/**
	 * 用户请假
	 */
	@Override
	public void askForLeave(User user, Date startDate, Date endDate) {
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);
		endCalendar.setTime(endDate);

		while (!startCalendar.equals(endCalendar)) {// 从开始时间到结束时间
			Attendance attendance = new Attendance();
			attendance.setAtWorkdate(startCalendar.getTime());
			attendance.setUser(user);
			attendance.setAtCheckLate(false);
			attendance.setAtCheckLeaveEarly(false);
			attendance.setAtCheckOvertime(false);
			attendance.setAtCheckVacation(true);
			startCalendar.add(Calendar.DATE, 1);
			attendanceDao.saveAttendance(attendance);
		}
	}

	/**
	 * 用户加班
	 */
	@Override
	public void workOvertime(User user, Date date) {

		Attendance attendance = attendanceDao.findAttendanceByUserAndDate(user,
				date);

		if (attendance != null) {
			attendance.setAtCheckOvertime(true);
			attendanceDao.updateAttendance(attendance);
		}

	}

	/**
	 * 分析用户考勤记录(年月)
	 */
	@Override
	public Ad_staticstics findAttendanceStaticstics(User user, int year,
			int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		calendar = CalendarUtil.cleanCalendar(calendar);

		Date start = calendar.getTime();
		calendar.add(Calendar.MONTH, 1);
		Date end = calendar.getTime();

		DetachedCriteria criteria = DetachedCriteria.forClass(Attendance.class);
		criteria.add(Restrictions.between("atWorkdate", start, end))
				.add(Restrictions.eq("user", user))
				.add(Restrictions.eq("atCheckLate", true))
				.setProjection(Projections.rowCount());
		int late = attendanceDao.findAttendanceStatistics(criteria);

		criteria = DetachedCriteria.forClass(Attendance.class);
		criteria.add(Restrictions.between("atWorkdate", start, end))
				.add(Restrictions.eq("user", user))
				.add(Restrictions.eq("atCheckLeaveEarly", true))
				.setProjection(Projections.rowCount());
		int early = attendanceDao.findAttendanceStatistics(criteria);

		criteria = DetachedCriteria.forClass(Attendance.class);
		criteria.add(Restrictions.between("atWorkdate", start, end))
				.add(Restrictions.eq("user", user))
				.add(Restrictions.eq("atCheckVacation", true))
				.setProjection(Projections.rowCount());
		int vacation = attendanceDao.findAttendanceStatistics(criteria);

		criteria = DetachedCriteria.forClass(Attendance.class);
		criteria.add(Restrictions.between("atWorkdate", start, end))
				.add(Restrictions.eq("user", user))
				.add(Restrictions.eq("atCheckOvertime", true))
				.setProjection(Projections.rowCount());
		int overtime = attendanceDao.findAttendanceStatistics(criteria);

		Ad_staticstics ad_staticstics = new Ad_staticstics(late, early,
				vacation, overtime);
		return ad_staticstics;
	}

	/**
	 * 分析list用户考勤记录(年月)
	 */
	@Override
	public List<Ad_staticstics> findAttendanceStaticstics(List<User> users,
			int year, int month) {

		List<Ad_staticstics> list = new ArrayList<Ad_staticstics>();
		for (User user : users) {
			Ad_staticstics ad_staticstics = findAttendanceStaticstics(user,
					year, month);
			list.add(ad_staticstics);
		}
		return list;
	}

	@Override
	public boolean isSignIn(Date date, User user) {
		
		Attendance attendance = attendanceDao.findAttendanceByUserAndDate(user,
				date);
		if (attendance == null)
			return true;
		else
			return false;
	}

	@Override
	public boolean isSignOut(Date date, User user) {
		Attendance attendance = attendanceDao.findAttendanceByUserAndDate(user,
				date);
		if(attendance==null||attendance.getAtLeavetime()!=null)
			return false;
		else
			return true;
	}
}
