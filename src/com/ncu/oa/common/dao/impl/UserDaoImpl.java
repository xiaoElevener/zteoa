package com.ncu.oa.common.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ncu.oa.common.dao.UserDao;
import com.ncu.oa.common.entity.User;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * 1.查询所有用户，返回list集合
	 */
	@Override
	public List findAllUsers() {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("userStatus", "在职"));
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(dc);
		return list;
	}
	/**
	 * 2.传入user，新增用户
	 */
	@Override
	public boolean saveUser(User user) {
		this.getHibernateTemplate().save(user);
		return true;
	}
	/**
	 * 3.设置员工状态为离职
	 */
	@Override
	public boolean deleteUser(User user) {
		user.setUserStatus("离职");
		this.getHibernateTemplate().update(user);
		return true;
	}
	/**
	 * 4.更新员工
	 */
	@Override
	public boolean updateUser(User user) {
		this.getHibernateTemplate().update(user);
		return true;
	}
	/**
	 * 5.更新id得到员工
	 */
	@Override
	public User findUserById(String id) {
		return this.getHibernateTemplate().get(User.class, id);
	}
	/**
	 * 6.根据ID删除用户
	 */
	@Override
	public void deleteUser(String userid) {
		User user = this.findUserById(userid);
		user.setUserStatus("离职");
		this.getHibernateTemplate().update(user);
	}
	
	/**
	 * 1.用户登录的方法
	 * 根据service层传过来的user来进行
	 */
	@Override
	public User login(User user) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("userId", user.getUserId()));
		dc.add(Restrictions.eq("userPassword", user.getUserPassword()));
		List<User> users = (List<User>) this.getHibernateTemplate().findByCriteria(dc);
		if (user != null && users.size()>0) {
			return users.get(0);
		}
		return null;
	}
	

}
