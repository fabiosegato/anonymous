package br.com.spring.anonymous.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import br.com.spring.anonymous.entity.id.SettingsId;

@Entity
@IdClass(SettingsId.class)
@Table(name = "CTR_AJ_SETTINGS")
public class Settings {

	@Id
	@Column(name="CONF_ID")
	private String confId;
	
	@Id
	@Column(name="KEY")
	private String settingName;
	
	@Column(name = "VALUE")
	private String value;


	public String getConfId() {
		return this.confId;
	}

	public void setConfId(String confId) {
		this.confId = confId;
	}

	public String getSettingName() {
		return this.settingName;
	}

	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
