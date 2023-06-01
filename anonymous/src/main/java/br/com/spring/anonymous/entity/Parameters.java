package br.com.spring.anonymous.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import br.com.spring.anonymous.entity.id.ParametersId;

@Entity
@IdClass(ParametersId.class)
@Table(name = "TAB_PARAMETERS")
public class Parameters {

	@Id
	@Column(name="PROCESS")
	private String process; //PROCESS
	
	@Id
	@Column(name="JOB_NAME")
	private String jobName;//JOB_NAME
	
	@Id
	@Column(name="DATE_REFERENCE",columnDefinition = "TIMESTAMP")
	private LocalDateTime dateReference;//DATE_REFERENCE
	
	@Id
	@Column(name="SEQ_ID")
	private Integer seqId;//SEQ_ID
	
	@Column(name="FROM_PARAMETER",columnDefinition = "TIMESTAMP")
	private LocalDateTime  fromParameter;//FROM_PARAMETER
	
	@Column(name="TO_PARAMETER",columnDefinition = "TIMESTAMP")
	private LocalDateTime toParameter;//TO_PARAMETER
	
	@Column(name="STATUS")
	private String status;//STATUS
	
	@Column(name="DATE_START",columnDefinition = "TIMESTAMP")
	private LocalDateTime dateStart;//DATE_START
	
	@Column(name="DATE_END",columnDefinition = "TIMESTAMP")	
	private LocalDateTime dateEnd;//DATE_END
	
	@Column(name="DURATION")
	private Integer duration;//DURATION
	
	@Id
	@Column(name="OUTPUT_TYPE")
	private String outputType;//OUTPUT_TYPE
	
	@Id
	@Column(name="INSTITUTION_NUMBER")
	private String institutionNumber;//INSTITUTION_NUMBER*/
	
	

	public Parameters(String process, String jobName, LocalDateTime dateReference, Integer seqId, LocalDateTime fromParameter,
			LocalDateTime toParameter, String status, LocalDateTime dateStart, LocalDateTime dateEnd, Integer duration, String outputType,
			String institutionNumber) {
		this.process = process;
		this.jobName = jobName;
		this.dateReference = dateReference;
		this.seqId = seqId;
		this.fromParameter = fromParameter;
		this.toParameter = toParameter;
		this.status = status;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.duration = duration;
		this.outputType = outputType;
		this.institutionNumber = institutionNumber;
	}
	
	public Parameters(){}

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

	public LocalDateTime getFromParameter() {
		return fromParameter;
	}

	public void setFromParameter(LocalDateTime fromParameter) {
		this.fromParameter = fromParameter;
	}

	public LocalDateTime getToParameter() {
		return toParameter;
	}

	public void setToParameter(LocalDateTime toParameter) {
		this.toParameter = toParameter;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDateStart() {
		return dateStart;
	}

	public void setDateStart(LocalDateTime dateStart) {
		this.dateStart = dateStart;
	}

	public LocalDateTime getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDateTime dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getOutputType() {
		return outputType;
	}

	public void setOutputType(String outputType) {
		this.outputType = outputType;
	}

	public String getInstitutionNumber() {
		return institutionNumber;
	}

	public void setInstitutionNumber(String institutionNumber) {
		this.institutionNumber = institutionNumber;
	}
	

	
}
