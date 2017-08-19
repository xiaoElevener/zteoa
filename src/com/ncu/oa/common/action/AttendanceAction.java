package com.ncu.oa.common.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ncu.oa.common.entity.Ad_staticstics;
import com.ncu.oa.common.entity.Attendance;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.service.AttendanceService;
import com.opensymphony.xwork2.ActionSupport;

public class AttendanceAction extends ActionSupport {

	@Autowired
	private AttendanceService attendanceService;

	/**
	 * 用户签到
	 */
	public String signIn() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("user");
		attendanceService.signIn(user);
		return null;
	}

	/**
	 * 用户签退
	 */

	public String signOut() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("user");
		attendanceService.signOut(user);
		return null;
	}

	/**
	 * 用户查看自己的考勤(年份)
	 */
	public String findByMonth() {
		// 需要年月yyyy-MM
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			User user = (User) request.getSession().getAttribute("user");
			String date = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date da = sdf.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(da);
			List<Attendance> list = attendanceService.findAttendancesByUser(
					user, calendar.get(Calendar.YEAR),
					calendar.get(Calendar.MONTH));

			String json = JSON.toJSONString(list,
					SerializerFeature.DisableCircularReferenceDetect);
			// 3.传到客户端
			ServletActionContext.getResponse().setContentType(
					"application/json;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查看自己的考勤(年份)
	 */
	public String findByYear() {
		// 需要date类型 yyyy-
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			User user = (User) request.getSession().getAttribute("user");
			String date = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			Date da = sdf.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(da);
			List<Attendance> list = attendanceService.findAttendancesByUser(
					user, calendar.get(Calendar.YEAR));
			String json = JSON.toJSONString(list,
					SerializerFeature.DisableCircularReferenceDetect);
			// 3.传到客户端
			ServletActionContext.getResponse().setContentType(
					"application/json;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 统计分析自己的考勤(年月)
	 * 
	 * @return Ad_staticstics 分析数据对象
	 */
	public String analyzeMine() {
		// 需要date类型 yyyy-MM
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			User user = (User) request.getSession().getAttribute("user");
			String date = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			Date da = sdf.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(da);
			Ad_staticstics staticstics = attendanceService
					.findAttendanceStaticstics(user,
							calendar.get(Calendar.YEAR),
							calendar.get(Calendar.MONTH));
			String json = JSON.toJSONString(staticstics);
			// 3.传到客户端
			ServletActionContext.getResponse().setContentType(
					"application/json;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 判断是否能签到或签退 ajax返回状态码0:能签到，能签退(不存在) 1:能签到，不能签退 2:不能签到，能签退 3：不能签到，不能签退
	 * (不等于1 不能签到 ,不等于2 不能签退)
	 * 
	 * @throws IOException
	 */
	public String canSign() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("user");
		int status = 0;

		// 不能签退+1
		if (!attendanceService.isSignOut(new Date(), user)) {
			status = status + 1;
		}
		// 不能签到+2
		if (!attendanceService.isSignIn(new Date(), user)) {
			status = status + 2;
		}
		String json = JSON.toJSONString(status);
		ServletActionContext.getResponse().setContentType(
				"application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	/**
	 * 查看用户的考勤记录
	 */
	public String findByUser() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("user");
			// 默认2017年
			List<Attendance> list = attendanceService.findAttendancesByUser(
					user, 2017);
			String json = JSON.toJSONString(list,
					SerializerFeature.DisableCircularReferenceDetect);
			// 3.传到客户端
			ServletActionContext.getResponse().setContentType(
					"application/json;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
