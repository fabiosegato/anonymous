package br.com.spring.anonymous.entity.id;

import java.io.Serializable;

public class ScheduleId implements Serializable{	
  
	private static final long serialVersionUID = 1L;

	private Integer scheduleId; 
    private String taskGroup;
    
    public ScheduleId() {
    }
 
    public ScheduleId(Integer scheduleId, String taskGroup) {
        this.setScheduleId(scheduleId);
        this.setTaskGroup(taskGroup);
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

}
