package br.com.spring.anonymous.controller.dto;

public class ErroValidacaoDto {
	
	private String campo;
	private String mensagem;
	
	
	public ErroValidacaoDto(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}


	public String getCampo() {
		return campo;
	}


	public String getMensagem() {
		return mensagem;
	}
	
	

}
