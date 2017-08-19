package com.ncu.oa.common.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ncu.oa.common.dao.UserFamilyDao;
import com.ncu.oa.common.entity.Role;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserFamily;

@Repository
public class UserFamilyDaoImpl extends HibernateDaoSupport implements UserFamilyDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public boolean saveUserFamily(UserFamily userFamily) {
		this.getHibernateTemplate().save(userFamily);
		return true;
	}

	@Override
	public boolean deleteUserFamily(UserFamily userFamily) {
		this.getHibernateTemplate().delete(userFamily);
		return true;
	}

	@Override
	public boolean updateUserFamily(UserFamily userFamily) {
		this.getHibernateTemplate().update(userFamily);
		return true;
	}

	@Override
	public List findUserFamilyByUser(User user) {
		DetachedCriteria dc = DetachedCriteria.forClass(UserFamily.class);
		dc.add(Restrictions.eq("user", user));
		List<UserFamily> list = (List<UserFamily>) this.getHibernateTemplate().findByCriteria(dc);
		//UserFamily userFamily=new UserFamily();
		//userFamily.setUser(user);
		//List<UserFamily> list = this.getHibernateTemplate().findByExample(userFamily);
		return list;
	}

	@Override
	public List findAllUserFamilies() {
		List list = this.getHibernateTemplate().find("from UserFamily");
		return list;
	}

	@Override
	public UserFamily findUserFamilyOnlyOne(User user, String relationName) {
		UserFamily userFamily=new UserFamily();
		userFamily.setUfRelationName(relationName);
		List<UserFamily> list= this.getHibernateTemplate().findByExample(userFamily);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public UserFamily findUserFamilyById(Integer id) {
		return this.getHibernateTemplate().load(UserFamily.class, id);
	}

	@Override
	public void deleteUserFamily(Integer id) {
		UserFamily userFamily = findUserFamilyById(id);
		this.getHibernateTemplate().delete(userFamily);
	}

	


}
