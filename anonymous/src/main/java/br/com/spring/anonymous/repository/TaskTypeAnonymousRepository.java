package br.com.spring.anonymous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.entity.TaskTypeAnonymous;

@Repository
public interface TaskTypeAnonymousRepository extends JpaRepository<TaskTypeAnonymous, Long> { 
	
	@Query("select t.taskType,t.label from TaskTypeAnonymous t order by t.label")
	List<String> carregaTypes();
	
	//List<TaskTypeAnonymous> findBytaskType(String taskType);

}
