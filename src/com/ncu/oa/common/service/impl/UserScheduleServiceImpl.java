package com.ncu.oa.common.service.impl;

import java.util.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ncu.oa.common.dao.UserScheduleDao;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserHistory;
import com.ncu.oa.common.entity.UserSchedule;
import com.ncu.oa.common.service.UserScheduleService;

@Service
public class UserScheduleServiceImpl implements UserScheduleService {
	@Autowired
	private UserScheduleDao userScheduleDao;

	@Override
	public boolean saveUserSchedule(UserSchedule userSchedule) {
		userScheduleDao.saveUserSchedule(userSchedule);
		return true;
	}

	@Override
	public boolean deleteUserSchedule(UserSchedule userSchedule) {
		userScheduleDao.deleteUserSchedule(userSchedule);
		return true;
	}

	@Override
	public boolean updateUserSchedule(UserSchedule userSchedule) {
		userScheduleDao.updateUserSchedule(userSchedule);
		return true;
	}

	@Override
	public List findAllUserSchedules() {
		List list = userScheduleDao.findAllUserSchedules();
		return list;
	}

	@Override
	public List findUserSchedulesByUser(User user) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(UserSchedule.class);
		criteria.add(Restrictions.eq("user", user));
		return userScheduleDao.findUserSchedule(criteria);
	}

	@Override
	public List findUserScheduleSometime(User user, Timestamp time) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(UserSchedule.class);
		criteria.add(Restrictions.eq("user", user)).add(Restrictions.and(
						Restrictions.lt("scStartTime", time),
						Restrictions.gt("scEndTime", time)));
		List<UserSchedule> list = userScheduleDao.findUserSchedule(criteria);
		return list;
		/*DetachedCriteria criteria = DetachedCriteria
				.forClass(UserSchedule.class);
		criteria.add(Restrictions.eq("user", user));
		List list = userScheduleDao.findUserSchedule(criteria);
		Iterator<UserSchedule> iterator = list.iterator();
		while (iterator.hasNext()) {
			UserSchedule userSchedule = (UserSchedule) iterator.next();
			if (userSchedule.getScStartTime().getTime() < time.getTime()
					&& userSchedule.getScEndTime().getTime() > time.getTime()) {
				criteria.add(Restrictions.eq("user", user)).add(
						Restrictions.eq("scStartTime",
								userSchedule.getScStartTime()));
				list = userScheduleDao.findUserSchedule(criteria);
			} else {
				list = null;
			}
		}
		
		 // criteria.add(Restrictions.eq("user",
		 //user)).add(Restrictions.eq("scStartTime", time)); return
		 // userScheduleDao.findUserSchedule(criteria);
		 
		return list;*/

	}

	@Override
	public List findUserScheduleInTime(User user, int days) {
		Date now = new Date();
		Calendar future = Calendar.getInstance();
		future.setTime(new Date());
		future.add(Calendar.DATE, 30);
		DetachedCriteria criteria = DetachedCriteria
				.forClass(UserSchedule.class);
		criteria.add(Restrictions.eq("user", user)).add(
				Restrictions.not(Restrictions.or(
						Restrictions.lt("scEndTime", now),
						Restrictions.gt("scStartTime", future.getTime()))));
		List<UserSchedule> list = userScheduleDao.findUserSchedule(criteria);
		return list;

		// long day=(long)days*24*3600*1000;//将天数转换为毫秒数
		// DetachedCriteria
		// criteria=DetachedCriteria.forClass(UserSchedule.class);
		// criteria.add(Restrictions.eq("user", user));
		// List list=userScheduleDao.findUserSchedule(criteria);
		// Iterator<UserSchedule> iterator = list.iterator();
		// while (iterator.hasNext()) {
		// UserSchedule userSchedule = (UserSchedule) iterator.next();
		// if(userSchedule.getScStartTime().getTime()<(System.currentTimeMillis()+day)&&userSchedule.getScStartTime().getTime()>System.currentTimeMillis()){
		// criteria.add(Restrictions.eq("user",
		// user)).add(Restrictions.eq("scStartTime",
		// userSchedule.getScStartTime()));
		// list= userScheduleDao.findUserSchedule(criteria);
		// }
		// else {
		// list= null;
		// }
		// }
		// /*criteria.add(Restrictions.eq("user",
		// user)).add(Restrictions.eq("scStartTime", time));
		// return userScheduleDao.findUserSchedule(criteria);
		// long ct = System.currentTimeMillis()*/
		// return list;
	}

	@Override
	public UserSchedule findUserScheduleOne(User user, Timestamp time,
			String name) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(UserSchedule.class);
		criteria.add(Restrictions.eq("user", user)).add(Restrictions.and(
						Restrictions.lt("scStartTime", time),
						Restrictions.gt("scEndTime", time),Restrictions.eq("scName", name)));
		List<UserSchedule> list = userScheduleDao.findUserSchedule(criteria);
		UserSchedule userSchedule=list.get(0);
		return userSchedule;
	}

	@Override
	public void deleteUserSchedule(Integer id) {
		userScheduleDao.deleteUserSchedule(id);
		
	}

	@Override
	public UserSchedule findScheduleById(Integer id) {
		return userScheduleDao.findScheduleById(id);
	}
}
