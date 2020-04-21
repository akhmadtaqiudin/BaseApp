package com.id.taqi.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.id.taqi.entity.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao{
	
	@Override
	public User findByUserName(String userName) {
		String sql = "FROM com.id.taqi.entity.User where user_name=:user_name";
		Query query = currentSession().createQuery(sql);
        query.setParameter("user_name", userName);
        return (User) query.getSingleResult();
	}

	@Override
	public Boolean existsByUserName(String userName) {
		String sql = "FROM com.id.taqi.entity.User where user_name=:user_name";
		Query query = currentSession().createQuery(sql);
		query.setParameter("user_name", userName);
        return query.getResultList().size() > 0;
	}

	@Override
	public Boolean existsByEmail(String email) {
		String sql = "FROM com.id.taqi.entity.User where email=:email";
		Query query = currentSession().createQuery(sql);
		query.setParameter("email", email);
        return query.getResultList().size() > 0;
	}

}