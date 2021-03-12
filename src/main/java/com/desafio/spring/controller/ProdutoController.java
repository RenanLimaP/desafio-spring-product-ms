package com.desafio.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.spring.model.Produto;
import com.desafio.spring.service.ProdutoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value = "/products")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/{id}")
	@ApiOperation(value = "Consultar produto por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao obter produto"),
			@ApiResponse(code = 404, message = "Produto não localizado") })
	public void consultarProdutoById(@PathVariable Long idProduto) {
		produtoService.find(idProduto);
	}

	@GetMapping()
	@ApiOperation(value = "Consultar produto por ID")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Sucesso ao obter produtos"))
	public ResponseEntity<List<Produto>> consultarProdutos() {
		return ResponseEntity.ok().body(produtoService.findAll());
	}
}
