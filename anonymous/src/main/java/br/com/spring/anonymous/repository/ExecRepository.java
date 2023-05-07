package br.com.spring.anonymous.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.entity.Exec;

@Repository
public interface ExecRepository extends JpaRepository<Exec, String> {

	
	@Query("select t from Exec t where t.taskGroup like %:taskName%")
	Collection<Exec> carregaExec(String taskName);
	

}

