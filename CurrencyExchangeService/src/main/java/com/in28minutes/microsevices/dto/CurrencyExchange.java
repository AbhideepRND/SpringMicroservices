package com.in28minutes.microsevices.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {

	@Id
	private Integer currencyId;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal currencyRate;
	private transient int port;

	public CurrencyExchange() {
	}

	public CurrencyExchange(Integer currencyId, String fromCurrency, String toCurrency, BigDecimal currencyRate) {
		super();
		this.currencyId = currencyId;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.currencyRate = currencyRate;
	}

	public Integer getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public BigDecimal getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(BigDecimal currencyRate) {
		this.currencyRate = currencyRate;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
