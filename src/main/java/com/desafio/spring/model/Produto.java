package com.desafio.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Produto implements Serializable {

	private static final long serialVersionUID = -3569116723556332181L;

	private Long id;
	private String name;
	private String description;
	private BigDecimal price;

}
