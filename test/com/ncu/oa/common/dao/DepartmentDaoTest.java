package com.ncu.oa.common.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.ncu.oa.common.entity.Department;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@Transactional
public class DepartmentDaoTest {
	//通过类型装配
	@Autowired
	private DepartmentDao departmentDao;
	
	@Test
	public void queryById() {
		int i = 1;
		Department department = departmentDao.findByID(i);
		System.out.println(department.getDpName());
		System.out.println(department.getDpId());
	}
	@Test 
	public void queryAll() {
		List<Department> findAll = departmentDao.findAll();
		for (Department department : findAll) {
			System.out.println(department.getDpName());
			System.out.println(department.getDpId());
		}
	}
	@Test 
	@Rollback(false)
	public void delete() {
		departmentDao.delete(29);
	}
	
	@Test
	public void DepartmentToJson() {
		List<Department> findAll = departmentDao.findAll();
		for (Department department : findAll) {
			System.out.println(department.getDpName());
		}
		String jsonString = JSON.toJSONString(findAll);
		System.out.println(jsonString);
	}
	
}
