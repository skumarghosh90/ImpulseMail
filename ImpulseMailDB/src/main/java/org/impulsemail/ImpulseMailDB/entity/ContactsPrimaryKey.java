package org.impulsemail.ImpulseMailDB.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ContactsPrimaryKey {

	@ManyToOne(optional=false)
	@JoinColumn(name="USR_ID")
	private User user;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="CNTACT_ID")
	private User contact;

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getContact() {
		return contact;
	}

	public void setContact(User contact) {
		this.contact = contact;
	}
	
}
