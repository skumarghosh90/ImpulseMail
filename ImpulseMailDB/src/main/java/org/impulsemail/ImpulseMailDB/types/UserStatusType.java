package org.impulsemail.ImpulseMailDB.types;

public enum UserStatusType {
	ACTIV("ACTIV","Active"),
	SUSP("SUSP","Suspended"),
	DEL("DEL","Deleted");
	
	
	public String userStatusTypCode;
	public String userStatusDescription;
	
	
	private UserStatusType(String userStatusTypCode,String userStatusDescription) {
		this.userStatusTypCode=userStatusTypCode;
		this.userStatusDescription=userStatusDescription;
	}
}
