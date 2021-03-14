package com.desafio.spring.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.spring.dto.ProdutoDTO;
import com.desafio.spring.exception.ObjectNotFoundException;
import com.desafio.spring.model.Produto;
import com.desafio.spring.model.ProdutoFilter;
import com.desafio.spring.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public Produto findById(Long id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public Produto insert(Produto obj) {
		return this.produtoRepository.save(obj);
	}

	public List<Produto> findAll() {
		List<Produto> produtos = new ArrayList<>();
		this.produtoRepository.findAll().forEach(produtos::add);
		return produtos;
	}

	public List<Produto> findAllFiltered(BigDecimal minPrice, BigDecimal maxPrice, String q) {
		return this.produtoRepository.findFiltered(new ProdutoFilter(minPrice, maxPrice, q));
	}

	public Produto update(Long id, Produto produto) {
		Produto produtoSalvo = this.findById(id);
		BeanUtils.copyProperties(produto, produtoSalvo, "id");
		return this.produtoRepository.save(produtoSalvo);
	}

	public void delete(Long id) {
		this.findById(id);
		this.produtoRepository.deleteById(id);
	}

	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(null, objDto.getName(), objDto.getDescription(), objDto.getPrice());
	}
}
