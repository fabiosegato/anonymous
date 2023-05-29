package br.com.spring.anonymous.controller.dto;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.spring.anonymous.entity.Parameters;
import br.com.spring.anonymous.repository.ParametersRepository;

@RestController
@RequestMapping("/restParameters")
public class ParametersRestController {

	@Autowired
	private ParametersRepository _ParametersRepository;

		
	@CrossOrigin
	@GetMapping
	public List<Parameters> GetById(@RequestParam("process") String p_process
			,@RequestParam("institution") String p_institution,@RequestParam("dateReference") String p_dateReference) {
		
		
		System.out.println("inst:" + p_institution);
		
		return _ParametersRepository.carregaParameters(p_process,p_institution,p_dateReference);

	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Parameters Post(@RequestBody @Valid Parameters p_parameters) {

		return _ParametersRepository.save(p_parameters);
		//URI uri = uriBuilder.path("/taskgroup/{id}").buildAndExpand(parameters.getProcess()).toUri();


	}
	
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void Delete(@RequestBody @Valid Parameters p_parameters) {

		_ParametersRepository.delete(p_parameters);
		//URI uri = uriBuilder.path("/taskgroup/{id}").buildAndExpand(parameters.getProcess()).toUri();


	}

	/*
	@CrossOrigin
	@GetMapping("/taskName/{taskName}")
	public List<String> GetTaskName(@PathVariable(value = "taskName") String p_taskName) {
		return _TaskGroupRepository.carregaTaskName(p_taskName.toUpperCase());

	}*/
	
	

}
