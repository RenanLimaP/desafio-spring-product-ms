package com.desafio.spring.repository;

import java.util.List;

import com.desafio.spring.model.Produto;
import com.desafio.spring.model.ProdutoFilter;

public interface ProdutoRepositoryCustom {

	public List<Produto> findFiltered(ProdutoFilter produtoFilter);

}
