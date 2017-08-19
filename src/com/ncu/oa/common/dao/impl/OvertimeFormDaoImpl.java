package com.ncu.oa.common.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ncu.oa.common.dao.OvertimeFormDao;
import com.ncu.oa.common.entity.OvertimeForm;

@Repository
public class OvertimeFormDaoImpl extends HibernateDaoSupport implements OvertimeFormDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public boolean saveOvertimeForm(OvertimeForm overtimeForm) {
		this.getHibernateTemplate().save(overtimeForm);
		return true;
	}

	@Override
	public boolean deleteOvertimeForm(OvertimeForm overtimeForm) {
		this.getHibernateTemplate().delete(overtimeForm);
		return true;
	}

	@Override
	public boolean updateOvertimeForm(OvertimeForm overtimeForm) {
		this.getHibernateTemplate().update(overtimeForm);
		return true;
	}

	@Override
	public List findAllOvertimeForms() {
		return this.getHibernateTemplate().find("from OvertimeForm");
	}

	@Override
	public OvertimeForm findOvertimeFormById(Integer id) {
		return this.getHibernateTemplate().load(OvertimeForm.class, id);
	}

}
