package org.impulsemail.ImpulseMailDB.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.impulsemail.ImpulseMailDB.dao.BaseDao;
import org.impulsemail.ImpulseMailDB.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseDaoImpl<E extends BaseEntity, K extends Serializable> implements BaseDao<E, K> {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<E> findAll(Class<E> entityClass) throws DataAccessException {
		return (List<E>) getCurrentSession().createCriteria(entityClass).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public E findById(Class<E> entityClass, K id) throws DataAccessException {
		return (E) getCurrentSession().load(entityClass, id);
	}

	@Override
	@Transactional
	public void save(E entity) {
		getCurrentSession().save(entity);
	}

	@Override
	@Transactional
	public void update(E entity) {
		getCurrentSession().update(entity);
	}

	@Override
	@Transactional
	public void saveOrUpdate(E entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	@Transactional
	public void delete(E entity) {
		getCurrentSession().delete(entity);
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
