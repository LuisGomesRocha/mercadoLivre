package com.zup.mercadoLivre.dto;

import javax.validation.constraints.Email;

import com.zup.mercadoLivre.domain.Cadastro;

public class CadastroResponse {
	
	@Email(message = "login não aparenta se rum e-mail váldo")
	private String login;

	public CadastroResponse(@Email(message = "login não aparenta se rum e-mail váldo") String login) {
		super();
		this.login = login;
	}
	
	public CadastroResponse(Cadastro cadastro) {
		this.login = cadastro.getLogin();
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
				
}
