package br.com.spring.anonymous.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.spring.anonymous.entity.TbException;

@Repository
public interface ExceptionRepository extends JpaRepository<TbException, String> {

	@Query(value="select t.EXC_TYPE,t.PROC_NAME,t.VALUE,t.DATA "
			+ "from TB_EXCEPTION t "
			+ "WHERE (:value is null or t.value like %:value%) "
			+ "and (:execType is null or t.EXC_TYPE like %:execType%) "
			+ "and rownum <=20",nativeQuery = true)	
	List<TbException> carregaException(String value,String execType);

}

