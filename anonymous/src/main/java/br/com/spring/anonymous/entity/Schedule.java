package br.com.spring.anonymous.entity;
import java.time.LocalDateTime;
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

	
	
	public Schedule(Integer scheduleId, String taskGroup, String scheduleType, String scheduleValue,
			LocalDateTime validFrom, LocalDateTime validTo, String status, String agent, LocalDateTime lastSchedule,
			String instance, String criticalJob, Integer numberAttempts, Integer prmt1) {
		this.scheduleId = scheduleId;
		this.taskGroup = taskGroup;
		this.scheduleType = scheduleType;
		this.scheduleValue = scheduleValue;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.status = status;
		this.agent = agent;
		this.lastSchedule = lastSchedule;
		this.instance = instance;
		this.criticalJob = criticalJob;
		this.numberAttempts = numberAttempts;
		this.prmt1 = prmt1;
	}
	
	public Schedule() {}

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
	
	@Column(name = "VALID_FROM",columnDefinition = "TIMESTAMP")
	private LocalDateTime validFrom;
	
	@Column(name = "VALID_TO",columnDefinition = "TIMESTAMP")
	private LocalDateTime validTo;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "AGENT")
	private String agent;
	
	@Column(name = "LAST_SCHEDULE",columnDefinition = "TIMESTAMP")
	private LocalDateTime lastSchedule;

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

	public LocalDateTime getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(LocalDateTime validFrom) {
		this.validFrom = validFrom;
	}

	public LocalDateTime getValidTo() {
		return validTo;
	}

	public void setValidTo(LocalDateTime validTo) {
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

	public LocalDateTime getLastSchedule() {
		return lastSchedule;
	}

	public void setLastSchedule(LocalDateTime lastSchedule) {
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
