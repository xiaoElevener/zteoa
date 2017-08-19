package com.ncu.oa.common.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ncu.oa.common.dao.ExpenseFormDao;
import com.ncu.oa.common.entity.ExpenseForm;

@Repository
public class ExpenseFormDaoImpl extends HibernateDaoSupport implements
		ExpenseFormDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public boolean saveExpenseForm(ExpenseForm expenseForm) {
		this.getHibernateTemplate().save(expenseForm);
		return true;
	}

	@Override
	public boolean deleteExpenseForm(ExpenseForm expenseForm) {
		this.getHibernateTemplate().delete(expenseForm);
		return true;
	}

	@Override
	public boolean updateExpenseForm(ExpenseForm expenseForm) {
		this.getHibernateTemplate().update(expenseForm);
		return true;
	}

	@Override
	public List findAllExpenseForms() {
		return this.getHibernateTemplate().find("from ExpenseForm");
	}

	@Override
	public ExpenseForm findExpenseFormById(Integer id) {
		return this.getHibernateTemplate().get(ExpenseForm.class, id);
	}

}
