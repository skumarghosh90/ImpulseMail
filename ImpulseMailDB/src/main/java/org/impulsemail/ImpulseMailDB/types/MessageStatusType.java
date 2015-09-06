package org.impulsemail.ImpulseMailDB.types;

public enum MessageStatusType {
	
	DRAFT("DRAFT","Draft"),
	SENT("SENT","Sent"),
	DEL("DEL","Deleted"),
	RCVD("RCVD","Received"),
	NRCVD("NRCVD","Not Received Yet"),
	DFLD("DFLD", "Delivery Failed");
	
	public String messageStatusTypCode;
	public String messageStatusDescription;
	
	
	private MessageStatusType(String messageStatusTypCode,String messageStatusDescription) {
		this.messageStatusTypCode=messageStatusTypCode;
		this.messageStatusDescription=messageStatusDescription;
	}

	public String getMessageStatusTypCode() {
		return messageStatusTypCode;
	}

	public void setMessageStatusTypCode(String messageStatusTypCode) {
		this.messageStatusTypCode = messageStatusTypCode;
	}

	public String getMessageStatusDescription() {
		return messageStatusDescription;
	}

	public void setMessageStatusDescription(String messageStatusDescription) {
		this.messageStatusDescription = messageStatusDescription;
	}
		
}
