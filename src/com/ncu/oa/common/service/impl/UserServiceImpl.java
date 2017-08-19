package com.ncu.oa.common.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncu.oa.common.dao.RoleDao;
import com.ncu.oa.common.dao.UserDao;
import com.ncu.oa.common.entity.Role;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.service.UserService;

//为serivce层实现类进行标注
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	/**
	 * 1.用户登录
	 */
	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	/**
	 * 2.查询所有在职的用户
	 */
	@Override
	public List<User> findAllUser() {

		return userDao.findAllUsers();
	}

	/**
	 * 3.新增用户
	 */
	@Override
	public void addUser(User user) {
		userDao.saveUser(user);

	}

	/**
	 * 4.删除用户
	 */
	@Override
	public void deleteUser(String userid) {
		userDao.deleteUser(userid);

	}

	/**
	 * 5.根据userid查询user
	 */
	@Override
	public User findUserById(String userid) {
		return userDao.findUserById(userid);
	}

	/**
	 * 6.更新user
	 */
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	/**
	 * 7.更新用户角色
	 */
	@Override
	public void updateRoles(String userid, String[] roleid) {
		User user = userDao.findUserById(userid);
		Set<Role> set = new HashSet<Role>();
		for (String id : roleid) {
			Integer ri = Integer.parseInt(id);
			Role role = roleDao.findRoleById(ri);
			set.add(role);
		}
		user.setRoles(set);
		userDao.saveUser(user);
	}
}
