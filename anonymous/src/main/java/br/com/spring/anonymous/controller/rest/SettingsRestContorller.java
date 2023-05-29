package br.com.spring.anonymous.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.spring.anonymous.entity.Settings;
import br.com.spring.anonymous.repository.SettingsRepository;

@RestController
@RequestMapping("/settings")
public class SettingsRestContorller {

	@Autowired
	private SettingsRepository _SettingsRepository;

	@CrossOrigin
	@DeleteMapping("/settingName/{confId}/key/{key}")
	@Transactional
	public ResponseEntity<Settings> Delete(@PathVariable(value = "confId") String p_confId,@PathVariable(value = "key") String p_key,UriComponentsBuilder uriBuilder) {
		 _SettingsRepository.deletaSetting(p_confId.toUpperCase(),p_key.toUpperCase());	 
		 
		return ResponseEntity.ok().build();

	}

}
