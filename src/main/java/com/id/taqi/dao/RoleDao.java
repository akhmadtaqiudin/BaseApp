package com.id.taqi.dao;

import com.id.taqi.entity.Role;
import com.id.taqi.entity.RoleName;

public interface RoleDao extends GenericDao<Role, Long>{

	Role findByName(RoleName roleName);
}