package com.desafio.spring.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.spring.dto.ProdutoDTO;
import com.desafio.spring.model.Produto;
import com.desafio.spring.service.ProdutoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/products")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping()
	@ApiOperation(value = "Consultar todos os produtos")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Sucesso ao obter produtos"))
	public ResponseEntity<List<Produto>> consultarProdutos() {
		return ResponseEntity.ok().body(this.produtoService.findAll());
	}

	@GetMapping("/search")
	@ApiOperation(value = "Consultar produtos com filtro")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Sucesso ao obter produtos"))
	public ResponseEntity<List<Produto>> consultarProdutosFiltro(
			@RequestParam(required = false, name = "min_price") BigDecimal minPrice,
			@RequestParam(required = false, name = "max_price") BigDecimal maxPrice,
			@RequestParam(required = false, defaultValue = "") String q) {
		return ResponseEntity.ok().body(this.produtoService.findAllFiltered(minPrice, maxPrice, q));
	}

	@GetMapping("/{idProduto}")
	@ApiOperation(value = "Consultar produto por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao obter produto"),
			@ApiResponse(code = 404, message = "Produto não encontrado") })
	public ResponseEntity<Produto> consultarProdutoById(@PathVariable Long idProduto) {
		return ResponseEntity.ok().body(this.produtoService.findById(idProduto));
	}

	@PostMapping()
	@ApiOperation(value = "Adicionar novo produto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao adicionar novo produto"),
			@ApiResponse(code = 400, message = "Erro na validação dos atributos") })
	public ResponseEntity<Produto> adicionarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
		Produto produto = this.produtoService.fromDTO(produtoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.produtoService.insert(produto));
	}

	@PutMapping("/{idProduto}")
	@ApiOperation(value = "Atualizar produto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao atualizar produto"),
			@ApiResponse(code = 400, message = "Erro na validação dos atributos") })
	public ResponseEntity<Produto> atualizarProduto(@PathVariable Long idProduto,
			@Valid @RequestBody ProdutoDTO produtoDTO) {
		Produto produto = this.produtoService.fromDTO(produtoDTO);
		return ResponseEntity.ok().body(this.produtoService.update(idProduto, produto));
	}

	@DeleteMapping("/{idProduto}")
	@ApiOperation(value = "Deletar produto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao deletar produto"),
			@ApiResponse(code = 400, message = "Produto não encontrado") })
	public ResponseEntity<Produto> deletarProduto(@PathVariable Long idProduto) {
		this.produtoService.delete(idProduto);
		return ResponseEntity.ok().build();
	}
}
