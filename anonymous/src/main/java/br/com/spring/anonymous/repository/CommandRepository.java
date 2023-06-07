package br.com.spring.anonymous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.entity.Command;

@Repository
public interface CommandRepository extends JpaRepository<Command, String> {

	@Query(value = "select t.id, t.cmd_Group,t.cmd_Order,t.dsc,t.command,t.aj_Type,t.atb_01,t.atb_02,t.atb_03,t.atb_04,t.atb_05,t.status "
			+ "from CTR_AJ_COMMANDS t "
			+ "where (:id IS NULL or t.id like %:id%) and (:command IS NULL or t.command like %:command%) "
			+ "and rownum <= 10", nativeQuery = true)
	List<Command> carregaCommand(String id, String command);

}
