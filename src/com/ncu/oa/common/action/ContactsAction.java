package com.ncu.oa.common.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ncu.oa.common.entity.AddressBook;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.service.AddressService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ContactsAction extends ActionSupport{
	//用于接受jsp传来的参数
	private AddressBook addressBook;
	@Autowired
	private AddressService addressService;
	/**
	 * 1.找到此用户所有的通讯录转为json传到前台
	 * @return
	 * @throws IOException 
	 */
	public String findAll() throws IOException {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User currentUser = (User) session.get("user");
		List<AddressBook> list = addressService.finAddressBooks(currentUser);
		
		System.out.println(list.size());
		//将list转为json
		String json = JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);
		//将json发送
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	/**
	 * 2.给用户添加新的联系方式
	 */
	public String addContacts() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User currentUser = (User) session.get("user");
		addressBook.setUser(currentUser);
		addressService.saveContacts(addressBook);
		return null;
	}
	/**
	 * 3.删除联系方式
	*/
	public String deleteContacts() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//从前台接受json数组字符串
		String arr = request.getParameter("myjson");
		//将json数组字符串转为json数组
		JSONArray jsonArray = (JSONArray) JSONArray.parse(arr);
		for (int i = 0; i < jsonArray.size(); i++) {
			//将每一个数组对象转为对象
			JSONObject object = (JSONObject) jsonArray.get(i);
			addressService.deleteContacts(object.getInteger("abId"));
		}
		return null;
	}
	/**
	 * 4.更新对应联系方式
	 */
	public String updateContacts() {
		//接受从前台ajax传送的一行的json数据
		HttpServletRequest request = ServletActionContext.getRequest();
		String newRow = request.getParameter("myrow");
		//将字符串转为json对象
		JSONObject parseObject = JSON.parseObject(newRow);
		//根据id查找联系方式
		AddressBook addressBook = addressService.findContactById(parseObject.getInteger("abId"));
		addressBook.setAbName(parseObject.getString("abName"));
		addressBook.setAbDepartment(parseObject.getString("abDepartment"));
		addressBook.setAbRole(parseObject.getString("abRole"));
		addressBook.setAbTelephone(parseObject.getString("abTelephone"));
		//将更新过的联系方式传入service
		addressService.updateContacts(addressBook);
		return null;
		
	}
	public AddressBook getAddressBook() {
		return addressBook;
	}
	public void setAddressBook(AddressBook addressBook) {
		this.addressBook = addressBook;
	}
	
}
