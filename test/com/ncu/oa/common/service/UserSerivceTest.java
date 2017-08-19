package com.ncu.oa.common.service;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ncu.oa.common.entity.Role;
import com.ncu.oa.common.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@Transactional
public class UserSerivceTest {
	@Autowired
	private UserService userService;
	

	/**
	 * 1.测试用户登录
	 * 返回user
	 */
	@Test
	public void loginTest() {
		User user = new User();
		user.setUserId("10001");
		user.setUserPassword("12345");
		User login = userService.login(user);
		System.out.println(login.getUserName());
		System.out.println(login.getUserStatus());
		Set<Role> roles = login.getRoles();
		for (Role role : roles) {
			System.out.println(role.getRoleName());
		}
	}
	
}
