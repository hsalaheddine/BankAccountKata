package com.bank.kata.service;

import com.bank.kata.business.Amount;
import com.bank.kata.exception.AmountException;

public interface IGeneric<T> {

	// Refresh Balance after a deposit
	T deposit(Amount amount) throws AmountException;

	// Refresh Balance after a withdrawal
	T withdrawal(Amount amount) throws AmountException;

	// Check is result will be negative after a withdrawal
	boolean isNotAuthorizedWithDrawal(Amount amount);
}
