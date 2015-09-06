package org.impulsemail.ImpulseMailDB.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="MSG")
public class Message extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MSG_ID_SEQ_GEN")
	@SequenceGenerator(name="MSG_ID_SEQ_GEN", sequenceName="MSG_ID_SEQ")
	@Column(name="MSG_ID")
	private Long messageId;
	
	@OneToMany
	@JoinColumn(name="MSG_CNTNT_ID", nullable=false)
	private MessageContent messageContent;
	
	@ManyToOne(optional=false) 
	@JoinColumn(name="MSG_SNDR_USR_ID", nullable=false)
	private User messageSender;
	
	@ManyToOne(optional=false) 
	@JoinColumn(name="MSG_RCVR_USR_ID", nullable=false)
	private User messageReceiver;
	
	@Column(name="MSG_STS_AT_SNDR_END", length=5, nullable=false)
	private String messageStatusAtSenderEnd;
	
	@Column(name="MSG_SENT_DTM", nullable=true)
	private Timestamp messageSentDtm;
	
	@Column(name="MSG_STS_AT_RCVR_END", length=5, nullable=false)
	private String messageStatusAtReceiverEnd;
	
	@Column(name="MSG_RCVD_DTM", nullable=true)
	private Timestamp messageReceivedDtm;
	
	

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public MessageContent getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(MessageContent messageContent) {
		this.messageContent = messageContent;
	}

	public User getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(User messageSender) {
		this.messageSender = messageSender;
	}

	public User getMessageReceiver() {
		return messageReceiver;
	}

	public void setMessageReceiver(User messageReceiver) {
		this.messageReceiver = messageReceiver;
	}

	public String getMessageStatusAtSenderEnd() {
		return messageStatusAtSenderEnd;
	}

	public void setMessageStatusAtSenderEnd(String messageStatusAtSenderEnd) {
		this.messageStatusAtSenderEnd = messageStatusAtSenderEnd;
	}

	public Timestamp getMessageSentDtm() {
		return messageSentDtm;
	}

	public void setMessageSentDtm(Timestamp messageSentDtm) {
		this.messageSentDtm = messageSentDtm;
	}

	public String getMessageStatusAtReceiverEnd() {
		return messageStatusAtReceiverEnd;
	}

	public void setMessageStatusAtReceiverEnd(String messageStatusAtReceiverEnd) {
		this.messageStatusAtReceiverEnd = messageStatusAtReceiverEnd;
	}

	public Timestamp getMessageReceivedDtm() {
		return messageReceivedDtm;
	}

	public void setMessageReceivedDtm(Timestamp messageReceivedDtm) {
		this.messageReceivedDtm = messageReceivedDtm;
	}

}
