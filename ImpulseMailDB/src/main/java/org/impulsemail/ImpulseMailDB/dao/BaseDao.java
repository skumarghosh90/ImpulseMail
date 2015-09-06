package org.impulsemail.ImpulseMailDB.dao;

import java.io.Serializable;
import java.util.List;

import org.impulsemail.ImpulseMailDB.entity.BaseEntity;
import org.impulsemail.ImpulseMailDB.entity.Message;
import org.impulsemail.ImpulseMailDB.entity.User;
import org.springframework.dao.DataAccessException;

public interface BaseDao<E extends BaseEntity, K extends Serializable> {
	
	public List<E> findAll(Class<E> entityClass) throws DataAccessException;
	public E findById(Class<E> entityClass,K id) throws DataAccessException;
	//For DaoImpls to implement
	public List<E> findAll() throws DataAccessException;
	public E findById(K id) throws DataAccessException;
	
	public void save(E entity);
	public void update(E entity);
	public void saveOrUpdate(E entity);
	public void delete(E entity);
	
}
