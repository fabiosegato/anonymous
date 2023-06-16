package br.com.spring.anonymous.controller.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.spring.anonymous.controller.dto.ProcedureResultDto;
import br.com.spring.anonymous.entity.TaskGroup;
import br.com.spring.anonymous.repository.StoredProceduresRepository;
import br.com.spring.anonymous.repository.TaskGroupRepository;

@RestController
@RequestMapping("/taskgroup")
public class TaskGroupRestController {

	@Autowired
	private TaskGroupRepository _TaskGroupRepository;
	
	@Autowired
	private StoredProceduresRepository _StoredProceduresRepository;

	@GetMapping
	public List<TaskGroup> Get() {
		return _TaskGroupRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<TaskGroup> Post(@RequestBody @Valid TaskGroup task_group, UriComponentsBuilder uriBuilder) {
		
		TaskGroup taskGroup = _TaskGroupRepository.save(task_group);
		
		URI uri = uriBuilder.path("/taskgroup/{id}").buildAndExpand(taskGroup.getTaskName()).toUri();
		return ResponseEntity.created(uri).body(taskGroup);

	}

	@CrossOrigin
	@PostMapping("/taskgroupClone")
	public ResponseEntity<?> Clone(@RequestParam("taskGroup") String p_taskGroup,@RequestParam("taskGroupNew") String p_taskGroupNew) {
		
		ProcedureResultDto result =	_StoredProceduresRepository.cloneJob(p_taskGroup, p_taskGroupNew);
		
		Optional<String> errorCode = Optional.ofNullable(result.getErrorCode());
		
		if (errorCode.isPresent()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} 
		
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	

	}

	@CrossOrigin
	@DeleteMapping("/{taskGroup}")
	public ResponseEntity<TaskGroup> Delete(@PathVariable(value = "taskGroup") String p_taskGroup,
			UriComponentsBuilder uriBuilder) {

		_TaskGroupRepository.deleteById(p_taskGroup);
		return ResponseEntity.ok().build();

	}

	@CrossOrigin
	@GetMapping("/{taskGroup}")
	public Optional<TaskGroup> GetById(@PathVariable(value = "taskGroup") String p_taskGroup) {
		return _TaskGroupRepository.findById(p_taskGroup);

	}

	@CrossOrigin
	@GetMapping("/taskName/{taskName}")
	public List<String> GetTaskName(@PathVariable(value = "taskName") String p_taskName) {
		return _TaskGroupRepository.carregaTaskName(p_taskName.toUpperCase());

	}

}
