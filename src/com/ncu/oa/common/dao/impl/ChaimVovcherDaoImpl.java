package com.ncu.oa.common.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ncu.oa.common.dao.ChaimVovcherDao;
import com.ncu.oa.common.entity.ChaimVovcher;
import com.ncu.oa.common.entity.User;

@Repository
public class ChaimVovcherDaoImpl extends HibernateDaoSupport implements
		ChaimVovcherDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public Integer saveChaimVovcher(ChaimVovcher chaimVovcher) {
		this.getHibernateTemplate().save(chaimVovcher);
		return chaimVovcher.getCvId();
	}

	@Override
	public boolean deleteChaimVovcher(ChaimVovcher chaimVovcher) {
		chaimVovcher.setCvStatus("回收");
		this.getHibernateTemplate().update(chaimVovcher);
		return true;
	}

	@Override
	public boolean updateChaimVovcher(ChaimVovcher chaimVovcher) {
		this.getHibernateTemplate().update(chaimVovcher);
		return true;
	}

	@Override
	public List findAllChaimVovchers() {
		return this.getHibernateTemplate().find("from ChaimVovcher");
	}

	@Override
	public ChaimVovcher findChaimVovcherById(Integer id) {
		return this.getHibernateTemplate().load(ChaimVovcher.class, id);
	}

	@Override
	public List findChaimVovchers(DetachedCriteria criteria) {
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

}
