package org.impulsemail.ImpulseMailDB.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	@Column(name="CRET_DTM" , nullable=false)
	private Timestamp cretDtm;
	
	@Column(name="LST_UPDT_DTM" , nullable=true)
	private Timestamp lstUpdtDtm;

	
	public Timestamp getCretDtm() {
		return cretDtm;
	}

	public void setCretDtm(Timestamp cretDtm) {
		this.cretDtm = cretDtm;
	}

	public Timestamp getLstUpdtDtm() {
		return lstUpdtDtm;
	}

	public void setLstUpdtDtm(Timestamp lstUpdtDtm) {
		this.lstUpdtDtm = lstUpdtDtm;
	}
	
}
