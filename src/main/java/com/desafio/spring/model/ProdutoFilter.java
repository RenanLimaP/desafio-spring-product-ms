package com.desafio.spring.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoFilter {

	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	private String text;

}
