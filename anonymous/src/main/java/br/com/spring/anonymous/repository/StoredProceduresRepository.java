package br.com.spring.anonymous.repository;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.controller.dto.ProcedureResultDto;

@Repository
public class StoredProceduresRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public ProcedureResultDto cloneJob(String pTaskGroupName,String pTaskGroupNameNew) {
		
        StoredProcedureQuery proc = em.createStoredProcedureQuery("PRC_CLONE_JOB");
        proc.registerStoredProcedureParameter("p_task_group_name", String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter("p_task_group_name_new", String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter("error_code", String.class, ParameterMode.OUT);
        proc.registerStoredProcedureParameter("error_msg", String.class, ParameterMode.OUT);

   
        proc.setParameter("p_task_group_name", pTaskGroupName);
        proc.setParameter("p_task_group_name_new", pTaskGroupNameNew);
        proc.execute();
   
        return new ProcedureResultDto((String) proc.getOutputParameterValue("error_code"),(String) proc.getOutputParameterValue("error_msg"));
    }

}
