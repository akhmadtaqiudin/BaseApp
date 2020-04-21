package com.id.taqi.services;

import com.id.taqi.entity.User;

public interface UserService extends GenericService<User, Long>{

	User findByUserName(String userName);
	Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
}