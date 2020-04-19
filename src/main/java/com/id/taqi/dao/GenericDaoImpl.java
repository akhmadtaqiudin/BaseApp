package com.id.taqi.dao;

import java.util.List;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDaoImpl<E, K> implements GenericDao<E, K>{

	protected Class<E> entityClass;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected GenericDaoImpl() {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            this.entityClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
        }
    }
	
	protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<E> getAll() { 
        return currentSession().createCriteria(entityClass).list(); 
	}

	@Override
	public E getById(K k) {
		return (E) currentSession().find(entityClass, k);
	}

	@Override
	public boolean delete(E e) {
		currentSession().delete(e);
		return true;
	}

	@Override
	public boolean save(E e) {
		currentSession().save(e);
		return true;
	}

	@Override
	public boolean update(E e) {
		currentSession().update(e);
		return true;
	}

}
