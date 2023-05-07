package br.com.spring.anonymous.entity.id;

import java.io.Serializable;

public class ExecId implements Serializable{	
  
	private static final long serialVersionUID = 1L;

	private Integer scheduleId; 
    private String taskGroup;
    private String rootPid;
    
    public ExecId() {
    }
 
    public ExecId(Integer scheduleId, String taskGroup, String rootPid) {
        this.setScheduleId(scheduleId);
        this.setTaskGroup(taskGroup);
        this.setRootPid(rootPid);
    }



	public Integer getScheduleId() {
		return this.scheduleId;
	}

	public void setTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
	}

	public String getTaskGroup() {
		return this.taskGroup;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getRootPid() {
		return rootPid;
	}

	public void setRootPid(String rootPid) {
		this.rootPid = rootPid;
	}

}
