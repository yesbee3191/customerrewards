package com.cutomer.rewards.model;

import java.util.List;

public class TransactionPeriod {
	
	private List<Customer> customers;
	private int totalMonthlyRewards;
	private String transactionsMonth;
	
	public List<Customer> getCustomers() {
		return customers;
	}
	
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public int getTotalMonthlyRewards() {
		return totalMonthlyRewards;
	}
	
	public void setTotalMonthlyRewards(int totalMonthlyRewards) {
		this.totalMonthlyRewards = totalMonthlyRewards;
	}
	
	public String getTransactionsMonth() {
		return transactionsMonth;
	}
	
	public void setTransactionsMonth(String transactionsMonth) {
		this.transactionsMonth = transactionsMonth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + totalMonthlyRewards;
		result = prime * result + ((transactionsMonth == null) ? 0 : transactionsMonth.hashCode());
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
		TransactionPeriod other = (TransactionPeriod) obj;
		if (totalMonthlyRewards != other.totalMonthlyRewards)
			return false;
		if (transactionsMonth == null) {
			if (other.transactionsMonth != null)
				return false;
		} else if (!transactionsMonth.equals(other.transactionsMonth))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransactionPeriod [totalMonthlyRewards=" + totalMonthlyRewards + ", transactionsMonth="
				+ transactionsMonth + "]";
	}
	
	

}
