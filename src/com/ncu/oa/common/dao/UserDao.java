package com.ncu.oa.common.dao;

import java.util.List;

import com.ncu.oa.common.entity.User;

public interface UserDao {
	//1.保存user
	boolean saveUser(User user);
	//2.删除user
	boolean deleteUser(User user);
	//3.对user进行更新
	boolean updateUser(User user);
	//4.查询所有的user
	List findAllUsers();
	//5.根据ID查询user
	User findUserById(String id);
	//6.登录
	User login(User user);
	//7.根据id删除user
	void deleteUser(String userid);
}
