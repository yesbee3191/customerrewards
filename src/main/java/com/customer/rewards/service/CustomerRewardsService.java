package com.customer.rewards.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.rewards.builder.CustomerResponseBuilder;
import com.cutomer.rewards.model.TransactionPeriod;

@Service
public class CustomerRewardsService {
	
	@Autowired
	private CustomerResponseBuilder customerResponseBuilder; 
	
	public List<TransactionPeriod> getCalculateMonthlyRewards() {
		
		
		return customerResponseBuilder.buildCustomerRespone();
	}

}
