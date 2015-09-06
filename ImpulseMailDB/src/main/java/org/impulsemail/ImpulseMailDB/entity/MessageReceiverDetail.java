package org.impulsemail.ImpulseMailDB.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.impulsemail.ImpulseMailDB.types.MessageStatusType;

@SuppressWarnings("serial")
@Entity
@Table(name="MSG_RCVR_DTL")
public class MessageReceiverDetail extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MSG_RCVR_DTL_ID_SEQ_GEN")
	@SequenceGenerator(name="MSG_RCVR_DTL_ID_SEQ_GEN", sequenceName="MSG_RCVR_DTL_ID_SEQ")
	@Column(name="MSG_RCVR_DTL_ID")
	private Long messageReceiverDetailId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="MSG_ID",nullable=false)
	private Message message;

	@ManyToOne(optional=false) 
	@JoinColumn(name="MSG_RCVR_USR_ID", nullable=false)
	private User messageReceiver;
	
	@Enumerated(EnumType.STRING)
	@Column(name="MSG_STS_AT_RCVR_END", length=5, nullable=false)
	private MessageStatusType messageStatusAtReceiverEnd;
	
	@Column(name="MSG_RCVD_DTM", nullable=true)
	private Timestamp messageReceivedDtm;
	
	
	
	public Long getMessageReceiverDetailId() {
		return messageReceiverDetailId;
	}

	public void setMessageReceiverDetailId(Long messageReceiverDetailId) {
		this.messageReceiverDetailId = messageReceiverDetailId;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public User getMessageReceiver() {
		return messageReceiver;
	}

	public void setMessageReceiver(User messageReceiver) {
		this.messageReceiver = messageReceiver;
	}
	
	public MessageStatusType getMessageStatusAtReceiverEnd() {
		return messageStatusAtReceiverEnd;
	}

	public void setMessageStatusAtReceiverEnd(MessageStatusType messageStatusAtReceiverEnd) {
		this.messageStatusAtReceiverEnd = messageStatusAtReceiverEnd;
	}

	public Timestamp getMessageReceivedDtm() {
		return messageReceivedDtm;
	}

	public void setMessageReceivedDtm(Timestamp messageReceivedDtm) {
		this.messageReceivedDtm = messageReceivedDtm;
	}
	
}
