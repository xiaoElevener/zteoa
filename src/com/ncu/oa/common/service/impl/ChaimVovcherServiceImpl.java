package com.ncu.oa.common.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncu.oa.common.dao.ChaimVovcherDao;
import com.ncu.oa.common.dao.CheckResultDao;
import com.ncu.oa.common.dao.ExpenseFormDao;
import com.ncu.oa.common.dao.LeaveFormDao;
import com.ncu.oa.common.dao.OvertimeFormDao;
import com.ncu.oa.common.dao.RoleDao;
import com.ncu.oa.common.entity.ChaimVovcher;
import com.ncu.oa.common.entity.CheckResult;
import com.ncu.oa.common.entity.ExpenseForm;
import com.ncu.oa.common.entity.LeaveForm;
import com.ncu.oa.common.entity.OvertimeForm;
import com.ncu.oa.common.entity.Role;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.service.AttendanceService;
import com.ncu.oa.common.service.ChaimVovcherService;

@Service
public class ChaimVovcherServiceImpl implements ChaimVovcherService {
	/**
	 * 约定
	 */
	public static int EMPLOYEE = 1;// 员工角色编号
	public static int MANAGER = 2;// 部门经理编号
	public static int BOSS = 3;// 总经理编号
	public static int FINANCE = 4;// 财务编号
	public static int ADMIN = 5;// 管理员编号

	public static double BOUND = 5000.0;

	public static String CLAIMS = "报销表";
	public static String LEAVE = "请假表";
	public static String OVERTIME = "加班表";

	public static String PASS = "通过";
	public static String NOTPASS = "未通过";

	@Autowired
	private ChaimVovcherDao chaimVovcherDao;

	@Autowired
	private ExpenseFormDao expenseFormDao;

	@Autowired
	private LeaveFormDao leaveFormDao;

	@Autowired
	private OvertimeFormDao overtimeFormDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private CheckResultDao checkResultDao;

	@Autowired
	private AttendanceService attendanceService;

	/**
	 * 表单创建之前的一些默认操作
	 * 
	 * @param chaimVovcher
	 * @return
	 */
	public ChaimVovcher beforeCreate(ChaimVovcher chaimVovcher, User user) {
		chaimVovcher.setCvStatus("待审核");
		chaimVovcher.setCvCreateTime(new Date());
		chaimVovcher.setCvModifyTime(new Date());
		chaimVovcher.setUser(user);
		return chaimVovcher;
	}

	/**
	 * 审核操作通过后的一些操作
	 */
	public void afterCheckPass(ChaimVovcher chaimVovcher) {
		// 如果是报销表
		if (chaimVovcher.getFormType().equals(CLAIMS)) {
			// 发钱给员工呗
		}

		// 如果是请假表，需要往考勤表插入数据
		if (chaimVovcher.getFormType().equals(LEAVE)) {
			Iterator<LeaveForm> iterator = chaimVovcher.getLeaveForms()
					.iterator();
			if (iterator.hasNext()) {
				LeaveForm leaveForm = iterator.next();
				attendanceService.askForLeave(chaimVovcher.getUser(),
						leaveForm.getLeFStarttime(), leaveForm.getLeFEndtime());
			}
		}

		// 如果是加班表
		if (chaimVovcher.getFormType().equals(OVERTIME)) {
			Iterator<OvertimeForm> iterator = chaimVovcher.getOvertimeForms()
					.iterator();
			if (iterator.hasNext()) {
				OvertimeForm overtimeForm = iterator.next();
				attendanceService.workOvertime(chaimVovcher.getUser(),
						overtimeForm.getOtFDate());
			}
		}

	}

	/**
	 * 审批交接(分情况讨论)
	 * 
	 * @param chaimVovcher
	 * @return
	 */
	public ChaimVovcher changeRole(ChaimVovcher chaimVovcher) {
		// 如果是报销表
		if (chaimVovcher.getFormType().equals(CLAIMS)) {
			// 如果超过BOUND给老板审批
			Set<ExpenseForm> set = chaimVovcher.getExpenseForms();
			Iterator<ExpenseForm> iterator = set.iterator();

			ExpenseForm expenseForm = iterator.next();

			// 如果老板审批，就没有下个角色审批
			if (chaimVovcher.getRole().getRoleId() == BOSS)
				chaimVovcher.setRole(null);
			else if (expenseForm != null && expenseForm.getExFAccount() > BOUND) {
				chaimVovcher.setRole(roleDao.findRoleById(BOSS));
			} else {
				chaimVovcher.setRole(null); // 结束审批
			}
		}

		// 如果是请假表
		if (chaimVovcher.getFormType().equals(LEAVE)) {
			// 结束审批
			chaimVovcher.setRole(null);
		}

		// 如果是加班表
		if (chaimVovcher.getFormType().equals(OVERTIME)) {
			chaimVovcher.setRole(null);
		}

		return chaimVovcher;
	}

	/**
	 * 创建报销审批表
	 */
	@Override
	public boolean createChaimVovcher(User user, ChaimVovcher chaimVovcher,
			ExpenseForm expenseForm) {
		chaimVovcher = beforeCreate(chaimVovcher, user);
		chaimVovcher.setRole(roleDao.findRoleById(FINANCE));
		chaimVovcher.setFormType(CLAIMS);
		// 创建审批表单
		Integer cvId = chaimVovcherDao.saveChaimVovcher(chaimVovcher);
		expenseForm.setExFId(cvId);//
		// 创建报销表单
		expenseFormDao.saveExpenseForm(expenseForm);
		return true;
	}

	/**
	 * 创建请假审批表
	 */
	@Override
	public boolean createChaimVovcher(User user, ChaimVovcher chaimVovcher,
			LeaveForm leaveForm) {
		chaimVovcher = beforeCreate(chaimVovcher, user);
		chaimVovcher.setRole(roleDao.findRoleById(MANAGER));
		chaimVovcher.setFormType(LEAVE);
		Integer cvId = chaimVovcherDao.saveChaimVovcher(chaimVovcher);
		leaveForm.setLeFId(cvId);
		leaveFormDao.saveLeaveForm(leaveForm);
		return true;
	}

	/**
	 * 创建加班审批表
	 */
	@Override
	public boolean createChaimVovcher(User user, ChaimVovcher chaimVovcher,
			OvertimeForm overtimeForm) {
		chaimVovcher = beforeCreate(chaimVovcher, user);
		chaimVovcher.setRole(roleDao.findRoleById(MANAGER));
		chaimVovcher.setFormType(OVERTIME);
		Integer cvId = chaimVovcherDao.saveChaimVovcher(chaimVovcher);
		overtimeForm.setOtFId(cvId);
		overtimeFormDao.saveOvertimeForm(overtimeForm);
		return true;
	}

	/**
	 * 用户提交表单
	 */
	@Override
	public boolean submitChaimVovcher(Integer chaimVovcherId) {
		ChaimVovcher chaimVovcher = chaimVovcherDao
				.findChaimVovcherById(chaimVovcherId);

		chaimVovcher.setCvStatus("审核中");
		chaimVovcherDao.updateChaimVovcher(chaimVovcher);
		return true;
	}

	/**
	 * 用户查看拥有审批表单
	 */
	@Override
	public List findChaimVovcherByUser(User user) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ChaimVovcher.class);
		criteria.add(Restrictions.eq("user", user));
		return chaimVovcherDao.findChaimVovchers(criteria);
	}

	/**
	 * 用户拥有的角色查看需要审批表单 角色不能审批自己的审批单
	 */
	@Override
	public Set<ChaimVovcher> findCheckChaimVovchers(User user) {
		Set<Role> roles = (Set<Role>) user.getRoles();
		Set<ChaimVovcher> chaimVovchers = new HashSet<ChaimVovcher>();
		for (Role role : roles) {
			DetachedCriteria criteria = DetachedCriteria
					.forClass(ChaimVovcher.class);
			criteria.add(Restrictions.eq("role", role))
					.add(Restrictions.eq("cvStatus", "待审核"))
					.add(Restrictions.ne("user", user));
			List<ChaimVovcher> list = chaimVovcherDao
					.findChaimVovchers(criteria);
			chaimVovchers.addAll(list);
		}
		return chaimVovchers;
	}

	/**
	 * 审批
	 */
	@Override
	public boolean checkChaimVovcher(User user, CheckResult checkResult,
			Integer chaimVovcherId) {
		ChaimVovcher chaimVovcher = chaimVovcherDao
				.findChaimVovcherById(chaimVovcherId);

		checkResult.setChaimVovcher(chaimVovcher);

		Role next_role = chaimVovcher.getRole();

		checkResult.setRole(next_role);// 设置审批的角色

		changeRole(chaimVovcher); // 设置下个审批的角色

		checkResult.setUser(user);
		checkResult.setCkTime(new Date());

		// 状态检查
		String result = checkResult.getCkResult();

		if (result.equals(NOTPASS)) {
			chaimVovcher.setCvStatus("已驳回");
			chaimVovcher.setRole(null);
		} else {
			if (chaimVovcher.getRole() != null)
				chaimVovcher.setCvStatus("待审核");
			else {
				chaimVovcher.setCvStatus("已批准");
				afterCheckPass(chaimVovcher);
			}

		}
		checkResultDao.saveCheckResult(checkResult);

		return true;
	}

	/**
	 * 查看用户审核过的审批表
	 */
	@Override
	public List<ChaimVovcher> findChecked(User user) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ChaimVovcher.class);
		criteria.add(Restrictions.eq("user", user));
		List<ChaimVovcher> list = checkResultDao.findCheckResults(criteria);
		return list;
	}

	@Override
	public ChaimVovcher showDetail(Integer cvid) {
		return chaimVovcherDao.findChaimVovcherById(cvid);
	}
}
