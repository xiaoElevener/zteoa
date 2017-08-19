package com.ncu.oa.common.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ncu.oa.common.entity.ChaimVovcher;
import com.ncu.oa.common.entity.CheckResult;
import com.ncu.oa.common.entity.ExpenseForm;
import com.ncu.oa.common.entity.LeaveForm;
import com.ncu.oa.common.entity.OvertimeForm;
import com.ncu.oa.common.entity.Role;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.service.ChaimVovcherService;
import com.opensymphony.xwork2.ActionSupport;

public class ChaimAction extends ActionSupport {

	@Autowired
	private ChaimVovcherService chaimVovcherService;

	/**
	 * 填写提交请假表单
	 */
	public String addLeaveForm() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String startDate = request.getParameter("startTime");
			String endDate = request.getParameter("endTime");
			String reason = request.getParameter("reason");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date sd = sdf.parse(startDate);
			Date ed = sdf.parse(endDate);

			LeaveForm leaveForm = new LeaveForm();
			leaveForm.setLeFStarttime(sd);
			leaveForm.setLeFEndtime(ed);
			leaveForm.setLeFReason(reason);

			User user = (User) request.getSession().getAttribute("user");
			ChaimVovcher chaimVovcher = new ChaimVovcher();
			chaimVovcherService.createChaimVovcher(user, chaimVovcher,
					leaveForm);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "myChaimList";
	}

	/**
	 * 填写提交报销表单
	 */
	public String addExpenseForm() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String reason = request.getParameter("reason");
		String money = request.getParameter("money");

		ExpenseForm expenseForm = new ExpenseForm();
		ChaimVovcher chaimVovcher = new ChaimVovcher();

		expenseForm.setExFAccount(Double.parseDouble(money));
		expenseForm.setExFReason(reason);
		User user = (User) request.getSession().getAttribute("user");
		chaimVovcherService.createChaimVovcher(user, chaimVovcher, expenseForm);

		return "myChaimList";
	}

	/**
	 * 填写提交加班表单
	 */

	public String addOvertimeForm() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String date = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse(date);
			OvertimeForm overtimeForm = new OvertimeForm();
			ChaimVovcher chaimVovcher = new ChaimVovcher();
			overtimeForm.setOtFDate(d);
			User user = (User) request.getSession().getAttribute("user");
			chaimVovcherService.createChaimVovcher(user, chaimVovcher,
					overtimeForm);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "myChaimList";
	}

	/**
	 * 用户查看自己提交的审批表单
	 */
	public String findMyChaim() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("user");

		List<ChaimVovcher> list = chaimVovcherService
				.findChaimVovcherByUser(user);

		try {
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
	 * 用户查看需要自己去审批的表单
	 */
	public String findCheckChaim() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("user");
			Set<ChaimVovcher> set = chaimVovcherService
					.findCheckChaimVovchers(user);

			// 2.将list转为json
			String json = JSON.toJSONString(set,
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

	/**
	 * 用户审批表单
	 */
	public String checkChaim() {
		// 需要审批意见表单,审批表的id
		HttpServletRequest request = ServletActionContext.getRequest();
		String result = request.getParameter("result"); // 通过 or 未通过
		String comm = request.getParameter("comm"); // 批注
		String chaimVovcherId = request.getParameter("chaim_id");

		CheckResult checkResult = new CheckResult();
		checkResult.setCkResult(result);
		checkResult.setCkComm(comm);
		User user = (User) request.getSession().getAttribute("user");
		chaimVovcherService.checkChaimVovcher(user, checkResult,
				Integer.parseInt(chaimVovcherId));
		return "checkList";
	}

	/**
	 * 用户根据自己前台传递的申请单id， 只查看申请表详情
	 */
	public String showDetail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String parameter = request.getParameter("cvid");
		Integer cvid = Integer.valueOf(parameter);
		System.out.println("-------------" + cvid);
		// 根据id查找具体的申请单
		ChaimVovcher myChaimVovcher = chaimVovcherService.showDetail(cvid);
		// 获得申请单的类型
		String formType = myChaimVovcher.getFormType();
		System.out.println(formType + "---------------------------");
		// 三种类型的情况对应三个页面
		if (formType.equals("请假表")) {
			Set<LeaveForm> leaveForms = myChaimVovcher.getLeaveForms();
			Iterator<LeaveForm> iterator = leaveForms.iterator();
			LeaveForm leaveForm = iterator.next();
			
			String cvStatus = leaveForm.getChaimVovcher().getCvStatus();
			//得到当前申请表的状态
			//如果状态不是待审批 传入状态位
			if (!cvStatus.equals("待审核")) {
				request.setAttribute("isChecked", 1);
				Set<CheckResult> checkResults = leaveForm.getChaimVovcher().getCheckResults();
				Iterator<CheckResult> iterator2 = checkResults.iterator();
				CheckResult myResult = iterator2.next();
				request.setAttribute("myResult", myResult);
			}
			request.setAttribute("leaveForm", leaveForm);
			return "showLeaveForm";
		}
		if (formType.equals("报销表")) {
			Set<ExpenseForm> expenseForms = myChaimVovcher.getExpenseForms();
			Iterator<ExpenseForm> iterator = expenseForms.iterator();
			ExpenseForm expenseForm = iterator.next();
			//1.获得当前申请表的状态
			String cvStatus = expenseForm.getChaimVovcher().getCvStatus();
			//2.判断申请表的状态
			if (!cvStatus.equals("待审核")) {
				//3.添加有审核结果的标志为
				request.setAttribute("isChecked", 1);
				//4.获得审核结果
				Set<CheckResult> checkResults = myChaimVovcher.getCheckResults();
				Iterator<CheckResult> iterator2 = checkResults.iterator();
				while (iterator2.hasNext()) {
					CheckResult checkResult = (CheckResult) iterator2.next();
					//从结果中取出角色标志位，如果这个结果的标志位是总经理，把这个结果manageResult放到request域
					if (checkResult.getRole().getRoleId() == 3) {
						request.setAttribute("manageResult", checkResult);
					}
					//如果这个结果的标志位是财务，把这个结果basicResult放到request域
					if (checkResult.getRole().getRoleId() == 4) {
						request.setAttribute("basicResult", checkResult);
					}
				}
			}
			request.setAttribute("expenseForm", expenseForm);
			return "showExpenseForm";
		}
		if (formType.equals("加班表")) {
			Set<OvertimeForm> overtimeForms = myChaimVovcher.getOvertimeForms();
			Iterator<OvertimeForm> iterator = overtimeForms.iterator();
			OvertimeForm overtimeForm = iterator.next();
			String cvStatus = overtimeForm.getChaimVovcher().getCvStatus();
			//得到当前申请表的状态
			//如果状态不是待审批 传入状态位
			//同时将审批结果myResult传入
			if (!cvStatus.equals("待审核")) {
				request.setAttribute("isChecked", 1);
				Set<CheckResult> checkResults = overtimeForm.getChaimVovcher().getCheckResults();
				Iterator<CheckResult> iterator2 = checkResults.iterator();
				CheckResult myResult = iterator2.next();
				request.setAttribute("myResult", myResult);
			}

			request.setAttribute("overtimeForm", overtimeForm);

			return "showOvertimeForm";
		}
		return "error";
	}

	/**
	 * 根据前台传递的申请单id， 点击查看申请表详情，同时进行审批
	 */
	public String showCheckDetail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String parameter = request.getParameter("cvid");
		Integer cvid = Integer.valueOf(parameter);
		System.out.println("-------------" + cvid);
		// 根据id查找具体的申请单
		ChaimVovcher myChaimVovcher = chaimVovcherService.showDetail(cvid);
		// 获得申请单的类型
		String formType = myChaimVovcher.getFormType();
		System.out.println(formType + "---------------------------");
		// 三种类型的情况对应三个页面
		if (formType.equals("请假表")) {
			Set<LeaveForm> leaveForms = myChaimVovcher.getLeaveForms();
			Iterator<LeaveForm> iterator = leaveForms.iterator();
			LeaveForm leaveForm = iterator.next();
			request.setAttribute("leaveForm", leaveForm);
			return "checkLeaveForm";
		}
		if (formType.equals("报销表")) {
			Set<ExpenseForm> expenseForms = myChaimVovcher.getExpenseForms();
			Iterator<ExpenseForm> iterator = expenseForms.iterator();
			ExpenseForm expenseForm = iterator.next();
			request.setAttribute("expenseForm", expenseForm);
			User user = (User) request.getSession().getAttribute("user");
			Set<Role> roles = user.getRoles();
			Iterator<Role> it = roles.iterator();
			while (it.hasNext()) {
				Role role = (Role) it.next();
				if (role.getRoleName().equals("总经理")) {
					Iterator<CheckResult> iterator2=myChaimVovcher.getCheckResults().iterator();
					CheckResult beforeResult=iterator2.next();
					request.setAttribute("beforeResult", beforeResult);
					request.setAttribute("isManager", 1);
				}
			}
			return "checkExpenseForm";
		}
		if (formType.equals("加班表")) {
			Set<OvertimeForm> overtimeForms = myChaimVovcher.getOvertimeForms();
			Iterator<OvertimeForm> iterator = overtimeForms.iterator();
			OvertimeForm overtimeForm = iterator.next();
			request.setAttribute("overtimeForm", overtimeForm);
			return "checkOvertimeForm";
		}
		return "error";
	}

}
