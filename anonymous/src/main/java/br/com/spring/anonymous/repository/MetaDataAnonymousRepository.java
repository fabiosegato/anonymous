package br.com.spring.anonymous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.entity.MetaDataAnonymous;

@Repository
public interface MetaDataAnonymousRepository extends JpaRepository<MetaDataAnonymous, Long> { 
	
	List<MetaDataAnonymous> findBytaskType(String taskType);

}
