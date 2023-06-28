package br.com.spring.anonymous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {

	@Query(value="select t.SCHEDULE_ID,t.TASK_GROUP,t.SCHEDULE_TYPE,t.SCHEDULE_VALUE,t.VALID_FROM"
			+ ",t.VALID_TO,t.STATUS,AGENT,t.LAST_SCHEDULE,t.INSTANCE,t.CRITICAL_JOB,t.NUMBER_ATTEMPTS,t.PRMT_1 "
			+ "from CTR_AJ_SCHEDULE t "
			+ "where (:taskGroup IS NULL or t.TASK_GROUP like %:taskGroup%) "
			+ "and (:instance IS NULL or t.INSTANCE like %:instance%) "
			+ "and rownum <= 20",nativeQuery = true)
	List<Schedule> carregaSchedule(String taskGroup,String instance);
	

}

