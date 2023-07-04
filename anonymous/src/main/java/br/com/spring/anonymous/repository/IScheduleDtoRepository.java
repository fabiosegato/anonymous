

package br.com.spring.anonymous.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.controller.dto.IScheduleDto;
import br.com.spring.anonymous.entity.Schedule;

@Repository
public interface IScheduleDtoRepository extends JpaRepository<Schedule, Long> {

    @Query(value = "SELECT DISTINCT "
    		+ "A.SCHEDULE_ID as scheduleId, A.TASK_GROUP as taskGroup "
    		+ ",A.SCHEDULE_TYPE as scheuleType, A.SCHEDULE_VALUE as scheduleValue, A.VALID_FROM as validFrom "
    		+ ",A.VALID_TO as validTo, A.STATUS as status, A.AGENT as agent, A.LAST_SCHEDULE as lastSchedule "
    		+ ",A.INSTANCE as instance, A.CRITICAL_JOB as criticalJob, A.NUMBER_ATTEMPTS as numberAttempts "
    		+ ",A.PRMT_1 as prmt1, CASE WHEN C.ROOT_PID IS NOT NULL THEN 'Y' ELSE 'N' END AS executing " +
        "FROM CTR_AJ_SCHEDULE a " +
        "LEFT JOIN CTR_AJ_EXEC b ON b.TASK_GROUP = a.TASK_GROUP AND REPLACE(b.instance,'AJ_INSTANCE==','') = a.INSTANCE AND b.STATUS = 2 " +
        "LEFT JOIN CTR_AJ_CHECK_EXEC c ON c.ROOT_PID = b.ROOT_PID " +
        "WHERE (:taskName is null or a.TASK_GROUP LIKE %:taskName%) "
        + "AND (:instance is null or a.INSTANCE LIKE %:instance%)",
        nativeQuery = true)
    List<IScheduleDto> getSchedules(String taskName,String instance);
}