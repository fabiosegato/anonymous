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

import br.com.spring.anonymous.entity.TbException;
import br.com.spring.anonymous.repository.ExceptionRepository;

@RestController
@RequestMapping("/restException")
public class ExceptionRestController {

	@Autowired
	private ExceptionRepository _ExceptionRepository;
		
	@GetMapping
	public List<TbException> GetJob(@RequestParam("value") String p_value,@RequestParam("execType") String p_exec_type) {
			
		return _ExceptionRepository.carregaException(p_value,p_exec_type);

	}

	@PostMapping
	public TbException Post(@RequestBody @Valid TbException p_exception) {

		return _ExceptionRepository.save(p_exception);

	}	
	
	@DeleteMapping
	public void Delete(@RequestBody @Valid TbException p_exception) {

		_ExceptionRepository.delete(p_exception);


	}


}
