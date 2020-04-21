package com.id.taqi.services;

import com.id.taqi.entity.Role;
import com.id.taqi.entity.RoleName;

public interface RoleService extends GenericService<Role, Long>{

	Role findByName(RoleName roleName);
}