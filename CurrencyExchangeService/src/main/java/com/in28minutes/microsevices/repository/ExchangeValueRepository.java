package com.in28minutes.microsevices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.microsevices.dto.CurrencyExchange;

public interface ExchangeValueRepository extends JpaRepository<CurrencyExchange, Integer>{

	public CurrencyExchange findByFromCurrencyAndToCurrency(String from, String to);
}
