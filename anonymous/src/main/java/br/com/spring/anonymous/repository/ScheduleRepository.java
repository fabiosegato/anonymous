package br.com.spring.anonymous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.spring.anonymous.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {


}

