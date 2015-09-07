package org.impulsemail.ImpulseMailDB.entity;

import java.io.Serializable;

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
@Table(name="USR")
public class User extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USR_ID_SEQ_GEN")
	@SequenceGenerator(name="USR_ID_SEQ_GEN", sequenceName="USR_ID_SEQ")
	@Column(name="USR_ID")
	private Long userId;
	
	@Column(name="USR_LOGN_ID" , length=20, unique=true, nullable=false)
	private String userLoginId;
	
	@Column(name="PASSWORD" , length=20, nullable=false)
	private String password;
	
	@Column(name="USR_FST_NAM", length=40, nullable=false)
	private String userFirstName;
	
	@Column(name="USR_LST_NAM", length=40, nullable=false)
	private String userLastName;
	
	@Column(name="USR_STS_TYP_CDE", length=5, nullable=false)
	private String userStatus;
	
	@Column(name="USR_ADM_RLE", length=1, nullable=false)
	@Type(type="org.hibernate.type.YesNoType")
	private Boolean userAdminRole;

	@Column(name="USR_EMAIL" , length=100, unique=true, nullable=false)
	private String userEmail;
	
	@Column(name="USR_PIC", nullable=true)
	@Type(type="org.hibernate.type.MaterializedBlobType")
	private byte[] userPicture;

	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
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

	public Boolean getUserAdminRole() {
		return userAdminRole;
	}

	public void setUserAdminRole(Boolean userAdminRole) {
		this.userAdminRole = userAdminRole;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public byte[] getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(byte[] userPicture) {
		this.userPicture = userPicture;
	}	
	
}
