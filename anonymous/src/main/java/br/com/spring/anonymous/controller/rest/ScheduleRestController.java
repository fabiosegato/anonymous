package br.com.spring.anonymous.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.anonymous.entity.Schedule;
import br.com.spring.anonymous.repository.ScheduleRepository;

@RestController
@RequestMapping("/restSchedule")
public class ScheduleRestController {

	@Autowired
	private ScheduleRepository  _ScheduleRepository;

		
	@GetMapping
	public List<Schedule> GetById(@RequestParam("taskGroup") String p_task_group
			,@RequestParam("instance") String p_instance) {
			
		return _ScheduleRepository.carregaSchedule(p_task_group,p_instance);

	}

	@PostMapping
	public Schedule Post(@RequestBody @Valid Schedule p_schedule) {

		return _ScheduleRepository.save(p_schedule);

	}	
	
	@DeleteMapping
	public void Delete(@RequestBody @Valid Schedule p_schedule) {

		_ScheduleRepository.delete(p_schedule);


	}


}
