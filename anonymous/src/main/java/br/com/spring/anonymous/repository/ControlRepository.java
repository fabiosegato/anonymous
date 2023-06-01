package br.com.spring.anonymous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.entity.Control;

@Repository
public interface ControlRepository extends JpaRepository<Control, String> {

	@Query(value="select t.process,t.date_Reference,t.seq_Id,t.institution_Number,t.days_Qty,t.date_Max,t.schedule_Type,t.businessday,t.prmt_1 "
			+ "from TAB_CONTROL t "
			+ "where (t.process IS NULL or t.process like %:process%) and (:institutionNumber IS NULL or t.institution_Number = :institutionNumber) "
			+ "and (:dateReference IS NULL or t.date_reference = to_date(:dateReference,'YYYY-MM-DD'))"
			+ "and rownum <= 10",nativeQuery = true)
	List<Control> carregaControl(String process,String institutionNumber,String dateReference);
	
	

	

}

