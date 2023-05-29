package br.com.spring.anonymous.controller.dto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.anonymous.entity.Exec;
import br.com.spring.anonymous.repository.ExecRepository;

@RestController
@RequestMapping("/exec")
public class ExecRestController {

	@Autowired
	private ExecRepository _ExecRepository;

	@CrossOrigin
	@GetMapping("/{taskName}")
	public Collection<Exec> GetTaskName(@PathVariable(value = "taskName") String p_taskName) {
		return _ExecRepository.carregaExec(p_taskName.toUpperCase());

	}

}
