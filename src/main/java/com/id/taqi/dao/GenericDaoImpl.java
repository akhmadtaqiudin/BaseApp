package com.id.taqi.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {
	
    @Autowired
    private SessionFactory sessionFactory;
    protected Class<? extends E> daoType;

    /**
     * By defining this class as abstract, we prevent Spring from creating instance of this class
     * If not defined abstract getClass().getGenericSuperClass() would return Object.
     * There would be exception because Object class does not hava constructor with parameters.
     */
    public GenericDaoImpl() {
    	Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }
    
    protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

    public void saveOrUpdate(E entity) {
    	getSession().saveOrUpdate(entity);
    }

    public void remove(E entity) {
    	getSession().delete(entity);
    }

    public E findById(K key) {
        return (E) getSession().get(this.daoType, key);
    }

    public List<E> getAll() {
    	//Example example = Example.create(entity).ignoreCase().enableLike().excludeZeroes();
		return getSession().createCriteria(this.daoType).list();
    }
    
    public List<E> getByExample(E entity){
    	Example example = Example.create(entity).ignoreCase().enableLike().excludeZeroes();
		return getSession().createCriteria(this.daoType).add(example).list();
    }
}
