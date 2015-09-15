package org.impulsemail.ImpulseMailDB.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.impulsemail.ImpulseMailDB.types.ContactStatusType;

@Entity
@Table(name="CNTCT")
public class Contacts {
	
	@EmbeddedId
	private ContactsPrimaryKey contactsPrimaryKey;
	
	@Enumerated(EnumType.STRING)
	@Column(name="CNTCT_STS_TYP_CDE", length=5, nullable=false)
	private ContactStatusType contactStatusTypeCode;
	
}
