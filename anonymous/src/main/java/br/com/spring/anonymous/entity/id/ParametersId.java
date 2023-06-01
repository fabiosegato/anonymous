package br.com.spring.anonymous.entity.id;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class ParametersId implements Serializable{	
  
	private static final long serialVersionUID = 1L;
	
	private String process;
	private String jobName; 
    private Integer seqId;
    private LocalDateTime dateReference;
    private String institutionNumber;
    private String outputType;

    public ParametersId() {    	
    }
    
	
	
	public ParametersId(String process, String jobName, Integer seqId, LocalDateTime dateReference, String institutionNumber,
			String outputType) {
		this.process = process;
		this.jobName = jobName;
		this.seqId = seqId;
		this.dateReference = dateReference;
		this.institutionNumber = institutionNumber;
		this.outputType = outputType;
	}



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
	
	public Integer getSeqId() {
		return seqId;
	}
	public void setSeqId(Integer seqId) {
		this.seqId = seqId;
	}
	
	public LocalDateTime getDateReference() {
		return dateReference;
	}
	public void setDateReference(LocalDateTime dateReference) {
		this.dateReference = dateReference;
	}
	
	public String getInstitutionNumber() {
		return institutionNumber;
	}
	public void setInstitutionNumber(String institutionNumber) {
		this.institutionNumber = institutionNumber;
	}
	public String getOutputType() {
		return outputType;
	}
	public void setOutputType(String outputType) {
		this.outputType = outputType;
	}	

}
