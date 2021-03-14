package com.desafio.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.spring.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>, ProdutoRepositoryCustom {

}
