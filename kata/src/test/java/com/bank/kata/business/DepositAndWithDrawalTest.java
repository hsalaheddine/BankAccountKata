package com.bank.kata.business;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.bank.kata.exception.AmountException;

@RunWith(MockitoJUnitRunner.class)
public class DepositAndWithDrawalTest {

	private Account account;

	@Before
	public void setUp() throws Exception {
		account = new Account(new Balance(new Amount(50)));
	}

	@Test
	public void adding_a_amount_of_ten() throws Exception {
		account.deposit(new Amount(10));
		Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(60)));
	}

	@Test(expected = AmountException.class)
	public void deposit_negative_value_not_authorize() throws Exception {
		account.deposit(new Amount(-10));
	}

	@Test
	public void withdrawal_a_amount_of_fourten() throws Exception {
		account.withdrawal(new Amount(40));
		Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(10)));
	}

	@Test(expected = AmountException.class)
	public void withdrawal_a_amount_of_seventen() throws Exception {
		account.withdrawal(new Amount(70));
	}

}
