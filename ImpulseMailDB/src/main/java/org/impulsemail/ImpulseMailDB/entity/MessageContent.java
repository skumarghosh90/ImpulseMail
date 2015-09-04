package org.impulsemail.ImpulseMailDB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@SuppressWarnings("serial")
@Entity
@Table(name="MSG_CNTNT")
public class MessageContent extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MSG_CNTNT_ID_SEQ_GEN")
	@SequenceGenerator(name="MSG_CNTNT_ID_SEQ_GEN", sequenceName="MSG_CNTNT_ID_SEQ")
	private Long messageContentId;
	
	@Column(name="MSG_CNTNT_XML")
	@Type(type="org.hibernate.type.MaterializedClobType")
	private String msgContentXML;
	
	

}
