 package com.ncu.oa.common.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ncu.oa.common.entity.Department;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserFamily;
import com.ncu.oa.common.service.UserFamilyService;
import com.opensymphony.xwork2.ActionSupport;

public class UserFamilyAction extends ActionSupport{
	//获得家庭关系service实例
	@Autowired
	private UserFamilyService userFamilyService;
	//家庭关系用于接收参数
	private UserFamily userFamily;
	
	/**
	 * 查询个人的家庭关系
	 */
	public String findByUser() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		List<UserFamily> list = userFamilyService.findUserFamilyByUser(user);
		//2.将list转为json格式
		String json = JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
		//System.out.println(json);
		//3.将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	
	/**
	 * 查询所有的家庭关系表
	 */
	public String find() throws Exception {
		List<UserFamily> list = userFamilyService.findAllUserFamilies();
		// 2.将list转为json格式
		String json = JSON.toJSONString(list,
				SerializerFeature.DisableCircularReferenceDetect);
		// System.out.println(json);
		// 3.将json发送给浏览器
		ServletActionContext.getResponse().setContentType(
				"application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	/**
	 * 添加新家庭关系
	 */

	/**
	 * 删除某个家庭信息
	 */
	public String deleteUserFamily() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String arr = request.getParameter("myjson");
		JSONArray myarr = (JSONArray) JSONArray.parse(arr);
		for (int i = 0; i < myarr.size(); i++) {
			JSONObject object = (JSONObject) myarr.get(i);
			userFamilyService.deleteUserFamily(object.getInteger("ufId"));
		}
		return null;
	}

	/**
	 * 更新家庭信息
	 */
	public String updateUserFamily() throws Exception {
		// 接受从前台ajax传送的一行的json数据。
		HttpServletRequest request = ServletActionContext.getRequest();
		String newRow = request.getParameter("myrow");
		JSONObject parseObject = JSON.parseObject(newRow);
		UserFamily userFamily = userFamilyService
				.findUserFamilyById(parseObject.getInteger("ufId"));
		userFamily.setUfPersonName(parseObject.getString("ufPersonName"));
		userFamily.setUfRelationName(parseObject.getString("ufRelationName"));
		userFamily.setUfPersonPhone(parseObject.getString("ufPersonPhone"));
		userFamilyService.updateUserFamily(userFamily);

		return null;
	}

	/**
	 * 查看个人家庭信息
	 */
	public String findMyFamily() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			@SuppressWarnings("unchecked")
			List<UserFamily> list = userFamilyService
					.findUserFamilyByUser(user);
			// 2.将list转为json格式
			String json = JSON.toJSONString(list,
					SerializerFeature.DisableCircularReferenceDetect);
			// System.out.println(json);
			// 3.将json发送给浏览器
			ServletActionContext.getResponse().setContentType(
					"application/json;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
		}
		return null;
	}

	

	public UserFamily getUserFamily() {
		return userFamily;
	}


	public void setUserFamily(UserFamily userFamily) {
		this.userFamily = userFamily;
	}
	
}


