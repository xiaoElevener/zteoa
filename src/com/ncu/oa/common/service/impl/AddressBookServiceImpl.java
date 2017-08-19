package com.ncu.oa.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncu.oa.common.dao.AddressBookDao;
import com.ncu.oa.common.entity.AddressBook;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.service.AddressService;

/**
 * 因为是Service层，所以注解声明service，注册为一个spring的bean
 * 开启事务
 */
@Service
@Transactional
public class AddressBookServiceImpl implements AddressService{
	//自动封装获得AddressBookDao实现类
	@Autowired
	private AddressBookDao addressBookDao;
	/**
	 * 1.传入联系方式保存
	 */
	@Override
	public void saveContacts(AddressBook addressBook) {
		addressBookDao.saveContacts(addressBook);
	}
	/**
	 * 2.找到此user通讯录
	 */
	@Override
	public List<AddressBook> finAddressBooks(User user) {
		return addressBookDao.findAllContacts(user);
	}
	/**
	 * 3.根据id查找具体的联系方式
	 */
	@Override
	public AddressBook findContactById(Integer id) {
		return addressBookDao.findContactById(id);
	}
	/**
	 * 4.更新联系方式
	 */
	@Override
	public void updateContacts(AddressBook addressBook) {
		addressBookDao.updateContacts(addressBook);
	}
	/**
	 * 5.根据ID删除相应的联系方式
	 */
	@Override
	public void deleteContacts(Integer id) {
		addressBookDao.deleteContacts(id);
	}

}
