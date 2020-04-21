package com.id.taqi.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.id.taqi.entity.Role;
import com.id.taqi.entity.RoleName;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role, Long> implements RoleDao{
	
	@Override
	public Role findByName(RoleName roleName) {
		String sql = "FROM com.id.taqi.entity.Role where name=:name";
		Query query = currentSession().createQuery(sql);
        query.setParameter("name", roleName);
        return (Role) query.getSingleResult();
	}
}