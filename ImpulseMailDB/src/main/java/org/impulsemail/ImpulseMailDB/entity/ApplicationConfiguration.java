package org.impulsemail.ImpulseMailDB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="APP_CNFGN")
public class ApplicationConfiguration extends BaseEntity {
	
	@Id
	@Column(name="APP_CNFGN_NAM", length=30)
	private String applicationConfigurationName;
	
	@Column(name="APP_CNFGN_VAL", length=2000, nullable=false)
	private String applicationConfigurationValue;
	

	public String getApplicationConfigurationName() {
		return applicationConfigurationName;
	}

	public void setApplicationConfigurationName(String applicationConfigurationName) {
		this.applicationConfigurationName = applicationConfigurationName;
	}

	public String getApplicationConfigurationValue() {
		return applicationConfigurationValue;
	}

	public void setApplicationConfigurationValue(String applicationConfigurationValue) {
		this.applicationConfigurationValue = applicationConfigurationValue;
	}

}
