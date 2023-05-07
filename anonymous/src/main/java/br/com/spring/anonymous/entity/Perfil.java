package br.com.spring.anonymous.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "PROFILE_ANONYMOUS")
public class Perfil implements GrantedAuthority{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "NM_PROFILE")
	private String nome;
	
	@ManyToMany(mappedBy = "perfis")
    private List<Usuario> usuarios = new ArrayList<Usuario>();

	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String getAuthority() {	
		return this.nome;
	}

}
