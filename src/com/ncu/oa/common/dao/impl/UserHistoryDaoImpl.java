package com.ncu.oa.common.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ncu.oa.common.dao.UserHistoryDao;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserFamily;
import com.ncu.oa.common.entity.UserHistory;

@Repository
public class UserHistoryDaoImpl extends HibernateDaoSupport implements UserHistoryDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public boolean saveUserHistory(UserHistory userHistory) {
		this.getHibernateTemplate().save(userHistory);
		return true;
	}

	@Override
	public boolean deleteUserHistory(UserHistory userHistory) {
		this.getHibernateTemplate().delete(userHistory);
		return true;
	}

	@Override
	public boolean updateUserHistory(UserHistory userHistory) {
		this.getHibernateTemplate().update(userHistory);
		return true;
	}

	@Override
	public List findAllUserHitories() {
		
		List list=this.getHibernateTemplate().find("from UserHistory order by user.userName");
		return list;
	}

	@Override
	public List findUserHistoriesByUser(User user) {
		DetachedCriteria dc = DetachedCriteria.forClass(UserHistory.class);
		dc.add(Restrictions.eq("user", user));
		List<UserHistory> list = (List<UserHistory>) this.getHibernateTemplate().findByCriteria(dc);
		return list;
	}

	@Override
	public UserHistory findUserHistory(User user, Date startTime) {
		UserHistory userHistory=new UserHistory();
		userHistory.setUhStartTime(startTime);
		List<UserHistory> list= this.getHibernateTemplate().findByExample(userHistory);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;

	}

	@Override
	public UserHistory findHistoryById(Integer id) {
		return this.getHibernateTemplate().load(UserHistory.class, id);
	}
}
