package br.com.spring.anonymous.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import br.com.spring.anonymous.entity.id.LogsId;

@Entity
@IdClass(LogsId.class)
@Table(name = "CTR_TALEND_LOGS")
public class Logs {	
	
	public Logs(LocalDateTime moment, String rootPid, String pid, String fatherPid, String job, String origin,
			String message, String ajTaskGroup, String ajConfId, String ajInstance, String ajEntityName) {
		this.moment = moment;
		this.rootPid = rootPid;
		this.pid = pid;
		this.fatherPid = fatherPid;
		this.job = job;
		this.origin = origin;
		this.message = message;
		this.ajTaskGroup = ajTaskGroup;
		this.ajConfId = ajConfId;
		this.ajInstance = ajInstance;
		this.ajEntityName = ajEntityName;
	}

	public Logs() {}
	
	@Column(name = "MOMENT",columnDefinition = "TIMESTAMP")
	private LocalDateTime moment;
	
	@Id
	@Column(name = "ROOT_PID")
	private String rootPid;
	
	@Id
	@Column(name = "PID")
	private String pid;
	
	@Column(name = "FATHER_PID")
	private String fatherPid;
	
	@Column(name = "JOB")
	private String job;
	
	@Column(name = "ORIGIN")
	private String origin;
	
	@Column(name = "MESSAGE")
	private String message;
	
	@Column(name = "AJ_TASK_GROUP")
	private String ajTaskGroup;
	
	@Column(name = "AJ_CONF_ID")
	private String ajConfId;
	
	@Column(name = "AJ_INSTANCE")
	private String ajInstance;
	
	@Column(name = "AJ_ENTITY_NAME")
	private String ajEntityName;

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public String getRootPid() {
		return rootPid;
	}

	public void setRootPid(String rootPid) {
		this.rootPid = rootPid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getFatherPid() {
		return fatherPid;
	}

	public void setFatherPid(String fatherPid) {
		this.fatherPid = fatherPid;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAjTaskGroup() {
		return ajTaskGroup;
	}

	public void setAjTaskGroup(String ajTaskGroup) {
		this.ajTaskGroup = ajTaskGroup;
	}

	public String getAjConfId() {
		return ajConfId;
	}

	public void setAjConfId(String ajConfId) {
		this.ajConfId = ajConfId;
	}

	public String getAjInstance() {
		return ajInstance;
	}

	public void setAjInstance(String ajInstance) {
		this.ajInstance = ajInstance;
	}

	public String getAjEntityName() {
		return ajEntityName;
	}

	public void setAjEntityName(String ajEntityName) {
		this.ajEntityName = ajEntityName;
	}	
	
	
	
	
}
