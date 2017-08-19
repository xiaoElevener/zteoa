package com.ncu.oa.common.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ncu.oa.common.dao.RoleDao;
import com.ncu.oa.common.entity.Department;
import com.ncu.oa.common.entity.Role;

@Repository
public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * 1.传入role，保存role角色
	 */
	@Override
	public void saveRole(Role role) {
		this.getHibernateTemplate().save(role);
	}
	/**
	 * 2.从数据库查询所有的角色
	 * 返回list集合
	 */
	@Override
	public List<Role> findAllRoles() {
		DetachedCriteria dc = DetachedCriteria.forClass(Role.class);
		dc.addOrder(Order.desc("roleId"));
		List<Role> list = (List<Role>) this.getHibernateTemplate().findByCriteria(dc);
		return list;
	}
	/**
	 * 3.根据id查找
	 */
	@Override
	public Role findRoleById(Integer id) {

		return this.getHibernateTemplate().get(Role.class, id);
	}
	/**
	 * 4.删除角色
	 */
	@Override
	public void deleteRole(Role role) {
		this.getHibernateTemplate().delete(role);

	}
	/**
	 * 5.更新角色
	 */
	@Override
	public void updateRole(Role role) {
		this.getHibernateTemplate().update(role);
	}
	/**
	 * 6.根据id删除角色
	 */
	@Override
	public void deleteRole(Integer id) {
		Role role = findRoleById(id);
		this.getHibernateTemplate().delete(role);
	}

}
