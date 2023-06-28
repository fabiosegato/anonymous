package br.com.spring.anonymous.entity.id;

import java.io.Serializable;

public class ExecId implements Serializable{	
  
	private static final long serialVersionUID = 1L;
	
	private String rootPid;
	private String confId;
    
	public ExecId(String rootPid, String confId) {
		this.rootPid = rootPid;
		this.confId = confId;
	}
	
	public ExecId() {}

	public String getRootPid() {
		return rootPid;
	}

	public void setRootPid(String rootPid) {
		this.rootPid = rootPid;
	}

	public String getConfId() {
		return confId;
	}

	public void setConfId(String confId) {
		this.confId = confId;
	}

	
	

}