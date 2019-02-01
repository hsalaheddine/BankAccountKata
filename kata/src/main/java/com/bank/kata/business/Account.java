package com.bank.kata.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.bank.kata.exception.AmountException;
import com.bank.kata.service.IAccount;
import com.bank.kata.service.Operation;

public class Account implements IAccount {

	private Balance balance;

	Balance getBalance() {
		return balance;
	}

	// Containt list of all transaction
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public Account(Balance balance) {
		super();
		this.balance = balance;
	}

	/**
	 * @param amount
	 * @param operation
	 */
	private void buildTransaction(Amount amount, Operation operation) {
		Transaction transaction = new Transaction(operation, LocalDateTime.now(), amount, balance);
		transactions.add(transaction);
	}

	@Override
	public void deposit(Amount amount) throws AmountException {
		balance = balance.deposit(amount);
		buildTransaction(amount, Operation.DEPOSIT);

	}

	
	@Override
	public void withdrawal(Amount amount) throws AmountException {

		if (balance.isNotAuthorizedWithDrawal(amount))
			throw new AmountException("You do not have enough balance to do this withdrawal");

		balance = balance.withdrawal(amount);
		buildTransaction(amount, Operation.WITHDRAWAL);

	}

	@Override
	public void printHistory() {

		System.out.println("#### HISTORY OF YOUR ACCOUNT #### \n");
		System.out.println("OPERATION  |  DATETIME |  AMOUNT |  NEW BALANCE\n");

		transactions.forEach(t -> t.print());

		System.out.println("\n#### END #### \n");

	}

}
