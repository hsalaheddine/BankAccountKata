package com.bank.kata.business;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AmountTest {

	@Test
	public void deposit_a_amount() throws Exception {
		Amount amount = new Amount(500);
		amount = amount.deposit(new Amount(300));
		Amount expectedAmount = new Amount(800);
		Assertions.assertThat(amount).isEqualTo(expectedAmount);
	}

	@Test
	public void return_true_when_withdrawal_is_not_authorized() throws Exception {
		Amount amount = new Amount(1000);
		Assertions.assertThat(amount.isNotAuthorizedWithDrawal(new Amount(1200))).isTrue();
	}

	@Test
	public void return_false_when_withdrawal_is_authorized() throws Exception {
		Amount amount = new Amount(5000);
		Assertions.assertThat(amount.isNotAuthorizedWithDrawal(new Amount(2500))).isFalse();
	}

	@Test
	public void withdrawal_a_amount() throws Exception {
		Amount amount = new Amount(900);
		amount = amount.withdrawal(new Amount(800));
		Amount expectedAmount = new Amount(100);
		Assertions.assertThat(amount).isEqualTo(expectedAmount);
	}

}
