package br.com.spring.anonymous.controller.dto;

public class ProcedureResultDto {
	
	private String errorCode;
	private String errorMsg;	
	
	
	public ProcedureResultDto(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public ProcedureResultDto() {
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
	
	

}
