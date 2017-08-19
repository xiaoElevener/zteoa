package com.ncu.oa.common.dao;

import java.util.List;

import com.ncu.oa.common.entity.Department;

public interface DepartmentDao {
	//1.根据id查询指定的部门department
	Department findByID(Integer id);
	//2.查询所有的部门
	List<Department> findAll();
	//3.保存部门
	boolean save(Department department);
	//4.修改部门
	boolean alter(Department department);
	//5.删除部门
	public boolean delete(Integer id);
	//6.传入对象删除部门
	public void delete(Department department);
	//7.删除部门
	boolean updateDepartment(Department department);
}
