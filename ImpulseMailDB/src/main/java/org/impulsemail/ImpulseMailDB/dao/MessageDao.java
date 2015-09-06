package org.impulsemail.ImpulseMailDB.dao;

import java.util.List;

import org.impulsemail.ImpulseMailDB.entity.Message;

public interface MessageDao extends BaseDao<Message, Long> {
	public List<Message> findAllMessagesBySenderUserId(Long userId);
	public List<Message> findAllMessagesByReceiverUserId(Long userId);
}
