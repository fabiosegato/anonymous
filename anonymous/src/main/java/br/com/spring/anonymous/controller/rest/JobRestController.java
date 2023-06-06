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

import br.com.spring.anonymous.entity.Job;
import br.com.spring.anonymous.repository.JobRepository;

@RestController
@RequestMapping("/restJob")
public class JobRestController {

	@Autowired
	private JobRepository _JobRepository;

		
	@GetMapping
	public List<Job> GetJob(@RequestParam("process") String p_process,@RequestParam("jobName") String p_jobName
			,@RequestParam("institutionNumber") String p_institutionNumber) {
			
		System.out.println(p_process+p_institutionNumber);
		return _JobRepository.carregaJob(p_process,p_jobName,p_institutionNumber);

	}

	@PostMapping
	public Job Post(@RequestBody @Valid Job p_job) {

		return _JobRepository.save(p_job);

	}	
	
	@DeleteMapping
	public void Delete(@RequestBody @Valid Job p_job) {

		_JobRepository.delete(p_job);


	}


}
