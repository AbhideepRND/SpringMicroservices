package com.in28minutes.microsevices.dto;

public class LimitConfiguration {

	private int minimun;
	private int maximum;

	protected LimitConfiguration() {
	}

	public LimitConfiguration(int minimun, int maximum) {
		super();
		this.minimun = minimun;
		this.maximum = maximum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimun() {
		return minimun;
	}

	public void setMinimun(int minimun) {
		this.minimun = minimun;
	}

}
