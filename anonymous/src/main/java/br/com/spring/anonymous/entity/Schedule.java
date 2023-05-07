package br.com.spring.anonymous.entity;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import br.com.spring.anonymous.entity.id.ScheduleId;


@Entity
@IdClass(ScheduleId.class)
@Table(name = "CTR_AJ_SCHEDULE")
public class Schedule {

	@Id
	@Column(name="SCHEDULE_ID")
	private Integer scheduleId;
	
	@Id
	@Column(name="TASK_GROUP")
	private String taskGroup;
	
	@Column(name = "SCHEDULE_TYPE")
	private String scheduleType;
	
	@Column(name = "SCHEDULE_VALUE")
	private String scheduleValue;
	
	@Column(name = "VALID_FROM")
	private Timestamp validFrom;
	
	@Column(name = "VALID_TO")
	private Timestamp validTo;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "AGENT")
	private String agent;
	
	@Column(name = "LAST_SCHEDULE")
	private Timestamp lastSchedule;

	@Column(name = "INSTANCE")
	private String instance;
	
	@Column(name = "CRITICAL_JOB")
	private String criticalJob;
	
	@Column(name = "NUMBER_ATTEMPTS")
	private Integer numberAttempts;
	
	@Column(name = "PRMT_1")
	private Integer prmt1;

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

	
}
