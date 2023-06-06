package br.com.spring.anonymous.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.spring.anonymous.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {

	@Query(value="select t.process,t.job_Name,t.institution_Number,t.job_Group,t.active,t.execution_Group,t.execution_Order,t.outPut_Type "
			+ "from TAB_JOBS t "
			+ "WHERE (:process is null or t.process like %:process%) "
			+ "and (:jobName is null or t.job_name like %:jobName%) "
			+ "and (:institutionNumber is null or t.institution_number like %:institutionNumber% or t.institution_number is null ) "
			+ "and rownum <=10",nativeQuery = true)	
	List<Job> carregaJob(String process,String jobName, String institutionNumber);

}

