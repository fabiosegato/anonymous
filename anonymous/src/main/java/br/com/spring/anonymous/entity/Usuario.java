package br.com.spring.anonymous.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USER_ANONYMOUS")
public class Usuario implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "NM_USER")
	private String nome;
	
	@Column(name = "NM_EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String senha;
	
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "USER_PROFILE_ANONYMOUS", 
			  joinColumns = {@JoinColumn(name = "NM_USER")},
		      inverseJoinColumns = {@JoinColumn(name = "NM_PROFILE")}
	)
	private List<Perfil> perfis = new ArrayList<Perfil>();
	
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.nome;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

}
