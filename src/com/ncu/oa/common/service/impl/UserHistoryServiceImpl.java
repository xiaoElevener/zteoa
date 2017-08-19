package com.ncu.oa.common.service.impl;

import java.util.Date;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncu.oa.common.dao.UserHistoryDao;
import com.ncu.oa.common.entity.User;
import com.ncu.oa.common.entity.UserHistory;
import com.ncu.oa.common.service.UserHistoryService;

//为serivce层实现类进行标注
@Service
public class UserHistoryServiceImpl implements UserHistoryService {
	@Autowired
	private UserHistoryDao userHistoryDao;
	@Override
	public boolean saveUserHistory(UserHistory userHistory) {
		userHistoryDao.saveUserHistory(userHistory);
		return true;
	}

	@Override
	public boolean deleteUserHistory(UserHistory userHistory) {
		userHistoryDao.deleteUserHistory(userHistory);
		return true;
	}

	@Override
	public boolean updateUserHistory(UserHistory userHistory) {
		userHistoryDao.updateUserHistory(userHistory);
		return true;
	}

	@Override
	public List findAllUserHitories() {
		
		return userHistoryDao.findAllUserHitories();
	}

	@Override
	public List findUserHistoriesByUser(User user) {
		return userHistoryDao.findUserHistoriesByUser(user);
	}

	@Override
	public UserHistory findUserHistory(User user, Date startTime) {

		return null;
	}
	@Override
	public UserHistory findHistoryById(Integer id) {
		return userHistoryDao.findHistoryById(id);
	}

}
