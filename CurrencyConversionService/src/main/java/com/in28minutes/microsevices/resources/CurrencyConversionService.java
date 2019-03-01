package com.in28minutes.microsevices.resources;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.microsevices.dto.CurrencyConversionBean;
import com.in28minutes.microsevices.proxy.CurrencyExchangeProxy;

/**
 * @author liveyoung
 *
 */
@RestController
public class CurrencyConversionService {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	/**
	 * 	Here we are calling the external service using the rest template provided by spring
	 * 	We can achieve the same with feign api. That provided by in spring-cloud-starter-feign.
	 *  By this we can reduce our coding and make the class readable
	 **/
	@GetMapping(path = "/from/{from}/to/{to}/{amount}")
	public CurrencyConversionBean getConversionValue(@PathVariable("from") String fromCurr,
			@PathVariable("to") String toCurr, @PathVariable("amount") Integer amount) {

		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("fromCurrency", fromCurr);
		hashMap.put("toCurrency", toCurr);

		CurrencyConversionBean body = new RestTemplate()
				.getForEntity("http://localhost:8000/currencyexchange/from/{fromCurrency}/to/{toCurrency}",
						CurrencyConversionBean.class, hashMap)
				.getBody();
		body.setQuantity(body.getCurrencyRate().multiply(BigDecimal.valueOf(amount)));
		return body;
	}
	
	/**
	 * So here in place of create a RestTemplate in controller we use Feign api to call the external services.
	 * @param fromCurrency
	 * @param toCurrency
	 * @param amount
	 * @return
	 */
	@GetMapping(path = "feign/from/{from}/to/{to}/{amount}")
	public CurrencyConversionBean getConversionValueFeign(@PathVariable("from") String fromCurrency,
			@PathVariable("to") String toCurrency, @PathVariable("amount") Integer amount) {

		CurrencyConversionBean currencyExchange = proxy.getCurrencyExchange(fromCurrency, toCurrency);
		currencyExchange.setQuantity(currencyExchange.getCurrencyRate().multiply(BigDecimal.valueOf(amount)));
		return currencyExchange;
	}
	

}
