package org.impulsemail.ImpulseMailDB.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(optional=false) 
	@JoinColumn(name="MSG_SNDR_USR_ID", nullable=false)
	private User messageSender;
	
	@ManyToOne(optional=false) 
	@JoinColumn(name="MSG_RCVR_USR_ID", nullable=false)
	private User messageReceiver;
	
	@Column(name="MSG_SENT_DTM", nullable=true)
	private Timestamp sentDtm;
	
	@Column(name="MSG_RCVD_DTM", nullable=true)
	private Timestamp receivedDtm;
	
	@Column(name="MSG_STS_AT_SNDR_END", length=5, nullable=false)
	private String msgStsAtSenderEnd;
	
	@Column(name="MSG_STS_AT_RCVR_END", length=5, nullable=false)
	private String msgStsAtReceiverEnd;

}
