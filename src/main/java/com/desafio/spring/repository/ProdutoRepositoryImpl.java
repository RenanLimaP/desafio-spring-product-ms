package com.desafio.spring.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.desafio.spring.model.Produto;
import com.desafio.spring.model.ProdutoFilter;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Produto> findFiltered(ProdutoFilter produtoFilter) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
		Root<Produto> proutoRoot = cq.from(Produto.class);

		cq.where(this.criarRestricoes(produtoFilter, cb, proutoRoot));

		TypedQuery<Produto> query = em.createQuery(cq);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(ProdutoFilter lancamentoFilter, CriteriaBuilder builder, Root<Produto> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (lancamentoFilter.getMinPrice() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("price"), lancamentoFilter.getMinPrice()));
		}

		if (lancamentoFilter.getMaxPrice() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("price"), lancamentoFilter.getMaxPrice()));
		}

		if (!StringUtils.isEmpty(lancamentoFilter.getText())) {

			Predicate namePredicate = builder.like(builder.lower(root.get("name")),
					"%" + lancamentoFilter.getText().toLowerCase() + "%");

			Predicate descriptionPredicate = builder.like(builder.lower(root.get("description")),
					"%" + lancamentoFilter.getText().toLowerCase() + "%");

			predicates.add(builder.or(namePredicate, descriptionPredicate));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}
