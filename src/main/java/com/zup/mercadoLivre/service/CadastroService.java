package com.zup.mercadoLivre.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.zup.mercadoLivre.domain.Cadastro;
import com.zup.mercadoLivre.repository.CadastroRepository;

@Service
public class CadastroService {

	
	@Autowired
	CadastroRepository cadastroRepository;

	// Cadastrar

	public Cadastro cadastrar(Cadastro cadastro) throws Exception {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		cadastro.setSenha(bCryptPasswordEncoder.encode(cadastro.getSenha()));
		//boolean passwordIsValid = bCryptPasswordEncoder.matches("password", bCryptedPassword);
		return cadastroRepository.save(cadastro);

	}

	// Busca
	public Cadastro buscar(Long id) {

		return cadastroRepository.findById(id).get();

	}	
	

	public Page<Cadastro> buscarTudo(Pageable cadastro) {
		
		Page<Cadastro> paginaCadastro = cadastroRepository.findAll(cadastro);
		return paginaCadastro;		
		
	}
	
}
