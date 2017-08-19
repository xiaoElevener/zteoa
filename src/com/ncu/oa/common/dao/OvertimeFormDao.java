package com.ncu.oa.common.dao;

import java.util.List;

import com.ncu.oa.common.entity.OvertimeForm;

public interface OvertimeFormDao {
	public boolean saveOvertimeForm(OvertimeForm overtimeForm);

	public boolean deleteOvertimeForm(OvertimeForm overtimeForm);

	public boolean updateOvertimeForm(OvertimeForm overtimeForm);

	public List findAllOvertimeForms();

	public OvertimeForm findOvertimeFormById(Integer id);
}
