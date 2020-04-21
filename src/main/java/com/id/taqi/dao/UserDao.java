package com.id.taqi.dao;

import com.id.taqi.entity.User;

public interface UserDao extends GenericDao<User, Long>{

	User findByUserName(String userName);
	Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
}