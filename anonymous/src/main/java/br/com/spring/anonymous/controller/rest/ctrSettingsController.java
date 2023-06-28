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

import br.com.spring.anonymous.entity.CtrSettings;
import br.com.spring.anonymous.repository.CtrSettingsRepository;

@RestController
@RequestMapping("/restCtrSettings")
public class ctrSettingsController {

	@Autowired
	private CtrSettingsRepository _CtrSettingsRepository;

		
	@GetMapping
	public List<CtrSettings> GetById(@RequestParam("process") String p_process
			,@RequestParam("groupValue") String p_group_value) {
			
		return _CtrSettingsRepository.carregaCtrSettings(p_process,p_group_value);

	}

	@PostMapping
	public CtrSettings Post(@RequestBody @Valid CtrSettings p_ctr_settings) {

		return _CtrSettingsRepository.save(p_ctr_settings);

	}	
	
	@DeleteMapping
	public void Delete(@RequestBody @Valid CtrSettings p_ctr_settings) {

		_CtrSettingsRepository.delete(p_ctr_settings);


	}


}
