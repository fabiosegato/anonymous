package br.com.spring.anonymous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.spring.anonymous.entity.Exec;

@Repository
public interface ExecRepository extends JpaRepository<Exec, String> {

	
	@Query(value="select rownum, T.STATUS,T.SCHEDULE_START,T.JOB_START,T.ROOT_PID,T.COUNT_TRY,T.AGENT,T.TASK_GROUP,T.PID,T.CONF_ID,T.TASK_ORDER "
			+ ",T.SUB_TASK_GROUP,T.SUB_TASK_GROUP_LEVEL,T.LOOP_NUM,T.INSTANCE,T.CRITICAL_JOB,T.LINUX_RUNTIME_ID,T.LINUX_LOG "
			+ "from CTR_AJ_EXEC t "
			+ "WHERE "
			+ "(:taskName IS NULL or T.TASK_GROUP like %:taskName%) "
			+ "and (T.STATUS = :status) "
			+ "and (:instance IS NULL or T.INSTANCE like %:instance%) "
			+ "AND rownum <=20 "
			+ "ORDER BY t.schedule_start desc nulls last,T.JOB_START desc nulls last" ,nativeQuery = true)	
	List<Exec> carregaExec(String taskName,Integer status,String instance);
	
	@Query(value="select rownum,T.STATUS,T.SCHEDULE_START,T.JOB_START,T.ROOT_PID,T.COUNT_TRY,T.AGENT,T.TASK_GROUP,T.PID,T.CONF_ID,T.TASK_ORDER "
			+ ",T.SUB_TASK_GROUP,T.SUB_TASK_GROUP_LEVEL,T.LOOP_NUM,T.INSTANCE,T.CRITICAL_JOB,T.LINUX_RUNTIME_ID,T.LINUX_LOG "
			+ "from CTR_AJ_DONE t "
			+ "WHERE "
			+ "(:taskName IS NULL or T.TASK_GROUP like %:taskName%) "
			+ "and (T.STATUS = :status) "
			+ "and (:instance IS NULL or T.INSTANCE like %:instance%) "
			+ "AND rownum <=20 "
			+ "ORDER BY t.schedule_start desc nulls last,T.JOB_START desc nulls last" ,nativeQuery = true)	
	List<Exec> carregaDone(String taskName,Integer status,String instance);
	

}

