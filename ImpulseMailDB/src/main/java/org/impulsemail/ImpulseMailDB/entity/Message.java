package org.impulsemail.ImpulseMailDB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="MAIL_MSG")
public class Message extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MSG_ID")
	private Long messageId;
	
	@Column(name="MSG_SNDR_USER_ID")
	@OneToMany() Todo.. check mapping
	private Long messageSenderUserId;

}
