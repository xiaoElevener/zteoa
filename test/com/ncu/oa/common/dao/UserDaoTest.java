package com.ncu.oa.common.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ncu.oa.common.entity.Department;
import com.ncu.oa.common.entity.Role;
import com.ncu.oa.common.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@Transactional
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private DepartmentDao departmentDao;

	/**
	 * 1.测试用户登录
	 * 返回user
	 */
	@Test
	public void loginTest() {
		User user = new User();
		user.setUserId("10001");
		user.setUserPassword("12345");
		User login = userDao.login(user);
		System.out.println(login.getUserName());
		System.out.println(login.getUserStatus());
		Set<Role> roles = login.getRoles();
		for (Role role : roles) {
			System.out.println(role.getRoleName());
		}
	}
	
	
	@Test
	public void query() {
		String id = "10001";
		User user = userDao.findUserById(id);
		System.out.println(user.getUserName());
		System.out.println(user.getUserPassword());
	}
	//给用户添加角色
	@Test
	@Rollback(false)
	public void addRoleToUserTest() {
		User user = userDao.findUserById("10001");
		System.out.println("-------------------user:"+user);
		user.getRoles().add(roleDao.findRoleById(1));
		user.getRoles().add(roleDao.findRoleById(2));
		
		userDao.updateUser(user);
		user = userDao.findUserById("10001");
		System.out.println("-------------------user:"+user);
	}
	//根据用户查询角色
	@Test
	public void queryRole() {
		User user = userDao.findUserById("10001");
		System.out.println("-------------------user:"+user);
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			System.out.println(role.getRoleName());
			System.out.println(role.getRoleId());
		}
		
	}
	


	/***
	 * 方法执行完会自动进行事务回滚，添加的对象不会存入数据库
	 */
	@Test
	public void testSaveUser() {
		Department department = departmentDao.findByID(1);
		User user = new User();
		user.setUserId("A00002");
		user.setUserName("林凌霄");
		user.setUserPassword("123456");
		user.setDepartment(department);
		user.setUserTelephone("15797692522");
		user.setUserStatus("在职");
		userDao.saveUser(user);
		testFindAllUsers();
	}

	@Test
	public void testFindAllUsers() {
		List users = userDao.findAllUsers();
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			System.out.println(user);
		}
	}

}
