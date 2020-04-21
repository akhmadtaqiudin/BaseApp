package com.id.taqi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.taqi.common.FileNotFoundException;
import com.id.taqi.dao.UserDao;
import com.id.taqi.dto.UserDto;
import com.id.taqi.entity.User;

@Service @Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		try {
			User user = userDao.findByUserName(userName);
			return UserDto.build(user);
		} catch (Exception e) {
			throw new FileNotFoundException("User Not Found with -> username : " + userName);
		}
	}
}