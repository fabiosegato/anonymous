package br.com.spring.anonymous.entity.id;

import java.io.Serializable;

public class SettingsId implements Serializable{
  
	private static final long serialVersionUID = 1L;

	private String settingName; 
    private String confId;
    
    public SettingsId() {
    }
 
    public SettingsId(String settingName, String confId) {
        this.setSettingName(settingName);
        this.setConfId(confId);
    }

	public String getSettingName() {
		return settingName;
	}

	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}

	public String getConfId() {
		return confId;
	}

	public void setConfId(String confId) {
		this.confId = confId;
	}

}
