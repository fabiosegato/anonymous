package br.com.spring.anonymous.controller.dto;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.spring.anonymous.entity.Testerest;
import br.com.spring.anonymous.repository.TestRestRepository;


@RestController
@RequestMapping("/testerest")
public class TesteRestController {
	
	@Autowired
    private TestRestRepository _TestRestRepository;
	
		
	@CrossOrigin
	@GetMapping("/{id}")
    public List<Testerest> GetTeste(@PathVariable(value = "id") int p_id)
    {
        return _TestRestRepository.findById(p_id);
       
    }
	
	@PostMapping
	public ResponseEntity<Testerest> Post(@RequestBody @Valid Testerest teste_rest, UriComponentsBuilder uriBuilder) {

		Testerest testeRest = _TestRestRepository.save(teste_rest);
		URI uri = uriBuilder.path("/{id}").buildAndExpand(testeRest.getName()).toUri();
		return ResponseEntity.created(uri).body(testeRest);

	}


}
