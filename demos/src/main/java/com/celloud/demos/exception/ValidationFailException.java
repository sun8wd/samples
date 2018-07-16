package com.celloud.demos.exception;

import org.springframework.validation.Errors;

public class ValidationFailException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Errors errors;

	public ValidationFailException() {
	}

	public ValidationFailException(Errors errors) {
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}

}
