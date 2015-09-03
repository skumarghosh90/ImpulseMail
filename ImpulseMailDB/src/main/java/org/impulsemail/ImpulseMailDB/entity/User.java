package org.impulsemail.ImpulseMailDB.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="MAIL_USER")
public class User extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAIL_USER_ID_SEQ_GEN")
	@SequenceGenerator(name="MAIL_USER_ID_SEQ_GEN", sequenceName="MAIL_USER_ID_SEQ_GEN")
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="USERNAME" , length=20, unique=true, nullable=false)
	private String username;
	
	@Column(name="PASSWORD" , length=20, nullable=false)
	private String password;
	
	@Column(name="USER_FST_NAM", length=40, nullable=false)
	private String userFirstName;
	
	@Column(name="USER_LST_NAM", length=40, nullable=false)
	private String userLastName;
	
	@Column(name="USER_STS", length=5, nullable=false)
	private String userStatus;
	
	@Column(name="USER_ADM_RLE", length=1, nullable=false)
	private String userAdminRole;

	@Column(name="USER_EMAIL" , length=100, unique=true, nullable=false)
	private String userEmail;

	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserAdminRole() {
		return userAdminRole;
	}

	public void setUserAdminRole(String userAdminRole) {
		this.userAdminRole = userAdminRole;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}	
	
}
