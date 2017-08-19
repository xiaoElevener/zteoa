package com.ncu.oa.common.service;

import java.util.List;

import com.ncu.oa.common.entity.Role;
/**
 * role 角色 职位
 * service层操作
 */
public interface RoleService {
	//1.查询所有角色
	List<Role> findAll();
	//2.添加新角色
	void addRole(Role role);
	//3.删除角色
	void deleteRole(Integer id);
	//4.传入role 删除
	void deleteRole(Role role);
	//5.根据id查找角色
	Role findRoleById(Integer id);
	//6.更新角色
	void updateRole(Role role);
}
