package br.com.spring.anonymous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.entity.MetaDataAnonymous;

@Repository
public interface MetaDataAnonymousRepository extends JpaRepository<MetaDataAnonymous, Long> { 
	
	@Query("select distinct(t.taskType) from MetaDataAnonymous t order by t.taskType")
	List<String> carregaTypes();

	//@Query("select t from MetaDataAnonymous t where t.taskType = :taskType")
	//List<MetaDataAnonymous> carregaSettings(@Param("taskType") String p_taskType);
	
	List<MetaDataAnonymous> findBytaskType(String taskType);

}
