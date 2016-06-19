package com.task.insuranceCommitments;

import java.io.Serializable;

public class HealthInsurance extends InsuranceCommitment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2017578720033541098L;
	private String type;
	private int riskLevel;
	private int price;
	private int months;

	public HealthInsurance(String type, int riskLevel, int months) {
		this.type = type;
		this.months = months;
		this.riskLevel = riskLevel * 3;
		price = (int) (7 * months * riskLevel);
	}

	public int getRiskLevel() {
		return riskLevel;
	}

	public int getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "HealthInsurance [type=" + type + ", riskLevel=" + riskLevel + ", price=" + price + "]";
	}

}
