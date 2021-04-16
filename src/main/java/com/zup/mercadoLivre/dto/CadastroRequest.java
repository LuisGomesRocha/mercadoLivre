package com.zup.mercadoLivre.dto;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zup.mercadoLivre.domain.Cadastro;

public class CadastroRequest {
	
	@NotBlank(message = "nome em branco!")
	@Size(min = 3, max = 30, message = "Nome deve conter de 3 a 30 caracteres!")
	@Column (unique = true)
	@Email(message = "login não aparenta se rum e-mail váldo")
	private String login;
	@Size(min = 6, max = 30, message = "Senha precisa ter no mínimo 6 caracteres!")
	@NotBlank(message = "Senha em branco!")
	private String senha;

	
	public Cadastro toModel() {
		return new Cadastro(this.login, this.senha);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
		
}
