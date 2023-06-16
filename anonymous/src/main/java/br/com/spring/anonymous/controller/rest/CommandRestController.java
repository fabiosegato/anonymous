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

import br.com.spring.anonymous.entity.Command;
import br.com.spring.anonymous.repository.CommandRepository;

@RestController
@RequestMapping("/restCommand")
public class CommandRestController {

	@Autowired
	private CommandRepository _CommandRepository;

		
	@GetMapping
	public List<Command> GetById(@RequestParam("id") String p_id,@RequestParam("command") String p_command) {
		
		List<Command> command = _CommandRepository.carregaCommand(p_id,p_command);
		
		command.stream()
		.forEach(n->n.setHash(n.getId().hashCode()));
			
		return command;

	}

	@PostMapping
	public Command Post(@RequestBody @Valid Command p_command) {

		return _CommandRepository.save(p_command);

	}	
	
	@DeleteMapping
	public void Delete(@RequestBody @Valid Command p_control) {

		_CommandRepository.delete(p_control);


	}


}
