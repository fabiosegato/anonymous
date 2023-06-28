package br.com.spring.anonymous.controller.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.anonymous.entity.Logs;
import br.com.spring.anonymous.repository.LogsRepository;

@RestController
@RequestMapping("/restLogs")
public class LogsRestController {

	@Autowired
	private LogsRepository _LogsRepository;
		
	@GetMapping
	public List<Logs> GetById(@RequestParam("rootPid") String p_rootPid) {
			
		return _LogsRepository.carregaLogs(p_rootPid);

	}

}
