package com.ncu.oa.common.service;

import java.util.List;

import com.ncu.oa.common.entity.User;

public interface UserService {
	// 1、用户登录
	public User login(User user);

	// 2.查询所有在职的用户
	public List<User> findAllUser();

	// 3.添加新用户
	public void addUser(User user);

	// 4.删除用户
	public void deleteUser(String userid);

	// 5.根据id查询用户
	public User findUserById(String userid);

	// 6.更新用户
	public void updateUser(User user);
	
	// 7.更新用户角色
	public void updateRoles(String userid,String[] roleid);  
}
