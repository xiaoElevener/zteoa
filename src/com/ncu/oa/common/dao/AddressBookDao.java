package com.ncu.oa.common.dao;

import java.util.List;

import com.ncu.oa.common.entity.AddressBook;
import com.ncu.oa.common.entity.Role;
import com.ncu.oa.common.entity.User;

public interface AddressBookDao {
	//1.新增联系方式
	void saveContacts(AddressBook addressBook);
	//2.查询该用户通讯录
	List<AddressBook> findAllContacts(User user);
	//3.根据ID查询联系方式
	AddressBook findContactById(Integer id);
	//4.删除联系方式
	
	//5.更新此条联系方式
	void updateContacts(AddressBook addressBook);
	//6.根据id删除联系方式
	void deleteContacts(Integer id);
}
