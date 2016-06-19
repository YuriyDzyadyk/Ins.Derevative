package com.task.insuranceCommitments;

import java.io.Serializable;

public class LifeInsurance extends InsuranceCommitment implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = -7562515075380370704L;
	private String type;
	private int riskLevel;
	private int months;
	private int price;

	public LifeInsurance(String type, int riskLevel, int months) {
		super();
		this.months = months;
		this.type = type;
		this.riskLevel = riskLevel * 4;
		price = (int) (6 * months * riskLevel);
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
		return "LifeInsurance [type=" + type + ", riskLevel=" + riskLevel + ", months=" + months + ", price=" + price
				+ "]";
	}

}
