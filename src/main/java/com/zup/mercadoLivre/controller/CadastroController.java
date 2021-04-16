package com.zup.mercadoLivre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zup.mercadoLivre.domain.Cadastro;
import com.zup.mercadoLivre.dto.CadastroRequest;
import com.zup.mercadoLivre.dto.CadastroResponse;
import com.zup.mercadoLivre.service.CadastroService;

@RestController
@RequestMapping(value = "/api/cadastro")
public class CadastroController {

	@Autowired
	CadastroService cadastroService;

	// Criar Cadastro
	@PostMapping
	public ResponseEntity<CadastroResponse> novoCadastro(@Validated @RequestBody CadastroRequest cadastroRequest)
			throws Exception {

		Cadastro cadastro = cadastroRequest.toModel();
		cadastroService.cadastrar(cadastro);
		CadastroResponse cadastroResponse = new CadastroResponse(cadastro);
		return ResponseEntity.status(HttpStatus.OK).body(cadastroResponse);

	}

}
