package com.desafio.spring.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.desafio.spring.model.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 4916846971426070686L;

	@NotBlank(message = "Nome inválido")
	private String name;

	@NotBlank(message = "Descrição inválida")
	private String description;

	@NotNull(message = "Preço inválido")
	@Positive(message = "Preço deve ser maior que 0")
	private BigDecimal price;

	public ProdutoDTO(Produto obj) {
		this.name = obj.getName();
		this.description = obj.getDescription();
		this.price = obj.getPrice();
	}
}