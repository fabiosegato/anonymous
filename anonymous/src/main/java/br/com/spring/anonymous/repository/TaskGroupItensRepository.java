package br.com.spring.anonymous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.entity.TaskGroupItens;

@Repository
public interface TaskGroupItensRepository extends JpaRepository<TaskGroupItens, String> {


	

}

