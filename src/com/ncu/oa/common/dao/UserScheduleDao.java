package com.ncu.oa.common.dao;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserSchedule;

public interface UserScheduleDao {
	/* 添加个人日程安排 */
	public boolean saveUserSchedule(UserSchedule userSchedule);

	/* 删除某条个人日程安排信息 */
	public boolean deleteUserSchedule(UserSchedule userSchedule);

	/* 修改某条日程安排历信息 */
	public boolean updateUserSchedule(UserSchedule userSchedule);

	/* 查询所有人的日程安排信息 */
	public List findAllUserSchedules();

	/* 查询个人所有的日程信息 */
	public List findUserSchedulesByUser(User user);

	/* 条件查询日程安排 */
	public List findUserSchedule(DetachedCriteria criteria);
	
	void deleteUserSchedule(Integer id);
	UserSchedule findScheduleById(Integer id);

}
