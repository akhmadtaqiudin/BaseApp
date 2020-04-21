/*
 * package com.id.taqi.services;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service; import
 * org.springframework.transaction.annotation.Propagation; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.id.taqi.dao.GenericDao;
 * 
 * @Service public class GenericServiceImpl<E, K> implements GenericService<E,
 * K> {
 * 
 * @Autowired private GenericDao<E, K> genericDao;
 * 
 * @Override
 * 
 * @Transactional(propagation = Propagation.REQUIRED, readOnly = true) public E
 * getById(K k) { return genericDao.getById(k); }
 * 
 * @Override
 * 
 * @Transactional(propagation = Propagation.REQUIRED, readOnly = true) public
 * List<E> getAll() { return genericDao.getAll(); }
 * 
 * @Override public boolean save(E e) { genericDao.save(e); return true; }
 * 
 * @Override public boolean update(E e) { genericDao.update(e); return true; }
 * 
 * @Override public boolean delete(E e) { genericDao.delete(e); return true; }
 * 
 * }
 */