package com.id.taqi.dao;

import java.util.List;

public interface GenericDao<E,K> {
	E getById(K k);
	List<E> getAll();
	boolean save(E e);
	boolean update(E e);
	boolean delete(E e);
}
