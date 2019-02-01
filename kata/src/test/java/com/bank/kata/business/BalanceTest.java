package com.bank.kata.business;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BalanceTest {

	@Test
	public void deposit_a_amount_balance() throws Exception {
		Balance balance = new Balance(new Amount(0));
		balance = balance.deposit(new Amount(855));
		Balance expectedBalance = new Balance(new Amount(855));
		Assertions.assertThat(balance).isEqualTo(expectedBalance);
	}

	@Test
	public void return_true_when_withdrawal_is_not_authorized() throws Exception {
		Balance balance = new Balance(new Amount(200));
		Assertions.assertThat(balance.isNotAuthorizedWithDrawal(new Amount(400))).isTrue();
	}

	@Test
	public void return_false_when_withdrawal_is_authorized() throws Exception {
		Balance balance = new Balance(new Amount(500));
		Assertions.assertThat(balance.isNotAuthorizedWithDrawal(new Amount(250))).isFalse();
	}

	@Test
	public void withdrawal_a_amount_balance() throws Exception {
		Balance balance = new Balance(new Amount(785));
		balance = balance.withdrawal(new Amount(85));
		Balance expectedBalance = new Balance(new Amount(700));
		Assertions.assertThat(balance).isEqualTo(expectedBalance);
	}

}
