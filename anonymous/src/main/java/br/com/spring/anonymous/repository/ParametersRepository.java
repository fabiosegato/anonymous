package br.com.spring.anonymous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.entity.Parameters;

@Repository
public interface ParametersRepository extends JpaRepository<Parameters, String> {


	@Query(value="select t.process,  t.job_Name,  t.date_Reference,  t.seq_Id,  t.from_Parameter, t.to_Parameter,  t.status,  t.date_Start"
			+ ",  t.date_End,  t.duration,  t.output_Type, t.institution_Number "
			+ "from TAB_PARAMETERS t "
			+ "where (t.process IS NULL or t.process like %:process%) and (:institutionNumber IS NULL or t.institution_Number = :institutionNumber) "
			+ "and (:dateReference IS NULL or t.date_reference = to_date(:dateReference,'YYYY-MM-DD'))"
			+ "and rownum <= 10",nativeQuery = true)
	List<Parameters> carregaParameters(String process,String institutionNumber,String dateReference);
	

}

