package com.id.taqi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.taqi.dao.EmployeeDao;
import com.id.taqi.entity.Employee;

@Service @Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Override
	public Employee getById(Long id) {
		return employeeDao.getById(id);
	}

	@Override
	public boolean save(Employee employee) {
		employeeDao.save(employee);
		return true;
	}

	@Override
	public boolean update(Employee employee) {
		employeeDao.update(employee);
		return true;
	}

	@Override
	public boolean delete(Employee employee) {
		employeeDao.delete(employee);
		return true;
	}

}