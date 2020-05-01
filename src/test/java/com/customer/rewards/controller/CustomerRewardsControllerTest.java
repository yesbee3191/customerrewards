package com.customer.rewards.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.customer.rewards.service.CustomerRewardsService;
import com.cutomer.rewards.controller.CustomerRewardsController;
import com.cutomer.rewards.model.TransactionPeriod;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRewardsControllerTest {

	private MockMvc mockMvc;

	@Mock
	private CustomerRewardsService customerRewardsService;

	@Mock
	private ResponseEntity<List<TransactionPeriod>> response;

	@Mock
	private TransactionPeriod transacationPeriod;

	@InjectMocks
	CustomerRewardsController customerRewardsController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerRewardsController).build();

	}

	@Test
	public void testGetMonthlyTransactionRewards() throws Exception {
		List<TransactionPeriod> transacationPeriods = Arrays.asList(new TransactionPeriod());

		when(customerRewardsService.getCalculateMonthlyRewards()).thenReturn(transacationPeriods);
		this.mockMvc.perform(get("/customer/rewards")).andExpect(status().isOk());

	}

	@Test
	public void testGetMonthlyTransactionRewardsIfResponseNull() throws Exception {
		List<TransactionPeriod> months = Arrays.asList();
		when(customerRewardsService.getCalculateMonthlyRewards()).thenReturn(months);
		this.mockMvc.perform(get("/customer/rewards")).andExpect(status().isNotFound());
		
	}
}
