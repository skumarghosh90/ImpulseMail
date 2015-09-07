package org.impulsemail.ImpulseMailDB.dao.impl;

import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.impulsemail.ImpulseMailDB.dao.UserDao;
import org.impulsemail.ImpulseMailDB.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() throws DataAccessException {
		return findAll(User.class);
	}

	@Override
	@Transactional(readOnly=true)
	public User findById(Integer id) throws DataAccessException {
		return findById(User.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public User findUserByUserLoginId(String userLoginId) {
		return (User) getCurrentSession().createCriteria(User.class).add(Restrictions.eq("userLoginId", userLoginId).ignoreCase()).uniqueResult();
	}

}
