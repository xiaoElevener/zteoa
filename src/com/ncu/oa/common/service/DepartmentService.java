package com.ncu.oa.common.service;

import java.util.List;

import com.ncu.oa.common.entity.Department;

public interface DepartmentService {
	//1.查询所有部门
	List<Department> findAll();
	//2.添加部门
	void addDepartment(Department department);
	//3.删除部门
	void deleteDepartment(Integer id);
	//4.传入department 删除
	void deleteDepartment(Department department);
	//5.根据id查找部门
	Department findDepartmentById(Integer id);
	//6.更新部门
	void updateDepartment(Department department);
}
