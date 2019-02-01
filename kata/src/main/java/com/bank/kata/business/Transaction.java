package com.bank.kata.business;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.bank.kata.service.Operation;

public class Transaction {

	private final Operation operation;
	private final String transactionDate;
	private final Amount amount;
	private final Balance currentBalance;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	/**
	 * @param operation
	 * @param transactionDate
	 * @param amount
	 * @param currentBalance
	 */
	public Transaction(Operation operation, LocalDateTime transactionDate, Amount amount, Balance currentBalance) {
		super();
		this.operation = operation;
		this.transactionDate = transactionDate.format(formatter);
		this.amount = amount;
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return (operation.getOperation() + "  |  " + transactionDate + " |  " + amount + " |  " + currentBalance);
	}

	/**
	 * Print Transaction
	 */
	public void print() {
		System.out.println(this.toString());
	}

}
