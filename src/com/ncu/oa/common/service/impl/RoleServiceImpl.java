package com.ncu.oa.common.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncu.oa.common.dao.RoleDao;
import com.ncu.oa.common.entity.Role;
import com.ncu.oa.common.service.RoleService;
/**
 * 因为是Service层，所以注解声明service，注册为一个spring的bean
 * 开启事务
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	//自动封装获得roleDao实现类
	@Autowired
	private RoleDao roleDao;
	/**
	 * 1.得到所有角色
	 */
	@Override
	public List<Role> findAll() {
		return roleDao.findAllRoles();
	}
	/**
	 * 2.添加新角色
	 */
	@Override
	public void addRole(Role role) {
		roleDao.saveRole(role);
	}
	/**
	 * 3.根据ID删除角色
	 */
	@Override
	public void deleteRole(Integer id) {
		roleDao.deleteRole(id);
	}
	/**
	 * 4.删除角色
	 */
	@Override
	public void deleteRole(Role role) {
		roleDao.deleteRole(role);
	}
	/**
	 * 5.根据ID查询角色
	 */
	@Override
	public Role findRoleById(Integer id) {
		return roleDao.findRoleById(id);
	}
	/**
	 * 6.更新角色
	 */
	@Override
	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

}
