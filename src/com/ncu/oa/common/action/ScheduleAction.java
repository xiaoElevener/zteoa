package com.ncu.oa.common.action;

import java.io.IOException;
import java.sql.Timestamp;
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
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserSchedule;
import com.ncu.oa.common.service.UserScheduleService;
import com.opensymphony.xwork2.ActionSupport;

public class ScheduleAction extends ActionSupport {
	// 自动封装得到Service层实现类
	@Autowired
	private UserScheduleService userScheduleService;

	/**
	 * 1.找出个人的日程表
	 * 
	 * @return
	 * @throws IOException
	 */
	public String find() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<UserSchedule> list = userScheduleService
				.findUserSchedulesByUser(user);
		// 2.将list转为json传到前台
		String json = JSON.toJSONString(list);
		System.out.println("json:" + json);
		// 3.将json发送浏览器
		ServletActionContext.getResponse().setContentType(
				"application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	/**
	 * 2.添加新的个人日程
	 * 
	 * @return
	 */
	public String addSchedule() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		UserSchedule userSchedule = new UserSchedule();
		userSchedule.setUser(user);

		String scName = request.getParameter("scName");
		String scStartTime = request.getParameter("scStartTime");
		String scEndTime = request.getParameter("scEndTime");
		String scNotifyTime = request.getParameter("scNotifyTime");
		String scComm = request.getParameter("scComm");
		Timestamp start = Timestamp.valueOf(scStartTime);
		Timestamp end = Timestamp.valueOf(scEndTime);
		Timestamp notify = Timestamp.valueOf(scNotifyTime);

		userSchedule.setScName(scName);
		userSchedule.setScStartTime(start);
		userSchedule.setScEndTime(end);
		userSchedule.setScNotifyTime(notify);
		userSchedule.setScComm(scComm);
		userScheduleService.saveUserSchedule(userSchedule);

		return null;
	}

	/**
	 * 3.删除个人日程
	 * 
	 * @return
	 */
	public String deleteSchedule() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 1.获取从前台得到的勾选列的 json数组字符串
		String arr = request.getParameter("myjson");
		// 2.将字符串转为json数组
		JSONArray myarr = (JSONArray) JSONArray.parse(arr);
		// 3.遍历json数组，将遍历的元素转为json对象
		// 从json对象中，取出要删除的日程表id
		// 根据ID调用service层的方法，将对应日程项删除
		for (int i = 0; i < myarr.size(); i++) {
			JSONObject object = (JSONObject) myarr.get(i);
			userScheduleService.deleteUserSchedule(object.getInteger("scId"));
		}
		return null;
	}

	/**
	 * 4.更新个人日程
	 * @return
	 */
	public String updateSchedule() throws Exception {
		// 1.接受从前台ajax传送的一条json数据
		HttpServletRequest request = ServletActionContext.getRequest();
		String newRow = request.getParameter("myrow");
		// 2.将字符串转为json对象
		JSONObject parseObject = JSON.parseObject(newRow);
		// 3.根据json对象中一行的id查询指定的日程
		UserSchedule userSchedule = userScheduleService
				.findScheduleById(parseObject.getInteger("scId"));
		// 4.将查到的日程进行修改
		String scName = parseObject.getString("scName");
		String scStartTime = parseObject.getString("scStartTime");
		String scEndTime = parseObject.getString("scEndTime");
		String scNotifyTime = parseObject.getString("scNotifyTime");
		String scComm = parseObject.getString("scComm");
		Timestamp start = Timestamp.valueOf(scStartTime);
		Timestamp end = Timestamp.valueOf(scEndTime);
		Timestamp notify = Timestamp.valueOf(scNotifyTime);
		
		userSchedule.setScName(scName);
		userSchedule.setScStartTime(start);
		userSchedule.setScEndTime(end);
		userSchedule.setScNotifyTime(notify);
		userSchedule.setScComm(scComm);
		// 5.更新日程表
		userScheduleService.updateUserSchedule(userSchedule);
		return null;
	}
}
