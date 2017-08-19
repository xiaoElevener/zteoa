package com.ncu.oa.common.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ncu.oa.common.dao.AddressBookDao;
import com.ncu.oa.common.entity.AddressBook;
import com.ncu.oa.common.entity.Role;
import com.ncu.oa.common.entity.User;
//声明它为dao层实现类
@Repository
public class AddressBookDaoImpl extends HibernateDaoSupport implements AddressBookDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * 1.传入待保存的联系方式
	 */
	@Override
	public void saveContacts(AddressBook addressBook) {
		this.getHibernateTemplate().save(addressBook);
	}
	/**
	 * 2.返回user中所有的联系方式
	 * 此user的通讯录
	 */
	@Override
	public List<AddressBook> findAllContacts(User user) {
		DetachedCriteria dc = DetachedCriteria.forClass(AddressBook.class);
		dc.add(Restrictions.eq("user", user));
		dc.addOrder(Order.desc("abId"));
		List<AddressBook> list = (List<AddressBook>) this.getHibernateTemplate().findByCriteria(dc);
		return list;
	}
	/**
	 * 3.根据ID查找对应联系方式
	 */
	@Override
	public AddressBook findContactById(Integer id) {
		return this.getHibernateTemplate().get(AddressBook.class, id);
	}
	/**
	 * 4.根据id删除联系方式
	 */

	@Override
	public void deleteContacts(Integer id) {
		AddressBook findContactById = this.findContactById(id);
		this.getHibernateTemplate().delete(findContactById);
		
	}
	/**
	 * 5.更新此条通讯方式
	 */
	@Override
	public void updateContacts(AddressBook addressBook) {
		this.getHibernateTemplate().update(addressBook);
		
	}

}
