package br.com.spring.anonymous.entity.id;

import java.io.Serializable;

public class JobId implements Serializable{	
  
	private static final long serialVersionUID = 1L;
	
	private String process;
	private String jobName;
    
	public JobId(String process, String jobName, String institutionNumber) {
		this.process = process;
		this.jobName = jobName;
	}
	
	public JobId() {}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	

}