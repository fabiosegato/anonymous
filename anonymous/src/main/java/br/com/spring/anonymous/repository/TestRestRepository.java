package br.com.spring.anonymous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.spring.anonymous.entity.Testerest;

public interface TestRestRepository extends JpaRepository<Testerest, String> {
	
	List<Testerest> findById(int id);	

}
