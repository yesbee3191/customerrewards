package com.customer.rewards.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.rewards.builder.CustomerResponseBuilder;
import com.customer.rewards.model.TransactionPeriod;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerRewardsServiceTest {

	@Mock
	private CustomerResponseBuilder customerResponseBuilder;
	
	@Mock
	private TransactionPeriod transacationPeriod;
	
	@InjectMocks
	CustomerRewardsService customerRewardsService;
	
	List<TransactionPeriod> transacationPeriods;
	
	@Before
	public void init() {
        MockitoAnnotations.initMocks(this);
        
        transacationPeriods = Arrays.asList(transacationPeriod);
    }
	
	@Test
	public void testGetCalculateMonthlyRewards() throws Exception {
		
		when(customerResponseBuilder.buildCustomerRespone()).thenReturn(transacationPeriods);

		List<TransactionPeriod> resultMonths = customerRewardsService.getCalculateMonthlyRewards();
		
		assertNotNull(resultMonths);
		assertEquals(resultMonths.size(), 1);
		
		verify(customerResponseBuilder).buildCustomerRespone();
		
		
	}
	
	@Test
	public void testGetCalculateMonthlyRewardsIfNoResults()  throws Exception {
		
		when(customerResponseBuilder.buildCustomerRespone()).thenReturn(null);

		List<TransactionPeriod> resultMonths = customerRewardsService.getCalculateMonthlyRewards();
		
		assertNull(resultMonths);
		
		verify(customerResponseBuilder).buildCustomerRespone();
		
		
	}
}
