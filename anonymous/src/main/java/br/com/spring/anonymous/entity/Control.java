package br.com.spring.anonymous.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import br.com.spring.anonymous.entity.id.ControlId;

@Entity
@IdClass(ControlId.class)
@Table(name = "TAB_CONTROL")
public class Control {

	@Id
	@Column(name="PROCESS")
	private String process; //PROCESS
	
	@Id
	@Column(name="DATE_REFERENCE",columnDefinition = "TIMESTAMP")
	private LocalDateTime dateReference;//DATE_REFERENCE
	
	@Id
	@Column(name="SEQ_ID")
	private Integer seqId;//SEQ_ID	

	@Id
	@Column(name="INSTITUTION_NUMBER")
	private String institutionNumber;//INSTITUTION_NUMBER*/
	
	@Column(name="DAYS_QTY")
	private Integer daysQty;
	
	@Column(name="DATE_MAX")
	private LocalDateTime dateMax;

	@Column(name="SCHEDULE_TYPE")
	private String scheduleType;
	
	@Column(name="BUSINESSDAY")
	private String businessday;
	
	@Column(name="PRMT_1")
	private String prmt1;

	public Control(String process, LocalDateTime dateReference, Integer seqId, String institutionNumber,
			Integer daysQtd, LocalDateTime dateMax, String scheduleType, String businessday, String prmt1) {
		this.process = process;
		this.dateReference = dateReference;
		this.seqId = seqId;
		this.institutionNumber = institutionNumber;
		this.daysQty = daysQtd;
		this.dateMax = LocalDateTime.of(2025, 1, 1, 0, 0);
		this.scheduleType = scheduleType;
		this.businessday = businessday;
		this.prmt1 = prmt1;
	}
	
	public Control() {
		this.dateMax = LocalDateTime.of(2025, 1, 1, 0, 0);
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

	public Integer getDaysQtd() {
		return daysQty;
	}

	public void setDaysQtd(Integer daysQtd) {
		this.daysQty = daysQtd;
	}

	public LocalDateTime getDateMax() {
		return dateMax;
	}

	public void setDateMax(LocalDateTime dateMax) {
		this.dateMax = dateMax;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	public String getBusinessday() {
		return businessday;
	}

	public void setBusinessday(String businessday) {
		this.businessday = businessday;
	}

	public String getPrmt1() {
		return prmt1;
	}

	public void setPrmt1(String prmt1) {
		this.prmt1 = prmt1;
	}
	
	
	
}
