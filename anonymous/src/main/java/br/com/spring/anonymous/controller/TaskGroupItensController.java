package br.com.spring.anonymous.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.spring.anonymous.entity.TaskGroup;
import br.com.spring.anonymous.repository.TaskGroupItensRepository;


@RestController
@RequestMapping("/taskgroupitem")
public class TaskGroupItensController {

	@Autowired
	private TaskGroupItensRepository _TaskGroupItensRepository;
	
	@CrossOrigin
	@DeleteMapping("/{taskGroupitem}")
	public ResponseEntity<TaskGroup> Delete(@PathVariable(value = "taskGroupitem") String p_taskGroupItem,UriComponentsBuilder uriBuilder) {

		 _TaskGroupItensRepository.deleteById(p_taskGroupItem);
		return ResponseEntity.ok().build();

	}

}
