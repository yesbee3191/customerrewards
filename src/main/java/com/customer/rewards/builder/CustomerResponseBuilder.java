package com.customer.rewards.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.customer.rewards.model.Customer;
import com.customer.rewards.model.Transaction;
import com.customer.rewards.model.TransactionPeriod;

@Component
public class CustomerResponseBuilder {

    private static final int VALUE_FIFTY = 50;
	
	private static final int VALUE_HUNDRAD = 100;

	public List<TransactionPeriod> buildCustomerRespone() {
		
		List<TransactionPeriod> transacationPeriods = new ArrayList<TransactionPeriod>();
		TransactionPeriod transacationPeriod1 = new TransactionPeriod();
		transacationPeriod1.setCustomers(getMonthsForCustomerMonth1());
		transacationPeriod1.setTransactionsMonth("January");
		transacationPeriods.add(transacationPeriod1);
		
		TransactionPeriod transacationPeriod2 = new TransactionPeriod();
		transacationPeriod2.setCustomers(getMonthsForCustomerMonth2());
		transacationPeriod2.setTransactionsMonth("February");
		transacationPeriods.add(transacationPeriod2);
		
		TransactionPeriod transacationPeriod3 = new TransactionPeriod();
		transacationPeriod3.setCustomers(getMonthsForCustomerMonth3());
		transacationPeriod3.setTransactionsMonth("March");
		transacationPeriods.add(transacationPeriod3);
		
		transacationPeriods.forEach(transacationPeriod -> calculateRewards(transacationPeriod));
		
		return transacationPeriods;
		
	}

	private void calculateRewards(TransactionPeriod transacationPeriod) {
		transacationPeriod.getCustomers().forEach(customer -> {
			customer.getTransactions().forEach(transaction -> {
				int rewards = 0;
				if(transaction.getDollersSpent() > VALUE_HUNDRAD ) {
					rewards += (transaction.getDollersSpent() - VALUE_HUNDRAD) * 2;
				} else if(transaction.getDollersSpent() > VALUE_FIFTY && transaction.getDollersSpent() <= VALUE_HUNDRAD) {
					rewards += (transaction.getDollersSpent() - VALUE_FIFTY) * 1;
				}
				customer.setCustomerTotalRewards(customer.getCustomerTotalRewards() + rewards);
				transacationPeriod.setTotalMonthlyRewards(transacationPeriod.getTotalMonthlyRewards() + rewards);
			});
		});
	}
	
	private List<Customer> getMonthsForCustomerMonth1() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer1 = new Customer();
		customer1.setCustomerName("James");
		customer1.setTransactions(getTransactions(Arrays.asList(120, 50, 230)));
		customers.add(customer1);
		
		Customer customer2 = new Customer();
		customer2.setCustomerName("Mike");
		customer2.setTransactions(getTransactions(Arrays.asList(180, 110, 80)));
		customers.add(customer2);
		
		Customer customer3 = new Customer();
		customer3.setCustomerName("Chris");
		customer3.setTransactions(getTransactions(Arrays.asList(60, 340, 170)));
		customers.add(customer3);
		
		return customers;
	}
	
	private List<Customer> getMonthsForCustomerMonth2() {
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer1 = new Customer();
		customer1.setCustomerName("James");
		customer1.setTransactions(getTransactions(Arrays.asList(105, 130, 60)));
		customers.add(customer1);
		
		Customer customer2 = new Customer();
		customer2.setCustomerName("Mike");
		customer2.setTransactions(getTransactions(Arrays.asList(150, 80, 210)));
		customers.add(customer2);
		
		Customer customer3 = new Customer();
		customer3.setCustomerName("Chris");
		customer3.setTransactions(getTransactions(Arrays.asList(85, 240, 155)));
		customers.add(customer3);
		
		return customers;
	}
	
	private List<Customer> getMonthsForCustomerMonth3() {
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer1 = new Customer();
		customer1.setCustomerName("James");
		customer1.setTransactions(getTransactions(Arrays.asList(80, 150, 170)));
		customers.add(customer1);
		
		Customer customer2 = new Customer();
		customer2.setCustomerName("Mike");
		customer2.setTransactions(getTransactions(Arrays.asList(130, 110, 220)));
		customers.add(customer2);
		
		Customer customer3 = new Customer();
		customer3.setCustomerName("Chris");
		customer3.setTransactions(getTransactions(Arrays.asList(160, 40, 190)));
		customers.add(customer3);
		
		return customers;
	}

	private List<Transaction> getTransactions(List<Integer> spentAmount) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		spentAmount.forEach(amount -> transactions.add(new Transaction(amount)));
		return transactions;
	}
}
