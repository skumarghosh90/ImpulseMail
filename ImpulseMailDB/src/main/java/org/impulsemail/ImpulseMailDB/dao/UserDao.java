package org.impulsemail.ImpulseMailDB.dao;

import org.impulsemail.ImpulseMailDB.entity.User;

public interface UserDao extends BaseDao<User,Integer>{
	public User findUserByUserLoginId(String username);

}
