package br.com.spring.anonymous.entity.id;

import java.io.Serializable;

public class LogsId implements Serializable{	
  
	private static final long serialVersionUID = 1L;
	
	private String rootPid;
	private String pid;
    
    public LogsId() {};
    
	public LogsId(String rootPid, String pid) {
		super();
		this.rootPid = rootPid;
		this.pid = pid;
		}

	public String getRootPid() {
		return rootPid;
	}

	public void setRootPid(String rootPid) {
		this.rootPid = rootPid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
}