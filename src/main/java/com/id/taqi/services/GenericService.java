package com.id.taqi.services;

import java.util.List;

public interface GenericService<E,K> {
	E getById(K k);
	List<E> getAll();
	boolean save(E e);
	boolean update(E e);
	boolean delete(E e);
}