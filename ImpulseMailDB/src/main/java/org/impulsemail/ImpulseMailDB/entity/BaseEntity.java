package org.impulsemail.ImpulseMailDB.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable {

	@Column(name="CRET_DTM" , nullable=false)
	private Date cretDtm;
	
	@Column(name="LST_UPDT_DTM" , nullable=true)
	private Date lstUpdtDtm;
	
	public Date getCretDtm() {
		return cretDtm;
	}

	public void setCretDtm(Date cretDtm) {
		this.cretDtm = cretDtm;
	}

	public Date getLstUpdtDtm() {
		return lstUpdtDtm;
	}

	public void setLstUpdtDtm(Date lstUpdtDtm) {
		this.lstUpdtDtm = lstUpdtDtm;
	}

}
