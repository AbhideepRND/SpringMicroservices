package com.in28minutes.microsevices.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.microsevices.dto.CurrencyConversionBean;

//@FeignClient(name="currency-exchange-service") - Previous config when API gateway not introduce 
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {

	
	//@GetMapping(path="/from/{fromCurrency}/to/{toCurrency}") -- Previous config when API gateway not introduce 
	@GetMapping(path="currency-exchange-service/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyConversionBean getCurrencyExchange(@PathVariable("fromCurrency") String fromCurrency,
			@PathVariable("toCurrency") String toCurrency);
}
