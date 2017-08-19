package com.ncu.oa.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncu.oa.common.dao.DepartmentDao;
import com.ncu.oa.common.entity.Department;
import com.ncu.oa.common.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentDao departmentDao;
	/**
	 * 1.找到所有部门
	 */
	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
	/**
	 * 2.添加新部门
	 */
	@Override
	public void addDepartment(Department department) {
		departmentDao.save(department);
	}
	/**
	 * 3.删除部门
	 */
	@Override
	public void deleteDepartment(Integer id) {
		departmentDao.delete(id);
	}
	/**
	 * 
	 */
	@Override
	public void deleteDepartment(Department department) {
		departmentDao.delete(department);
	}
	/**
	 * 5.根据id查找部门
	 */
	@Override
	public Department findDepartmentById(Integer id) {
		return departmentDao.findByID(id);
	}
	/**
	 * 6.更新部门
	 */
	@Override
	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);
		
	}

}
