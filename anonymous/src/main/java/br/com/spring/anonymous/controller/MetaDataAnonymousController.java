package br.com.spring.anonymous.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.anonymous.entity.MetaDataAnonymous;
import br.com.spring.anonymous.repository.MetaDataAnonymousRepository;
import br.com.spring.anonymous.repository.TaskTypeAnonymousRepository;


@RestController
@RequestMapping("/metadata")
public class MetaDataAnonymousController {
	
	@Autowired
    private MetaDataAnonymousRepository _MetaDataAnonymousRepository;
	@Autowired
    private TaskTypeAnonymousRepository _TaskTypeAnonymousRepository;
	
	
	@CrossOrigin
	@GetMapping("/types")
    public List<String> GetDistinct() {
        return _TaskTypeAnonymousRepository.carregaTypes();
    }
	
	@CrossOrigin
	@GetMapping("/settings/{taskType}")
    public List<MetaDataAnonymous> GetSettings(@PathVariable(value = "taskType") String taskType)
    {
        return _MetaDataAnonymousRepository.findBytaskType(taskType);
       
    }


}
