package br.com.spring.anonymous.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {
	
	private String email;
	private String senha;
	
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
	
	public UsernamePasswordAuthenticationToken coverter() {
		// TODO Auto-generated method stub
		return new UsernamePasswordAuthenticationToken(email, senha);
	}
	
	

}
