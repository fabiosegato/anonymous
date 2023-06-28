package br.com.spring.anonymous.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CTR_AJ_CONF")
public class Conf {
	
	@Id
	@Column(name = "CONF_ID")
	private String confId;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "DSC")
	private String desc;
	
	@Column(name = "COMMAND")
	@Lob
	private String command;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "CONF_ID",updatable=false,insertable=false)
	private List<Settings> settings;
	
	public String getConfId() {
		return this.confId;
	}

	public void setConfId(String confId) {
		this.confId = confId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCommand() {
		
		return  this.command;

	}

	public void setCommand(String command) {
		this.command = command;
	}

	public List<Settings> getSettings() {
		return this.settings;
	}

	public void setSettings(List<Settings> settings) {
		this.settings = settings;
	}

}
