package com.ncu.oa.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ncu.oa.common.dao.UserFamilyDao;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserFamily;
import com.ncu.oa.common.service.UserFamilyService;

/**
 * 因为是Service层，所以注解声明service，注册为一个spring的bean
 * 开启事务
 */
@Service
@Transactional
public class UserFamilyServiceImpl implements UserFamilyService{
	//自动封装获得userFamilyDao实现类
	@Autowired
	private UserFamilyDao userFamilyDao;

	@Override
	public boolean saveUserFamily(UserFamily userFamily) {
		userFamilyDao.saveUserFamily(userFamily);
		return true;
	}

	@Override
	public boolean deleteUserFamily(UserFamily userFamily) {
		userFamilyDao.deleteUserFamily(userFamily);
		return true;
	}

	@Override
	public boolean updateUserFamily(UserFamily userFamily) {
		userFamilyDao.updateUserFamily(userFamily);
		return true;
	}

	@Override
	public List findAllUserFamilies() {
		
		return userFamilyDao.findAllUserFamilies();
	}

	@Override
	public List findUserFamilyByUser(User user) {
		return userFamilyDao.findUserFamilyByUser(user);
	}

	@Override
	public UserFamily findUserFamilyOnlyOne(User user, String relationName) {
		
		return null;
	}

	@Override
	public UserFamily findUserFamilyById(Integer id) {
		
		return userFamilyDao.findUserFamilyById(id);
	}

	@Override
	public void deleteUserFamily(Integer id) {
		userFamilyDao.deleteUserFamily(id);
		
	}
	
	
	
}
