package com.id.taqi.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.id.taqi.dao.GenericDao;
import com.id.taqi.dao.UserDao;
import com.id.taqi.entity.User;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService{

	private UserDao userDao;
	
	public UserServiceImpl() {
		
	}
	public UserServiceImpl(@Qualifier("userDaoImpl")GenericDao<User, Integer> genericDao) {
		super(genericDao);
		this.userDao = (UserDao) genericDao;
	}
}
