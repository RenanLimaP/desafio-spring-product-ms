package com.desafio.spring.handler;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandardError implements Serializable {

	private static final long serialVersionUID = 6178983114444918338L;

	@JsonProperty(value = "status_code", index = 1)
	private Integer statusCode;

	private String message;
}
