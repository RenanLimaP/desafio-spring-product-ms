package com.desafio.spring.handler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class ValidationError extends StandardError implements Serializable {

	private static final long serialVersionUID = -167204272016829166L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer statusCode, String message) {
		super(statusCode, message);
	}

	public void addError(String fieldName, String messagem) {
		errors.add(new FieldMessage(fieldName, messagem));
	}
}
