package org.impulsemail.ImpulseMailDB.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.impulsemail.ImpulseMailDB.dao.MessageDao;
import org.impulsemail.ImpulseMailDB.entity.Message;
import org.impulsemail.ImpulseMailDB.types.MessageStatusType;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

public class MessageDaoImpl extends BaseDaoImpl<Message, Long>implements MessageDao {

	@Override
	@Transactional(readOnly=true)
	public List<Message> findAll() throws DataAccessException {
		return findAll(Message.class);
	}

	@Override
	@Transactional(readOnly=true)
	public Message findById(Long id) throws DataAccessException {
		return findById(Message.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Message> findAllMessagesBySenderUserId(Long userId) {
		Criteria criteria = getCurrentSession().createCriteria(Message.class);
		criteria.add(Restrictions.eq("messageSender.userId", userId));
		criteria.add(Restrictions.eq("messageStatusAtSenderEnd", MessageStatusType.SENT.getMessageStatusTypCode()));
		criteria.addOrder(Order.desc("messageSentDtm"));
		
		return (List<Message>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Message> findAllMessagesByReceiverUserId(Long userId) {
		Criteria criteria = getCurrentSession().createCriteria(Message.class);
		criteria.add(Restrictions.eq("messageReceiver.userId", userId));
		criteria.add(Restrictions.in("messageStatusAtReceiverEnd", 
				new String[] {MessageStatusType.RCVD.getMessageStatusTypCode(),MessageStatusType.}));
		criteria.addOrder(Order.desc("messageSentDtm"));
		
		return (List<Message>) criteria.list();
	}

	

}
