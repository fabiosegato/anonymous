package br.com.spring.anonymous.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "METADATA_ANONYMOUS")
public class MetaDataAnonymous {
	
	@Id
	@Column(name = "ID")
	private Long Id;
	
	@Column(name = "TASK_TYPE")
	private String taskType;
	
	@Column(name = "SETTING_NAME")
	private String settingName;
	
	@Column(name = "VALUE")
	private String value;
	
	@Column(name = "REQUIRED")
	private char required;
	
	@Column(name = "FORM_TYPE")
	private String formType;
	
	@Column(name = "SELECT_VALUES")
	private String selectValues;
	
	@Column(name = "LABEL")
	private String label;

	@Column(name = "TIP")
	private String tip;
	
	public Long getId() {
		return this.Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getTaskType() {
		return this.taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getSettingName() {
		return this.settingName;
	}

	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}

	public char getRequired() {
		return this.required;
	}

	public void setRequired(char required) {
		this.required = required;
	}

	public String getFormType() {
		return this.formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSelectValues() {
		return this.selectValues;
	}

	public void setSelectValues(String selectValues) {
		this.selectValues = selectValues;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTip() {
		return this.tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	

}
