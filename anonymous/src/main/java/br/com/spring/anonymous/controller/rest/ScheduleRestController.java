package br.com.spring.anonymous.controller.rest;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.spring.anonymous.controller.dto.Mensagem;
import br.com.spring.anonymous.entity.Schedule;
import br.com.spring.anonymous.repository.ScheduleRepository;

@RestController
@RequestMapping("/schedule")
public class ScheduleRestController {

	@Autowired
	private ScheduleRepository _ScheduleRepository;
	
	/*@CrossOrigin
	@GetMapping("/{taskName}")
	public Collection<ScheduleDto> GetTaskName(@PathVariable(value = "taskName") String p_taskName) {
		return this.toScheduleDto(_ScheduleRepository.carregaSchedule(p_taskName.toUpperCase()));

	}*/
	
	@PostMapping
	public ResponseEntity<Mensagem> Post(@RequestBody @Valid Schedule p_schedule, UriComponentsBuilder uriBuilder) {
    Mensagem mensagem = new Mensagem();
    
    _ScheduleRepository.executaJob(p_schedule.getScheduleId(), p_schedule.getTaskGroup());
    
    mensagem.setDesc("Execução do job: "+ p_schedule.getTaskGroup() +" solicitada com sucesso!");
		
    return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
	}
	



}
