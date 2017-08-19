package com.ncu.oa.common.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ncu.oa.common.entity.Department;
import com.ncu.oa.common.entity.Role;
import com.ncu.oa.common.service.RoleService;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport {
	// 自动装箱，得到spring容器中roleService的实现类
	@Autowired
	private RoleService roleService;
	// 用于属性获得前台得到的数据role
	private Role role;

	/**
	 * 找出所有的角色，转为json传到前台
	 * 
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception {
		List<Role> list = roleService.findAll();
		// 2.将list转为json格式
		String json = JSON.toJSONString(list,
				SerializerFeature.DisableCircularReferenceDetect);
		
		// 3.将json发送给浏览器
		ServletActionContext.getResponse().setContentType(
				"application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	/**
	 * 添加新角色
	 * 
	 * @return
	 */
	public String addRole() {
		roleService.addRole(role);
		return null;
	}

	/**
	 * 前台传过来的是数组，先讲数组转为字符串通过ajax传递 然后后台将字符串转为json数组 遍历json数组，取出其中的id
	 * 根据ID调用Service层的删除方法 删除角色
	 * 
	 * @return
	 */
	public String deleteRole() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String arr = request.getParameter("myjson");
		System.out.println(arr);
		JSONArray myarr = (JSONArray) JSONArray.parse(arr);
		for (int i = 0; i < myarr.size(); i++) {
			JSONObject object = (JSONObject) myarr.get(i);
			roleService.deleteRole(object.getInteger("roleId"));
		}
		return null;
	}

	/**
	 * 更新角色 前台传送的数据是一行的json对象 先讲json对象转为字符串通过ajax传递 后台将字符串转为json对象 根据json对象，得到id
	 * 根据ID得到role角色，再将改动的属性设置到得到的角色中 将角色传递给Service层完成操作
	 */
	public String updateRole() throws Exception {
		// 接受从前台ajax传送的一行的json数据。
		HttpServletRequest request = ServletActionContext.getRequest();
		String newRow = request.getParameter("myrow");

		JSONObject parseObject = JSON.parseObject(newRow);
		Role role = roleService.findRoleById(parseObject.getInteger("roleId"));
		role.setRoleName(parseObject.getString("roleName").trim());
		// 将更新过的部门对象传入service进行更新操作
		roleService.updateRole(role);
	
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/text");
		ServletActionContext.getResponse().getWriter().write("success");
		return null;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
