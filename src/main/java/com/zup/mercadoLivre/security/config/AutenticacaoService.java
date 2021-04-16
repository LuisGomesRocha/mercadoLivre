package com.zup.mercadoLivre.security.config;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zup.mercadoLivre.repository.CadastroRepository;

import com.zup.mercadoLivre.domain.Cadastro;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private CadastroRepository repository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Cadastro> cadastro = repository.findByLogin(login);
		if (cadastro.isPresent()) {
			return cadastro.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
	}

}
