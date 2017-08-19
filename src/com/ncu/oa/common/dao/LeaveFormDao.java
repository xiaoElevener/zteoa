package com.ncu.oa.common.dao;

import java.util.List;

import com.ncu.oa.common.entity.LeaveForm;

public interface LeaveFormDao {
	public boolean saveLeaveForm(LeaveForm leaveForm);

	public boolean deleteLeaveForm(LeaveForm leaveForm);

	public boolean updateLeaveForm(LeaveForm leaveForm);

	public List findAllLeaveForms();

	public LeaveForm findLeaveFormById(Integer id);
}
