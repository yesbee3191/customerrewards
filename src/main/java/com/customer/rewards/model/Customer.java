package com.customer.rewards.model;

import java.util.List;

public class Customer {
	
	private String customerName;
	private List<Transaction> transactions;
	private int customerTotalRewards;
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public int getCustomerTotalRewards() {
		return customerTotalRewards;
	}
	
	public void setCustomerTotalRewards(int customerTotalRewards) {
		this.customerTotalRewards = customerTotalRewards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + customerTotalRewards;
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
		Customer other = (Customer) obj;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerTotalRewards != other.customerTotalRewards)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerTotalRewards=" + customerTotalRewards + "]";
	}
	

}
