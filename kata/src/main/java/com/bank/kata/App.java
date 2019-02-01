package com.bank.kata;

import com.bank.kata.business.Account;
import com.bank.kata.business.Amount;
import com.bank.kata.business.Balance;
import com.bank.kata.exception.AmountException;

/**
 * BANK ACCOUNT KATA DEMO
 *
 */
public class App {
	public static void main(String[] args) throws AmountException {
		Balance balance = new Balance(new Amount(0));
		Account account = new Account(balance);

		account.deposit(new Amount(1000));
		account.deposit(new Amount(1000));
		account.withdrawal(new Amount(2000));

		account.printHistory();
	}
}
