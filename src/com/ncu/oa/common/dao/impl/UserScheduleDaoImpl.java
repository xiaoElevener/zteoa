package com.ncu.oa.common.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.ncu.oa.common.dao.UserScheduleDao;
import com.ncu.oa.common.entity.Department;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserFamily;
import com.ncu.oa.common.entity.UserHistory;
import com.ncu.oa.common.entity.UserSchedule;

@Repository
public class UserScheduleDaoImpl extends HibernateDaoSupport implements UserScheduleDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public boolean saveUserSchedule(UserSchedule userSchedule) {
		this.getHibernateTemplate().save(userSchedule);
		return true;
	}

	@Override
	public boolean deleteUserSchedule(UserSchedule userSchedule) {
		this.getHibernateTemplate().delete(userSchedule);
		return true;
	}
	

	public void deleteUserSchedule(Integer id) {
		UserSchedule findScheduleById = this.findScheduleById(id);
		this.getHibernateTemplate().delete(findScheduleById);
	}
	
	public UserSchedule findScheduleById(Integer id) {
		return getHibernateTemplate().load(UserSchedule.class, id);
	}
	
	@Override
	public boolean updateUserSchedule(UserSchedule userSchedule) {
		this.getHibernateTemplate().update(userSchedule);
		return true;
	}

	@Override
	public List findAllUserSchedules() {
		List list=this.getHibernateTemplate().find("from UserSchedule order by scId desc");
		return list;
	}

	@Override
	public List findUserSchedulesByUser(User user) {
		DetachedCriteria criteria=DetachedCriteria.forClass(UserHistory.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.addOrder(Order.asc("scId"));
		List<UserSchedule> list = (List<UserSchedule>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	@Override
	public List findUserSchedule(DetachedCriteria criteria) {
		List<UserHistory> list=(List<UserHistory>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
}
