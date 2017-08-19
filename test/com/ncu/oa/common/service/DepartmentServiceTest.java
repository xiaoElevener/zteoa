package com.ncu.oa.common.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ncu.oa.common.dao.DepartmentDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@Transactional
public class DepartmentServiceTest {
	@Autowired
	private DepartmentDao departmentDao;
	
	@Test
	@Rollback(false)
	public void delete() {
		departmentDao.delete(30);
	}

}
