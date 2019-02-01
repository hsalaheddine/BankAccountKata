package com.bank.kata.service;

import com.bank.kata.business.Amount;
import com.bank.kata.exception.AmountException;

public interface IAccount {

	// Make a deposit in my account
	public void deposit(Amount amount) throws AmountException;

	// Make a withdrawal from my account
	public void withdrawal(Amount amount) throws AmountException;

	// Print the history (operation, date, amount, balance)
	public void printHistory();

}
