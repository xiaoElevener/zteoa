package com.ncu.oa.common.dao;

import java.util.Date;
import java.util.List;

import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserHistory;

public interface UserHistoryDao {
	//1.保存用户经历
	public boolean saveUserHistory(UserHistory userHistory);
	//2.删除用户经历
	public boolean deleteUserHistory(UserHistory userHistory);
	//3.更新用户经历
	public boolean updateUserHistory(UserHistory userHistory);
	
	public List findAllUserHitories();
	//4.查询该用户的所有用户经历
	public List findUserHistoriesByUser(User user);
	//5.根据时间查询
	public UserHistory findUserHistory(User user, Date startTime);
	
	public UserHistory findHistoryById(Integer id);
}
