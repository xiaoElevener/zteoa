package com.ncu.oa.common.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserFamily;
import com.ncu.oa.common.entity.UserHistory;
import com.ncu.oa.common.service.UserHistoryService;
import com.opensymphony.xwork2.ActionSupport;

public class UserHistoryAction extends ActionSupport{
	@Autowired
	private UserHistoryService userHistoryService;
	private UserHistory userHistory;
	/**
	 * 1.查询所有的用户经历
	 * 
	 * @return
	 * @throws IOException
	 */
	public String find() throws IOException {
		@SuppressWarnings("unchecked")
		List<UserHistory> list = userHistoryService.findAllUserHitories();
		String json = JSON.toJSONString(list,
				SerializerFeature.DisableCircularReferenceDetect);
		ServletActionContext.getResponse().setContentType(
				"application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	/**
	 * 2.删除用户经历
	 * 
	 * @return
	 */
	public String deleteUserHistory() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String arr = request.getParameter("myjson");
		JSONArray myarr = (JSONArray) JSONArray.parse(arr);
		for (int i = 0; i < myarr.size(); i++) {
			JSONObject object = (JSONObject) myarr.get(i);
			UserHistory userHistory = userHistoryService.findHistoryById(object
					.getInteger("uhId"));
			userHistoryService.deleteUserHistory(userHistory);
		}
		return null;
	}

	/**
	 * 3.更新经历
	 * 
	 * @return
	 */
	public String updateUserHistory() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String newRow = request.getParameter("myrow");
			JSONObject json = JSON.parseObject(newRow);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Integer uhId = json.getInteger("uhId");
			String uhStartTime = json.getString("uhStartTime");
			String uhEndTime = json.getString("uhEndTime");
			String uhEvent = json.getString("uhEvent");

			Date st = sdf.parse(uhStartTime);
			Date et = sdf.parse(uhEndTime);

			UserHistory userHistory = userHistoryService.findHistoryById(uhId);
			userHistory.setUhStartTime(st);
			userHistory.setUhEndTime(et);
			userHistory.setUhEvent(uhEvent);
			userHistoryService.updateUserHistory(userHistory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查看个人经历
	 */
	public String findMyHistory() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			@SuppressWarnings("unchecked")
			List<UserFamily> list = userHistoryService.findUserHistoriesByUser(user);
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

	

	/**
	 * 1.查询某个用户的履历
	 * @return
	 * @throws IOException 
	 */
	public String findByUser() throws IOException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		List<UserHistory> list = userHistoryService.findUserHistoriesByUser(user);
		String json = JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	
	
	public UserHistory getUserHistory() {
		return userHistory;
	}
	public void setUserHistory(UserHistory userHistory) {
		this.userHistory = userHistory;
	}
	
}
