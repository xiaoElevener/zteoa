package com.ncu.oa.common.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.ncu.oa.common.dao.DepartmentDao;
import com.ncu.oa.common.entity.Department;
import com.ncu.oa.common.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends ActionSupport {
	@Autowired
	private DepartmentService departmentService;
	private Department department;
	
	/**
	 * 找出所有的部门，转为json传到前台
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception {
		List<Department> list = departmentService.findAll();
		//2.将list转为json格式
		String json = JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
		//System.out.println(json);
		//3.将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	/**
	 * 添加新部门
	 * @return
	 */
	public String addDepartment() {
		System.out.println(department.getDpName());
		departmentService.addDepartment(department);
		return null;
	}
	/**
	 * 删除部门
	 * @return
	 */
	public String deleteDepartment() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String arr = request.getParameter("myjson");
		//System.out.println(arr);
		JSONArray myarr = (JSONArray) JSONArray.parse(arr);
		for (int i = 0; i < myarr.size(); i++) {
			JSONObject object = (JSONObject) myarr.get(i);
			//System.out.println(object);
			//System.out.println(object.getInteger("dpId"));
			departmentService.deleteDepartment(object.getInteger("dpId"));
		}
		return null;
	}
	/**
	 * 更新部门
	 */
	public String updateDepartment() throws Exception{
		//接受从前台ajax传送的一行的json数据。
		HttpServletRequest request = ServletActionContext.getRequest();
		String newRow = request.getParameter("myrow");
		//System.out.println(newRow);
		JSONObject parseObject = JSON.parseObject(newRow);
		Department department = departmentService.findDepartmentById(parseObject.getInteger("dpId"));
		department.setDpName(parseObject.getString("dpName").trim());
		//将更新过的部门对象传入service进行更新操作
		departmentService.updateDepartment(department);
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		//ServletActionContext.getResponse().setContentType("text/text");
		ServletActionContext.getResponse().getWriter().write("success");
		return null;
	}
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
