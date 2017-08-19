package com.ncu.oa.common.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ncu.oa.common.dao.DepartmentDao;
import com.ncu.oa.common.entity.Department;

@Repository
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public Department findByID(Integer id) {
		return getHibernateTemplate().load(Department.class, id);
		
	}
	//按照序号降序排列
	@Override
	public List<Department> findAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(Department.class);
		dc.addOrder(Order.desc("dpId"));
		List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(dc);
 		//List<Department> list = (List<Department>) this.getHibernateTemplate().find("from Department");
		return list;
	}

	@Override
	public boolean save(Department department) {
		getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		this.getHibernateTemplate().save(department);
		return true;
	}

	@Override
	public boolean alter(Department department) {
		
		return false;
	}

	@Override
	public boolean updateDepartment(Department department) {
		this.getHibernateTemplate().update(department);
		return true;
	}
	
	@Override
	public boolean delete(Integer id) {
		getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		Department department = findByID(id);
		this.getHibernateTemplate().delete(department);
		return true;
	}

	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}
	
}
