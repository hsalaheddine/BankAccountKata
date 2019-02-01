package com.bank.kata.service;

public enum Operation {

	DEPOSIT("(+) DEPOSIT"), WITHDRAWAL("(-) WITHDRAWAL");

	private final String operation;

	Operation(String operation) {
		this.operation = operation;
	}

	public String getOperation() {
		return operation;
	}

}
