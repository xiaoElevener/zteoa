package com.ncu.oa.common.dao;

import java.util.List;

import com.ncu.oa.common.entity.Role;

public interface RoleDao {
	//1.新增角色
	void saveRole(Role role);
	//2.查询所有角色
	List<Role> findAllRoles();
	//3.根据ID查询所有角色
	Role findRoleById(Integer id);
	//4.删除角色
	void deleteRole(Role role);
	//5.更新角色
	void updateRole(Role role);
	//6.根据id删除角色
	void deleteRole(Integer id);
}
