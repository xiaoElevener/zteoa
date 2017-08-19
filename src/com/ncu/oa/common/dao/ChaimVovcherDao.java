package com.ncu.oa.common.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ncu.oa.common.entity.ChaimVovcher;
import com.ncu.oa.common.entity.User;

public interface ChaimVovcherDao {
	/**
	 * 保存的时候返回id
	 * 
	 * @param chaimVovcher
	 * @return
	 */
	public Integer saveChaimVovcher(ChaimVovcher chaimVovcher);

	public boolean deleteChaimVovcher(ChaimVovcher chaimVovcher);

	public boolean updateChaimVovcher(ChaimVovcher chaimVovcher);

	public List findAllChaimVovchers();

	public ChaimVovcher findChaimVovcherById(Integer id);

	public List findChaimVovchers(DetachedCriteria criteria);
}
