package com.customer.rewards.builder;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.rewards.model.Customer;
import com.customer.rewards.model.Transaction;
import com.customer.rewards.model.TransactionPeriod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class CustomerResponseBuilderTest {

	@Mock
	private Customer customer;
	
	@Mock
	private TransactionPeriod transacationPeriod;
	
	@Mock
	private Transaction transaction;
	
	@InjectMocks
	CustomerResponseBuilder customerResponseBuilder;
	
	List<TransactionPeriod> transacationPeriods;
	List<Transaction> transactions;
	
	@Before
	public void init() {
        MockitoAnnotations.initMocks(this);
        
        transacationPeriods = Arrays.asList(transacationPeriod);
        transactions = Arrays.asList(transaction);
    }
	
	@Test
	public void testBuildCustomerRespone()  throws Exception {
		
		List<TransactionPeriod> resultMonths = customerResponseBuilder.buildCustomerRespone();
		
		assertNotNull(resultMonths);
		assertEquals(resultMonths.size(), 3);
		
	}

}
