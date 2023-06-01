package br.com.spring.anonymous.entity.id;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ControlId implements Serializable{	
  
	private static final long serialVersionUID = 1L;
	
	private String process;
    private LocalDateTime dateReference;
    private Integer seqId;
    private String institutionNumber;
    
    public ControlId() {};
    
	public ControlId(String process, LocalDateTime dateReference, Integer seqId, String institutionNumber) {
		super();
		this.process = process;
		this.dateReference = dateReference;
		this.seqId = seqId;
		this.institutionNumber = institutionNumber;
	}
	
	
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public LocalDateTime getDateReference() {
		return dateReference;
	}
	public void setDateReference(LocalDateTime dateReference) {
		this.dateReference = dateReference;
	}
	public Integer getSeqId() {
		return seqId;
	}
	public void setSeqId(Integer seqId) {
		this.seqId = seqId;
	}
	public String getInstitutionNumber() {
		return institutionNumber;
	}
	public void setInstitutionNumber(String institutionNumber) {
		this.institutionNumber = institutionNumber;
	}



}