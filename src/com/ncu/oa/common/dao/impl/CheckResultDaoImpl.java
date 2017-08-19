package com.ncu.oa.common.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ncu.oa.common.dao.CheckResultDao;
import com.ncu.oa.common.entity.CheckResult;

@Repository
public class CheckResultDaoImpl extends HibernateDaoSupport implements
		CheckResultDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public List findAllCheckResults() {
		return this.getHibernateTemplate().find("from CheckResult");
	}

	@Override
	public boolean saveCheckResult(CheckResult checkResult) {
		this.getHibernateTemplate().save(checkResult);
		return true;
	}

	@Override
	public boolean deleteCheckResult(CheckResult checkResult) {
		this.getHibernateTemplate().delete(checkResult);
		return true;
	}

	@Override
	public boolean updateCheckResult(CheckResult checkResult) {
		this.getHibernateTemplate().update(checkResult);
		return true;
	}

	@Override
	public CheckResult findCheckResultById(Integer id) {
		return this.getHibernateTemplate().load(CheckResult.class, id);
	}

	@Override
	public List findCheckResults(DetachedCriteria criteria) {
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

}
