package br.com.spring.anonymous.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import br.com.spring.anonymous.entity.id.ExceptionId;

@Entity
@IdClass(ExceptionId.class)
@Table(name = "TB_EXCEPTION")
public class TbException {

	@Id
	@Column(name="EXC_TYPE")
	private String excType; //PROCESS
	
	@Id
	@Column(name="PROC_NAME")
	private String procName; //PROCESS
	
	@Id
	@Column(name="VALUE")
	private String value; //PROCESS
	
	@Column(name="DATA",columnDefinition = "TIMESTAMP")
	private LocalDateTime data;//DATE_REFERENCE	
	
	public TbException(String excType, String procName, String value, LocalDateTime data) {
		this.excType = excType;
		this.procName = procName;
		this.value = value;
		this.data = data;
	}
	
	public TbException() {}

	public String getExcType() {
		return excType;
	}

	public void setExcType(String excType) {
		this.excType = excType;
	}

	public String getProcName() {
		return procName;
	}

	public void setProcName(String procName) {
		this.procName = procName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
}
