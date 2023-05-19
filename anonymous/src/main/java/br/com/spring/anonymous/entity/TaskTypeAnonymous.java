package br.com.spring.anonymous.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TASK_TYPES_ANONYMOUS")
public class TaskTypeAnonymous {
	
	@Id
	@Column(name = "ID")
	private Long Id;
	
	@Column(name = "TASK_TYPE")
	private String taskType;
	
	@Column(name = "LABEL")
	private String label;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}	

}
