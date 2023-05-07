package br.com.spring.anonymous.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.spring.anonymous.config.security.TokenService;
import br.com.spring.anonymous.controller.dto.TokenDto;


//@RestController
//@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService serviceToken;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form){
		
		UsernamePasswordAuthenticationToken dadosLogin = form.coverter();
		
		try {
			Authentication authenticate = authManager.authenticate(dadosLogin);
			String token = serviceToken.gerarToken(authenticate);
			return ResponseEntity.ok(new TokenDto(token,"Bearer"));
		}
		catch(AuthenticationException e)
		{
			return ResponseEntity.badRequest().build();
		}
		
			
		
	}

}
