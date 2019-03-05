package com.in28minutes.microsevices.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microsevices.dto.CurrencyExchange;
import com.in28minutes.microsevices.repository.ExchangeValueRepository;


@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private ExchangeValueRepository repo;
	
	@GetMapping(path="/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyExchange getCurrencyExchange(@PathVariable("fromCurrency") String fromCurrency,
			@PathVariable("toCurrency") String toCurrency) {
		
		System.out.println("fromCurrency - "+fromCurrency +"   toCurrency - "+toCurrency);
		CurrencyExchange currencyExchange = repo.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
		currencyExchange.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		logger.info("Response -> {}", currencyExchange);
		return currencyExchange;
		
	}

}
