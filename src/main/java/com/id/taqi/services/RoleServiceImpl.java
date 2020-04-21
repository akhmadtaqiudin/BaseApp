package com.id.taqi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.taqi.dao.RoleDao;
import com.id.taqi.entity.Role;
import com.id.taqi.entity.RoleName;

@Service @Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	public Role findByName(RoleName roleName) {
		return roleDao.findByName(roleName);
	}

	@Override
	public Role getById(Long k) {
		return roleDao.getById(k);
	}

	@Override
	public List<Role> getAll() {
		return roleDao.getAll();
	}

	@Override
	public boolean save(Role e) {
		roleDao.save(e);
		return true;
	}

	@Override
	public boolean update(Role e) {
		roleDao.update(e);
		return true;
	}

	@Override
	public boolean delete(Role e) {
		roleDao.delete(e);
		return false;
	}
}