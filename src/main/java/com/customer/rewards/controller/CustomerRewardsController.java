package com.customer.rewards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.customer.rewards.exception.CustomerRewardException;
import com.customer.rewards.exception.ErrorResponse;
import com.customer.rewards.service.CustomerRewardsService;
import com.customer.rewards.model.TransactionPeriod;

@RestController
public class CustomerRewardsController {
	
	@Autowired
	private CustomerRewardsService customerRewardsService;
	
	@GetMapping("/rewards")
	@ExceptionHandler(CustomerRewardException.class)
	public ResponseEntity<?> getMonthlyTransactionRewards() {
		
		System.out.println("I am here");
		List<TransactionPeriod> transacationPeriods = customerRewardsService.getCalculateMonthlyRewards();
		
		if(CollectionUtils.isEmpty(transacationPeriods)) {
			  ErrorResponse errorResponse = new ErrorResponse();
	          errorResponse.setMessage("Record not found");
	          return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(transacationPeriods, HttpStatus.OK); 
		
	}

}
