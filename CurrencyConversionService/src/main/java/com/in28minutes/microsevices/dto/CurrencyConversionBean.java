package com.in28minutes.microsevices.dto;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private Integer currencyId;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal currencyRate;
	private BigDecimal quantity;
	private transient int port;
	
	public CurrencyConversionBean() {
		// TODO Auto-generated constructor stub
	}

	public CurrencyConversionBean(Integer currencyId, String fromCurrency, String toCurrency, BigDecimal currencyRate,
			BigDecimal quantity) {
		super();
		this.currencyId = currencyId;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.currencyRate = currencyRate;
		this.quantity = quantity;
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

	public BigDecimal getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(BigDecimal currencyRate) {
		this.currencyRate = currencyRate;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	
	

}
