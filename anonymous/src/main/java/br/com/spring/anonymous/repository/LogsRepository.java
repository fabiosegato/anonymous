package br.com.spring.anonymous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.entity.Logs;

@Repository
public interface LogsRepository extends JpaRepository<Logs, String> {

	@Query(value="select T.MOMENT,T.PID,T.ROOT_PID,T.FATHER_PID,T.JOB,T.ORIGIN,T.MESSAGE,T.AJ_TASK_GROUP,T.AJ_CONF_ID,T.AJ_INSTANCE,T.AJ_ENTITY_NAME "
			+ "from CTR_TALEND_LOGS t "
			+ "where t.ROOT_PID = :rootPid "
			+ "order by T.MOMENT DESC",nativeQuery = true)
	List<Logs> carregaLogs(String rootPid);
	

}

