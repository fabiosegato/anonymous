package br.com.spring.anonymous.controller.dto;
import java.sql.Timestamp;

public class ScheduleDto {
	
	private Integer scheduleId;

	private String taskGroup;

	private String scheduleType;	

	private String scheduleValue;
	
	private Timestamp validFrom;	

	private Timestamp validTo;	

	private String status;
	
	private String agent;
	
	private Timestamp lastSchedule;

	private String instance;
	
	private String criticalJob;
	
	private Integer numberAttempts;
	
	private Integer prmt1;
	
	private String statusExec;

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getTaskGroup() {
		return taskGroup;
	}

	public void setTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	public String getScheduleValue() {
		return scheduleValue;
	}

	public void setScheduleValue(String scheduleValue) {
		this.scheduleValue = scheduleValue;
	}

	public Timestamp getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Timestamp validFrom) {
		this.validFrom = validFrom;
	}

	public Timestamp getValidTo() {
		return validTo;
	}

	public void setValidTo(Timestamp validTo) {
		this.validTo = validTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public Timestamp getLastSchedule() {
		return lastSchedule;
	}

	public void setLastSchedule(Timestamp lastSchedule) {
		this.lastSchedule = lastSchedule;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public String getCriticalJob() {
		return criticalJob;
	}

	public void setCriticalJob(String criticalJob) {
		this.criticalJob = criticalJob;
	}

	public Integer getNumberAttempts() {
		return numberAttempts;
	}

	public void setNumberAttempts(Integer numberAttempts) {
		this.numberAttempts = numberAttempts;
	}

	public Integer getPrmt1() {
		return prmt1;
	}

	public void setPrmt1(Integer prmt1) {
		this.prmt1 = prmt1;
	}

	public String getStatusExec() {
		return statusExec;
	}

	public void setStatusExec(String statusExec) {
		this.statusExec = statusExec;
	}

	
}
