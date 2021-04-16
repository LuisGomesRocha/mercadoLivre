package com.zup.mercadoLivre.domain;


import java.time.ZonedDateTime;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Cadastro implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "nome em branco!")
	@Size(min = 3, max = 30, message = "Nome deve conter de 3 a 30 caracteres!")
	@Column (unique = true)
	@Email(message = "login não aparenta se rum e-mail váldo")
	private String login;
	@Size(min = 6, message = "Senha precisa ter no mínimo 6 caracteres!")
	@NotBlank(message = "Senha em branco!")
	private String senha;
	@NotNull
	private ZonedDateTime instanteCadastro = ZonedDateTime.now() ;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Deprecated
	public Cadastro() {

	}

		
	public Cadastro(
			@NotBlank(message = "nome em branco!") @Size(min = 3, max = 30, message = "Nome deve conter de 3 a 30 caracteres!") @Email(message = "login não aparenta se rum e-mail váldo") String login,
			@Size(min = 6, message = "Senha precisa ter no mínimo 6 caracteres!") @NotBlank(message = "Senha em branco!") String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ZonedDateTime getInstanteCadastro() {
		return instanteCadastro;
	}

	public void setInstanteCadastro(ZonedDateTime instanteCadastro) {
		this.instanteCadastro = instanteCadastro;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
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

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}
	
