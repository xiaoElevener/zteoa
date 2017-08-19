package com.ncu.oa.common.service;

import java.util.List;
import java.util.Set;

import com.ncu.oa.common.entity.ChaimVovcher;
import com.ncu.oa.common.entity.CheckResult;
import com.ncu.oa.common.entity.ExpenseForm;
import com.ncu.oa.common.entity.LeaveForm;
import com.ncu.oa.common.entity.OvertimeForm;
import com.ncu.oa.common.entity.User;

public interface ChaimVovcherService {

	/**
	 * 创建报销审批表
	 */
	public boolean createChaimVovcher(User user, ChaimVovcher chaimVovcher,
			ExpenseForm expenseForm);

	/**
	 * 创建请假审批表
	 */
	public boolean createChaimVovcher(User user, ChaimVovcher chaimVovcher,
			LeaveForm leaveForm);

	/**
	 * 创建加班审批表
	 */
	public boolean createChaimVovcher(User user, ChaimVovcher chaimVovcher,
			OvertimeForm overtimeForm);

	/**
	 * 提交审批表
	 */
	public boolean submitChaimVovcher(Integer chaimVovcherId);

	/**
	 * 查看用户提交过的审批单
	 */
	public List findChaimVovcherByUser(User user);

	/**
	 * 查询用户拥有的角色所需要的审批表
	 */
	public Set findCheckChaimVovchers(User user);

	/**
	 * 审批表单
	 */
	public boolean checkChaimVovcher(User user, CheckResult checkResult,
			Integer chaimVovcherId);

	/**
	 * 查看用户审批过的表单
	 */
	public List<ChaimVovcher> findChecked(User user);
	
	
	public ChaimVovcher showDetail(Integer cvid);

}
