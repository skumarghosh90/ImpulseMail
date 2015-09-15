package org.impulsemail.ImpulseMailDB.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
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
	public List<Message> findAllSentMessagesByUserId(Long userId) {
		Criteria criteria = getCurrentSession().createCriteria(Message.class);
		criteria.add(Restrictions.eq("messageSender.userId", userId));
		criteria.add(Restrictions.eq("messageStatusAtSenderEnd", MessageStatusType.SENT.getMessageStatusTypeCode()));
		criteria.addOrder(Order.desc("messageSentDtm"));
		
		return (List<Message>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Message> findAllSentMessagesBySubject(String subject) {
		Criteria criteria = getCurrentSession().createCriteria(Message.class);
		criteria.add(Restrictions.ilike("messageSubject", subject, MatchMode.ANYWHERE));
		criteria.add(Restrictions.eq("messageStatusAtSenderEnd", MessageStatusType.SENT.getMessageStatusTypeCode()));
		criteria.addOrder(Order.desc("messageSentDtm"));
		
		return (List<Message>) criteria.list();
	}

	

}
