package org.impulsemail.ImpulseMailDB.types;

public enum MessageStatusType {
	
	DRAFT("DRAFT","Draft"),
	SENT("SENT","Sent"),
	DEL("DEL","Deleted"),
	RCVD("RCVD","Received"),
	NRCVD("NRCVD","Not Received Yet"),
	READ("READ","Read"),
	DFLD("DFLD", "Delivery Failed");
	
	private String messageStatusTypeCode;
	private String messageStatusDescription;
	
	
	private MessageStatusType(String messageStatusTypeCode,String messageStatusDescription) {
		this.messageStatusTypeCode=messageStatusTypeCode;
		this.messageStatusDescription=messageStatusDescription;
	}

	public String getMessageStatusTypeCode() {
		return messageStatusTypeCode;
	}

	public void setMessageStatusTypeCode(String messageStatusTypCode) {
		this.messageStatusTypeCode = messageStatusTypCode;
	}

	public String getMessageStatusDescription() {
		return messageStatusDescription;
	}

	public void setMessageStatusDescription(String messageStatusDescription) {
		this.messageStatusDescription = messageStatusDescription;
	}
		
}
