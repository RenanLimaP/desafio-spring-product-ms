package com.desafio.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.desafio.spring.model.Produto;

@Service
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
