package br.com.spring.anonymous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.entity.CtrSettings;

@Repository
public interface CtrSettingsRepository extends JpaRepository<CtrSettings, String> {

	@Query(value="select t.PROCESS,\"GROUP\",t.KEY,t.VALUE,t.GROUP_VALUE,t.ORDER_ID "
			+ "from CTR_SETTINGS t "
			+ "where (:process IS NULL or t.process like %:process%) "
			+ "and (:groupValue IS NULL or t.GROUP_VALUE like %:groupValue%) "
			+ "and rownum <= 10",nativeQuery = true)
	List<CtrSettings> carregaCtrSettings(String process,String groupValue);
	

}

