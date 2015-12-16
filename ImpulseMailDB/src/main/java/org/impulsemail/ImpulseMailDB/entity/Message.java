package org.impulsemail.ImpulseMailDB.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.impulsemail.ImpulseMailDB.types.MessageStatusType;

@SuppressWarnings("serial")
@Entity
@Table(name="MSG", indexes={@Index(name="INDEX_MSG_SUBJCT", columnList = "MSG_SUBJCT"),
							@Index(name="INDEX_MSG_SENT_DTM", columnList="MSG_SENT_DTM")})
public class Message extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MSG_ID_SEQ_GEN")
	@SequenceGenerator(name="MSG_ID_SEQ_GEN", sequenceName="MSG_ID_SEQ")
	@Column(name="MSG_ID")
	private Long messageId;
	
	@Column(name="MSG_SUBJCT", nullable=true, length=300)
	private String messageSubject;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="MSG_CNTNT_ID", nullable=false)
	private MessageContent messageContent;
	
	@ManyToOne(optional=false) 
	@JoinColumn(name="MSG_SNDR_USR_ID", nullable=false)
	private User messageSender;
	
	@Enumerated(EnumType.STRING)
	@Column(name="MSG_STS_AT_SNDR_END", length=5, nullable=false)
	private MessageStatusType messageStatusAtSenderEnd;
	
	@Column(name="MSG_SENT_DTM", nullable=true)
	private Timestamp messageSentDtm;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<MessageReceiverDetail> messageReceivers;

	
	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getMessageSubject() {
		return messageSubject;
	}

	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
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

	public MessageStatusType getMessageStatusAtSenderEnd() {
		return messageStatusAtSenderEnd;
	}

	public void setMessageStatusAtSenderEnd(MessageStatusType messageStatusAtSenderEnd) {
		this.messageStatusAtSenderEnd = messageStatusAtSenderEnd;
	}

	public Timestamp getMessageSentDtm() {
		return messageSentDtm;
	}

	public void setMessageSentDtm(Timestamp messageSentDtm) {
		this.messageSentDtm = messageSentDtm;
	}

}
