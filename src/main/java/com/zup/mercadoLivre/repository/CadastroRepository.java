package com.zup.mercadoLivre.repository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.zup.mercadoLivre.domain.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

	Optional<Cadastro> findByLogin(String login);
	Page<Cadastro> findAll(Pageable pageable);
	
}