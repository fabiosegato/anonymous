package br.com.spring.anonymous.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.spring.anonymous.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	Optional<Usuario> findByEmail(String email);
	

}
