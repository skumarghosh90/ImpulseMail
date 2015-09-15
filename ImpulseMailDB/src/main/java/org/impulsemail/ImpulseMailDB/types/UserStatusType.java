package org.impulsemail.ImpulseMailDB.types;

public enum UserStatusType {
	ACTIV("ACTIV","Active"),
	SUSP("SUSP","Suspended"),
	DEL("DEL","Deleted");
	
	
	private String userStatusTypeCode;
	private String userStatusDescription;
	
	
	private UserStatusType(String userStatusTypCode,String userStatusDescription) {
		this.userStatusTypeCode=userStatusTypCode;
		this.userStatusDescription=userStatusDescription;
	}


	public String getUserStatusTypeCode() {
		return userStatusTypeCode;
	}


	public void setUserStatusTypeCode(String userStatusTypeCode) {
		this.userStatusTypeCode = userStatusTypeCode;
	}


	public String getUserStatusDescription() {
		return userStatusDescription;
	}


	public void setUserStatusDescription(String userStatusDescription) {
		this.userStatusDescription = userStatusDescription;
	}
	
}
