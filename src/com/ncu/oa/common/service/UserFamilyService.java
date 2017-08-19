package com.ncu.oa.common.service;

import java.util.List;

import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserFamily;

public interface UserFamilyService {
	// 1.新增用户家庭关系
	public boolean saveUserFamily(UserFamily userFamily);

	// 2.删除用户家庭关系
	public boolean deleteUserFamily(UserFamily userFamily);

	// 3.更新用户家庭关系
	public boolean updateUserFamily(UserFamily userFamily);

	// 4.查询所有家庭关系
	public List findAllUserFamilies();

	// 5.查询某个人的家庭关系
	public List findUserFamilyByUser(User user);

	// 6。查询
	public UserFamily findUserFamilyOnlyOne(User user, String relationName);
	
	//7.根据id查询
	UserFamily findUserFamilyById(Integer id);
	//8.根据id删除
	void deleteUserFamily(Integer id);

}
