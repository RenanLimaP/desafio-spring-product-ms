package com.desafio.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Produto implements Serializable {

	private static final long serialVersionUID = -3569116723556332181L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome inválido")
	private String name;

	@NotBlank(message = "Descrição inválida")
	private String description;

	@NotNull(message = "Preço inválido")
	private BigDecimal price;

}
