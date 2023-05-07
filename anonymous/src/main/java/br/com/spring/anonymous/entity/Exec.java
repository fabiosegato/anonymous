package br.com.spring.anonymous.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import br.com.spring.anonymous.entity.id.ExecId;

@Entity
@IdClass(ExecId.class)
@Table(name = "CTR_AJ_EXEC")
public class Exec {

	@Id
	@Column(name="SCHEDULE_ID")
	private int scheduleId;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name = "SCHEDULE_START")
	private Timestamp scheduleStart;
	
	@Column(name = "JOB_START")
	private Timestamp jobStart;
	
	@Id
	@Column(name = "ROOT_PID")
	private String rootPid;
	
	@Column(name = "COUNT_TRY")
	private Integer countTry;
	
	@Column(name = "AGENT")
	private String agent;
	
	@Id
	@Column(name = "TASK_GROUP")
	private String taskGroup;
	
	@Column(name = "PID")
	private String pid;
	
	@Column(name = "CONF_ID")
	private String confId;
	
	@Column(name = "TASK_ORDER")
	private String taskOrder;
	
	@Column(name = "SUB_TASK_GROUP")
	private String subTaskGroup;
	
	@Column(name = "SUB_TASK_GROUP_LEVEL")
	private String subTaskGroupLevel;
	
	@Column(name = "LOOP_NUM")
	private Integer loopNum;
	
	@Column(name = "INSTANCE")
	private String instance;
	
	@Column(name = "CRITICAL_JOB")
	private String criticalJob;
	
	@Column(name = "LINUX_RUNTIME_ID")
	private String linuxRunTimeId;
	
	@Column(name = "LINUX_LOG")
	private String linuxLog;

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getScheduleStart() {
		return scheduleStart;
	}

	public void setScheduleStart(Timestamp scheduleStart) {
		this.scheduleStart = scheduleStart;
	}

	public Timestamp getJobStart() {
		return jobStart;
	}

	public void setJobStart(Timestamp jobStart) {
		this.jobStart = jobStart;
	}

	public String getRootPid() {
		return rootPid;
	}

	public void setRootPid(String rootPid) {
		this.rootPid = rootPid;
	}

	public Integer getCountTry() {
		return countTry;
	}

	public void setCountTry(Integer countTry) {
		this.countTry = countTry;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getTaskGroup() {
		return taskGroup;
	}

	public void setTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getConfId() {
		return confId;
	}

	public void setConfId(String confId) {
		this.confId = confId;
	}

	public String getTaskOrder() {
		return taskOrder;
	}

	public void setTaskOrder(String taskOrder) {
		this.taskOrder = taskOrder;
	}

	public String getSubTaskGroup() {
		return subTaskGroup;
	}

	public void setSubTaskGroup(String subTaskGroup) {
		this.subTaskGroup = subTaskGroup;
	}

	public String getSubTaskGroupLevel() {
		return subTaskGroupLevel;
	}

	public void setSubTaskGroupLevel(String subTaskGroupLevel) {
		this.subTaskGroupLevel = subTaskGroupLevel;
	}

	public Integer getLoopNum() {
		return loopNum;
	}

	public void setLoopNum(Integer loopNum) {
		this.loopNum = loopNum;
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

	public String getLinuxRunTimeId() {
		return linuxRunTimeId;
	}

	public void setLinuxRunTimeId(String linuxRunTimeId) {
		this.linuxRunTimeId = linuxRunTimeId;
	}

	public String getLinuxLog() {
		return linuxLog;
	}

	public void setLinuxLog(String linuxLog) {
		this.linuxLog = linuxLog;
	}

	
}
