package org.impulsemail.ImpulseMailDB.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.impulsemail.ImpulseMailDB.types.ContactStatusType;

@Entity
@Table(name="CNTACT")
public class Contacts {
	
	@EmbeddedId
	private ContactsPrimaryKey contactsPrimaryKey;
	
	@Enumerated(EnumType.STRING)
	@Column(name="CNTACT_STS_TYP_CDE", length=5, nullable=false)
	private ContactStatusType contactStatusTypeCode;
	
	

	public ContactsPrimaryKey getContactsPrimaryKey() {
		return contactsPrimaryKey;
	}

	public void setContactsPrimaryKey(ContactsPrimaryKey contactsPrimaryKey) {
		this.contactsPrimaryKey = contactsPrimaryKey;
	}

	public ContactStatusType getContactStatusTypeCode() {
		return contactStatusTypeCode;
	}

	public void setContactStatusTypeCode(ContactStatusType contactStatusTypeCode) {
		this.contactStatusTypeCode = contactStatusTypeCode;
	}

}
