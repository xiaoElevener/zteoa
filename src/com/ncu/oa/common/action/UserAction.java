package com.ncu.oa.common.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ncu.oa.common.entity.Department;
import com.ncu.oa.common.entity.Role;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserFamily;
import com.ncu.oa.common.entity.UserHistory;
import com.ncu.oa.common.service.AttendanceService;
import com.ncu.oa.common.service.DepartmentService;
import com.ncu.oa.common.service.RoleService;
import com.ncu.oa.common.service.UserFamilyService;
import com.ncu.oa.common.service.UserHistoryService;
import com.ncu.oa.common.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class UserAction extends ActionSupport {

	// 自动封装userService的实现类
	@Autowired
	private UserService userService;

	@Autowired
	private UserFamilyService userFamilyService;

	@Autowired
	private UserHistoryService userHistoryService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private DepartmentService departmentService;

	// 声明一个user用于接受参数
	private User user;

	private Department department;

	private String[] roles;

	private String user_birthday;

	private String uhEvent;

	private String startTime;

	private String endTime;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * 1.用户登录
	 * 
	 * @return
	 */
	public String login() {
		user.setUserStatus("在职");
		User loginUser = userService.login(user);
		if (loginUser == null) {
			return "login";
		} else {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			session.put("user", loginUser);

			Set<Role> set = loginUser.getRoles();
			Iterator<Role> iterator = set.iterator();
			while (iterator.hasNext()) {
				Role role = (Role) iterator.next();
				if (role.getRoleId() == 5) {
					session.put("admin", true);
				}
			}

			return "index";
		}
	}

	/**
	 * 1.2 注销返回首页
	 */
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().invalidate();
		return "logout";
	}

	/**
	 * 2.找出所有在职的user，转为json传到前台
	 * 
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception {
		List<User> list = userService.findAllUser();
		for (User user : list) {
			System.out.println(user.getUserName());
		}
		// 2.将list转为json
		String json = JSON.toJSONString(list,
				SerializerFeature.DisableCircularReferenceDetect);
		// 3.传到客户端
		ServletActionContext.getResponse().setContentType(
				"application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	/**
	 * 3.添加user
	 * 
	 * @return
	 */
	public String addUser() {
		try {
			user.setDepartment(department);
			Set<Role> set = new HashSet<Role>();
			for (int i = 0; i < roles.length; i++) {
				Role role = roleService
						.findRoleById(Integer.parseInt(roles[i]));
				System.out.println(role);
				set.add(role);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(user_birthday);
			user.setRoles(set);
			user.setUserBirthday(date);
			userService.addUser(user);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 4.删除user
	 * 
	 * @return
	 */
	public String deleteUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String arr = request.getParameter("myjson");
		JSONArray myarr = (JSONArray) JSONArray.parse(arr);
		for (int i = 0; i < myarr.size(); i++) {
			JSONObject object = (JSONObject) myarr.get(i);
			userService.deleteUser(object.getString("userId"));
		}
		return null;
	}

	/**
	 * 5.添加家庭关系
	 * 
	 * @return
	 */
	public String addFamily() {

		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String arr = request.getParameter("myjson");

			String r_name = request.getParameter("r_name");
			String r_rname = request.getParameter("r_rname");
			String r_tele = request.getParameter("r_tele");

			UserFamily userFamily = new UserFamily();
			userFamily.setUfRelationName(r_rname);
			userFamily.setUfPersonName(r_name);
			userFamily.setUfPersonPhone(r_tele);

			JSONArray myarr = (JSONArray) JSONArray.parse(arr);
			JSONObject object = (JSONObject) myarr.get(0);
			User choose = userService.findUserById(object.getString("userId"));
			userFamily.setUser(choose);
			userFamilyService.saveUserFamily(userFamily);
			System.out.println("userfamily:" + userFamily);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 6.添加个人经历
	 * 
	 * @return
	 */
	public String addPersonHistory() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String arr = request.getParameter("myjson");
		System.out.println("myjson:" + arr);
		System.out.println("startTime:" + startTime + "    endTime" + endTime);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date st = sdf.parse(startTime);
			Date et = sdf.parse(endTime);
			JSONArray myarr = (JSONArray) JSONArray.parse(arr);
			for (int i = 0; i < myarr.size(); i++) {
				JSONObject object = (JSONObject) myarr.get(i);
				User choose = userService.findUserById(object
						.getString("userId"));
				UserHistory userHistory = new UserHistory();
				userHistory.setUhStartTime(st);
				userHistory.setUhEndTime(et);
				userHistory.setUser(choose);
				userHistory.setUhEvent(uhEvent);

				userHistoryService.saveUserHistory(userHistory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 7.管理员更新user
	 */

	public String updateUser() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String newRow = request.getParameter("myrow");
			System.out.println("new Row:" + newRow);
			// System.out.println(newRow);
			JSONObject parseObject = JSON.parseObject(newRow);

			User user = userService.findUserById(parseObject
					.getString("userId").trim());
			JSONObject deparJson = parseObject.getJSONObject("department");
			int dpId = deparJson.getIntValue("dpId");
			Department department = departmentService.findDepartmentById(dpId);
			user.setDepartment(department);
			System.out.println("department:" + department);
			user.setUserName(parseObject.getString("userName").trim());
			System.out.println(user.getUserName());
			user.setUserSex(parseObject.getString("userSex").trim());
			System.out.println(user.getUserSex());
			user.setUserTelephone(parseObject.getString("userTelephone").trim());
			System.out.println(user.getUserTelephone());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date bir = sdf.parse(parseObject.getString("userBirthday").trim());
			user.setUserBirthday(bir);
			userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 8.管理员更新用户角色
	 */
	public String updateUserRole() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] roleId = request.getParameterValues("roles");
		String userId = request.getParameter("userId");
		userService.updateRoles(userId, roleId);
		return null;
	}

	/**
	 * 9.用户更新自己的基本信息
	 */
	public String updateMyInfo() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String userName = request.getParameter("userName");
			String userSex = request.getParameter("userSex");
			String userTelephone = request.getParameter("userTelephone");
			String userBirthday = request.getParameter("userBirthday");

			User user = (User) request.getSession().getAttribute("user");
			user.setUserName(userName);
			user.setUserSex(userSex);
			user.setUserTelephone(userTelephone);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date bir = sdf.parse(userBirthday);
			user.setUserBirthday(bir);
			userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	/**
	 * 用户修改密码
	 */
	public String updatePassword() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			User user = (User) request.getSession().getAttribute("user");
			System.out.println("old:" + oldPassword + "    new:" + newPassword);
			if (oldPassword.equals(user.getUserPassword())) {
				user.setUserPassword(newPassword);
				userService.updateUser(user);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "password";
	}

	public String getUhEvent() {
		return uhEvent;
	}

	public void setUhEvent(String uhEvent) {
		this.uhEvent = uhEvent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public String getUser_birthday() {
		return user_birthday;
	}

	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}

}
