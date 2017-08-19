package com.ncu.oa.common.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ncu.oa.common.dao.LeaveFormDao;
import com.ncu.oa.common.entity.LeaveForm;

@Repository
public class LeaveFormDaoImpl extends HibernateDaoSupport implements
		LeaveFormDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public boolean saveLeaveForm(LeaveForm leaveForm) {
		this.getHibernateTemplate().save(leaveForm);
		return true;
	}

	@Override
	public boolean deleteLeaveForm(LeaveForm leaveForm) {
		this.getHibernateTemplate().delete(leaveForm);
		return true;
	}

	@Override
	public boolean updateLeaveForm(LeaveForm leaveForm) {
		this.getHibernateTemplate().update(leaveForm);
		return true;
	}

	@Override
	public List findAllLeaveForms() {
		return this.getHibernateTemplate().find("from LeaveForm");
	}

	@Override
	public LeaveForm findLeaveFormById(Integer id) {
		return this.getHibernateTemplate().load(LeaveForm.class, id);
	}}
