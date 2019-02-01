package com.bank.kata.business;

import com.bank.kata.exception.AmountException;
import com.bank.kata.service.IGeneric;

public class Balance implements IGeneric<Balance> {

	private final Amount amount;

	public Balance(Amount amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return String.valueOf(amount);
	}

	@Override
	public Balance deposit(Amount amount) throws AmountException {
		return new Balance(this.amount.deposit(amount));
	}

	@Override
	public Balance withdrawal(Amount amount) throws AmountException {
		return new Balance(this.amount.withdrawal(amount));

	}

	@Override
	public boolean isNotAuthorizedWithDrawal(Amount amount) {
		return this.amount.isNotAuthorizedWithDrawal(amount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Balance balance = (Balance) o;

		return amount != null ? amount.equals(balance.amount) : balance.amount == null;
	}

	@Override
	public int hashCode() {
		return amount != null ? amount.hashCode() : 0;
	}

}
