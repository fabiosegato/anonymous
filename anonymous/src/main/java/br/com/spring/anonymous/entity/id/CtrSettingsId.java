package br.com.spring.anonymous.entity.id;

import java.io.Serializable;

public class CtrSettingsId implements Serializable{	
  
	private static final long serialVersionUID = 1L;
	
	private String process; 
	private String key;
	private String groupValue;
    
    public CtrSettingsId() {}

	public CtrSettingsId(String process, String key, String groupValue) {
		super();
		this.process = process;
		this.key = key;
		this.groupValue = groupValue;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getGroupValue() {
		return groupValue;
	}

	public void setGroupValue(String groupValue) {
		this.groupValue = groupValue;
	};
    
		
	



}