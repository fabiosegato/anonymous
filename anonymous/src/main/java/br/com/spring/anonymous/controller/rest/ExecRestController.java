package br.com.spring.anonymous.controller.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.anonymous.entity.Exec;
import br.com.spring.anonymous.repository.ExecRepository;

@RestController
@RequestMapping("/restExec")
public class ExecRestController {

	@Autowired
	private ExecRepository _ExecRepository;

	@GetMapping
	public List<Exec> GetTaskName(@RequestParam("taskName") String p_task_name,
			@RequestParam("status") Integer p_status, @RequestParam("instance") String p_instance) {
		
		if (p_status == 2) {
			System.out.println("EXEC");
			return _ExecRepository.carregaExec(p_task_name,p_status,p_instance);
		}
		System.out.println("DONE");
		return _ExecRepository.carregaDone(p_task_name,p_status,p_instance);
		

		

	}

}
