package br.com.spring.anonymous.entity.id;

import java.io.Serializable;

public class ExceptionId implements Serializable{	
  
	private static final long serialVersionUID = 1L;
	
	private String excType; 
	private String procName; 
	private String value;	
	
	public ExceptionId(String excType, String procName, String value) {
		this.excType = excType;
		this.procName = procName;
		this.value = value;
	}
	
	public ExceptionId() {}
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	

	

}