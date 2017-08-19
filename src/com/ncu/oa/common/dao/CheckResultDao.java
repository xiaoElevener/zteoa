package com.ncu.oa.common.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ncu.oa.common.entity.CheckResult;

public interface CheckResultDao {

	public boolean saveCheckResult(CheckResult checkResult);

	public boolean deleteCheckResult(CheckResult checkResult);

	public boolean updateCheckResult(CheckResult checkResult);

	public List findAllCheckResults();

	public CheckResult findCheckResultById(Integer id);

	/**
	 * 多条件查询
	 * 
	 * @param criteria
	 * @return
	 */
	public List findCheckResults(DetachedCriteria criteria);

}
