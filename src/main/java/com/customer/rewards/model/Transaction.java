package com.customer.rewards.model;

public class Transaction {
	
	private int dollersSpent;
	
	public Transaction(int dollersSpent) {
		this.dollersSpent = dollersSpent;
	}

	public int getDollersSpent() {
		return dollersSpent;
	}

	public void setDollersSpent(int dollersSpent) {
		this.dollersSpent = dollersSpent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dollersSpent;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (dollersSpent != other.dollersSpent)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [dollersSpent=" + dollersSpent + "]";
	}
	
	

}
