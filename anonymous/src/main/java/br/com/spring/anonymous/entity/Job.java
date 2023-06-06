package br.com.spring.anonymous.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import br.com.spring.anonymous.entity.id.JobId;

@Entity
@IdClass(JobId.class)
@Table(name = "TAB_JOBS")
public class Job {

	@Id
	@Column(name="PROCESS")
	private String process; 
	
	@Id
	@Column(name="JOB_NAME")
	private String jobName; 
	
	@Column(name="INSTITUTION_NUMBER")
	private String institutionNumber;
	
	@Column(name="JOB_GROUP")
	private String jobGroup;	
	
	@Column(name="ACTIVE")
	private String active;
	
	@Column(name="EXECUTION_GROUP")
	private String executionGroup; 
	
	@Column(name="EXECUTION_ORDER")
	private Integer executionOrder;
		
	@Column(name="OUTPUT_TYPE")
	private String outPutType;

	public Job(String process, String jobName, String institutionNumber, String jobGroup, String active,
			LocalDateTime dateReference, String executionGroup, Integer executionOrder, String outPutType) {
		this.process = process;
		this.jobName = jobName;
		this.institutionNumber = institutionNumber;
		this.jobGroup = jobGroup;
		this.active = active;
		this.executionGroup = executionGroup;
		this.executionOrder = executionOrder;
		this.outPutType = outPutType;
	}
	
	public Job() {}

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

	public String getinstitutionNumber() {
		return institutionNumber;
	}

	public void setInstitutionName(String institutionNumber) {
		this.institutionNumber = institutionNumber;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}


	public String getExecutionGroup() {
		return executionGroup;
	}

	public void setExecutionGroup(String executionGroup) {
		this.executionGroup = executionGroup;
	}

	public Integer getExecutionOrder() {
		return executionOrder;
	}

	public void setExecutionOrder(Integer executionOrder) {
		this.executionOrder = executionOrder;
	}

	public String getOutPutType() {
		return outPutType;
	}

	public void setOutPutType(String outPutType) {
		this.outPutType = outPutType;
	} 
		
	
}
