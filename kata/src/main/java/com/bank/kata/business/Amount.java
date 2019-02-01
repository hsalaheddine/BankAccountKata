package com.bank.kata.business;

import com.bank.kata.exception.AmountException;
import com.bank.kata.service.IGeneric;

public class Amount implements IGeneric<Amount> {

	private double amountValue;

	@Override
	public String toString() {
		return String.valueOf(amountValue);
	}

	public Amount(double amountValue) throws AmountException {

		if (amountValue < 0)
			throw new AmountException("The amount must be equal to or greater than zero");

		this.amountValue = amountValue;
	}

	@Override
	public Amount deposit(Amount amount) throws AmountException {
		return new Amount(this.amountValue + amount.amountValue);
	}

	@Override
	public Amount withdrawal(Amount amount) throws AmountException {
		return new Amount(this.amountValue - amount.amountValue);

	}

	@Override
	public boolean isNotAuthorizedWithDrawal(Amount amount) {
		return this.amountValue - amount.amountValue < 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Amount amount = (Amount) o;

		return this.amountValue == amount.amountValue;
	}

	@Override
	public int hashCode() {
		return Double.valueOf(this.amountValue).hashCode();
	}

}
