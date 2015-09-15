package org.impulsemail.ImpulseMailDB.types;

public enum ContactStatusType {

	ACTIV("ACTIV","Active"),
	DEL("DEL","Deleted");
	
	private String contactStatusTypeCode;
	private String ContactStatusDescription;
	
	private ContactStatusType(String contactStatusTypeCode,String ContactStatusDescription) {
		this.contactStatusTypeCode=contactStatusTypeCode;
		this.ContactStatusDescription=ContactStatusDescription;
	}
	

	public String getContactStatusTypeCode() {
		return contactStatusTypeCode;
	}

	public void setContactStatusTypeCode(String contactStatusTypeCode) {
		this.contactStatusTypeCode = contactStatusTypeCode;
	}

	public String getContactStatusDescription() {
		return ContactStatusDescription;
	}

	public void setContactStatusDescription(String contactStatusDescription) {
		ContactStatusDescription = contactStatusDescription;
	}
	
}
