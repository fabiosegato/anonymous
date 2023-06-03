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

import br.com.spring.anonymous.entity.Parameters;
import br.com.spring.anonymous.repository.ParametersRepository;

@RestController
@RequestMapping("/restParameters")
public class ParametersRestController {

	@Autowired
	private ParametersRepository _ParametersRepository;

	@GetMapping
	public List<Parameters> GetById(@RequestParam("process") String p_process
			,@RequestParam("institution") String p_institution,@RequestParam("dateReference") String p_dateReference) {
			
		return _ParametersRepository.carregaParameters(p_process,p_institution,p_dateReference);

	}

	@PostMapping
	public Parameters Post(@RequestBody @Valid Parameters p_parameters) {

		return _ParametersRepository.save(p_parameters);

	}	
	
	@DeleteMapping
	public void Delete(@RequestBody @Valid Parameters p_parameters) {

		_ParametersRepository.delete(p_parameters);


	}

}
