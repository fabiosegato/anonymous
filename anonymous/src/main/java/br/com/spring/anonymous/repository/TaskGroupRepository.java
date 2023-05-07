package br.com.spring.anonymous.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.spring.anonymous.entity.TaskGroup;

@Repository
public interface TaskGroupRepository extends JpaRepository<TaskGroup, String> {


	
	@Query("select distinct(t.taskName) from TaskGroup t where t.taskName like %:taskName%")
	List<String> carregaTaskName(String taskName);
	
	
	

}

