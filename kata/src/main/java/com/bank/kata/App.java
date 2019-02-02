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
		
		// init Balance with amount 0 
		Balance balance = new Balance(new Amount(0));
		
		// new account with balance 0
		Account account = new Account(balance);

		// deposit a amount of 1000
		account.deposit(new Amount(1000));
		
		// deposit a amount of 1500
		account.deposit(new Amount(1500));
		
		// withdrawal a amount of 1500
		account.withdrawal(new Amount(2000));

		// print history of all transaction
		account.printHistory();
	}
}
