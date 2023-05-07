package br.com.spring.anonymous.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.anonymous.controller.dto.ScheduleDto;
import br.com.spring.anonymous.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {

	
	@Query("select t,e.status as statusExec from Schedule t left join Exec e on t.scheduleId = e.scheduleId and t.taskGroup = e.taskGroup"
			+ " where t.taskGroup like %:taskName%")
	Collection<ScheduleDto> carregaSchedule(String taskName);
	
	@Modifying
	@Transactional
	@Query("update Schedule s set s.lastSchedule = null where s.scheduleId = :p_scheduleId and s.taskGroup = :p_taskGroup")
	void executaJob(@Param("p_scheduleId") Integer scheduleId,@Param("p_taskGroup") String taskGroup);
	

}

