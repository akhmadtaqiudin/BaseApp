package com.id.taqi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.taqi.dao.UserDao;
import com.id.taqi.entity.User;

@Service @Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}
	
	public Boolean existsByUserName(String userName) {
		return userDao.existsByUserName(userName);
	}
	
	public Boolean existsByEmail(String email) {
		return userDao.existsByEmail(email);
	}

	@Override
	public User getById(Long k) {
		return userDao.getById(k);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public boolean save(User e) {
		userDao.save(e);
		return true;
	}

	@Override
	public boolean update(User e) {
		userDao.update(e);
		return true;
	}

	@Override
	public boolean delete(User e) {
		userDao.delete(e);
		return true;
	}
}