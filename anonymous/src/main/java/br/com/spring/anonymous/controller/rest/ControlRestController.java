package br.com.spring.anonymous.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.anonymous.entity.Control;
import br.com.spring.anonymous.repository.ControlRepository;

@RestController
@RequestMapping("/restControl")
public class ControlRestController {

	@Autowired
	private ControlRepository _ControlRepository;

		
	@CrossOrigin
	@GetMapping
	public List<Control> GetById(@RequestParam("process") String p_process
			,@RequestParam("institution") String p_institution,@RequestParam("dateReference") String p_dateReference) {
			
		return _ControlRepository.carregaControl(p_process,p_institution,p_dateReference);

	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Control Post(@RequestBody @Valid Control p_control) {

		return _ControlRepository.save(p_control);

	}	
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void Delete(@RequestBody @Valid Control p_control) {

		_ControlRepository.delete(p_control);


	}


}
