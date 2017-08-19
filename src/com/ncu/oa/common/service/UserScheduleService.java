package com.ncu.oa.common.service;

import java.util.List;
import java.sql.Date;
import java.sql.Timestamp;
import org.hibernate.criterion.DetachedCriteria;

import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserSchedule;

public interface UserScheduleService {
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

	/* 查询某人某个时间的行程安排 */
	public List findUserScheduleSometime(User user,Timestamp time);
	
	/* 查询某人未来一段时间的的行程安排(days表示天数) */
	public List findUserScheduleInTime(User user,int days);
	
	/* 查询某人某个时间某个项目的行程安排 */
	public UserSchedule findUserScheduleOne(User user,Timestamp time,String name);
	void deleteUserSchedule(Integer id);
	
	//根据id查询行程
	UserSchedule findScheduleById(Integer id);

}
