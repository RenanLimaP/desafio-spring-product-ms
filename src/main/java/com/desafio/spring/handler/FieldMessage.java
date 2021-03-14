package com.desafio.spring.handler;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FieldMessage implements Serializable {

	private static final long serialVersionUID = -4636622130131740366L;

	private String fieldName;
	private String message;
}
