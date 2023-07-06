package br.com.spring.anonymous.controller.dto;

import java.time.LocalDateTime;

public interface IScheduleDto {		
	
	 Integer getScheduleId();

	 String getTaskGroup();
	 
	 String getScheduleType();
		
	 String getScheduleValue();
		
 	 LocalDateTime getValidFrom();
		
 	 LocalDateTime getValidTo();
		
 	 String getStatus();
		
 	 String getAgent();
		
 	 LocalDateTime getLastSchedule();

 	 String getInstance();		

 	 String getCriticalJob();		

 	 Integer getNumberAttempts();		

 	 Integer getPrmt1();
	 
	 String getExecuting();
	 
	
}
