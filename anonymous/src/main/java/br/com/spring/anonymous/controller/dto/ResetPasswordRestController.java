package br.com.spring.anonymous.controller.dto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.spring.anonymous.entity.Mensagem;
import br.com.spring.anonymous.entity.ResetUsuario;
import br.com.spring.anonymous.entity.Usuario;
import br.com.spring.anonymous.repository.UsuarioRepository;

@RestController
@RequestMapping("/resetPassword")
public class ResetPasswordRestController {

	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	public ResponseEntity<Mensagem> Post(@RequestBody @Valid ResetUsuario p_usuario, UriComponentsBuilder uriBuilder) {		

	//UserDetails useruser = _autenticacao.loadUserByUsername(p_usuario.getEmail());
		Object principal = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
		Usuario user = (Usuario) principal;
		
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		
		Mensagem mensagem = new Mensagem();
		
		if(bc.matches(p_usuario.getSenha(), user.getPassword())) {
			user.setSenha(bc.encode(p_usuario.getSenhaNova()));			
			repository.save(user);		
			mensagem.setDesc("Password alterado!");
			return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
	    } else 
		{
	    	mensagem.setDesc("Password inválido!");
	    	return ResponseEntity.status(HttpStatus.OK).body(mensagem);
		}	

	}

}
