package com.id.taqi.dao;

import java.util.List;

public interface GenericDao<E,K> {
    public void saveOrUpdate(E entity) ;
    public void remove(E entity);
    public E findById(K key);
    public List<E> getAll() ;
    public List<E> getByExample(E entity);
}
