package com.ncu.oa.common.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ncu.oa.common.dao.AttendanceDao;
import com.ncu.oa.common.entity.Attendance;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.util.CalendarUtil;

@Repository
public class AttendanceDaoImpl extends HibernateDaoSupport implements
		AttendanceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public boolean saveAttendance(Attendance Attendance) {
		this.getHibernateTemplate().save(Attendance);
		return true;
	}

	@Override
	public boolean deleteAttendance(Attendance Attendance) {
		this.getHibernateTemplate().delete(Attendance);
		return true;
	}

	@Override
	public boolean updateAttendance(Attendance Attendance) {
		this.getHibernateTemplate().update(Attendance);
		return true;
	}

	@Override
	public List findAllAttendances() {
		List list = this.getHibernateTemplate().find("from Attendance");
		return list;
	}

	@Override
	public Attendance findAttendanceById(Integer id) {
		return this.getHibernateTemplate().load(Attendance.class, id);
	}

	@Override
	public Attendance findAttendanceByUserAndDate(User user, Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar=CalendarUtil.cleanCalendar(calendar);
		date=calendar.getTime();
		DetachedCriteria criteria = DetachedCriteria.forClass(Attendance.class);
		criteria.add(Restrictions.eq("user", user)).add(
				Restrictions.eq("atWorkdate", date));
		List list = this.getHibernateTemplate().findByCriteria(criteria);
		if (list != null && list.size() > 0)
			return (Attendance) list.get(0);
		return null;
	}

	@Override
	public List findAttendancesByUserBtwDate(User user, Date fromDate,
			Date endDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Attendance.class);
		criteria.add(Restrictions.between("atWorkdate", fromDate, endDate))
				.add(Restrictions.eq("user", user));
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public Integer findAttendanceStatistics(DetachedCriteria criteria) {

		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		Integer a = ((Long) (criteria.getExecutableCriteria(session)
				.uniqueResult())).intValue();
		return a;
	}

}
