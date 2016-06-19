package com.task.insuranceCommitments;

import java.io.Serializable;

public class HouseInsurance extends InsuranceCommitment implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 450385967336819538L;
	private String type;
	private int riskLevel;
	private int months;
	private int price;

	public HouseInsurance(String type, int riskLevel, int months) {
		super();
		this.type = type;
		this.months = months;
		this.riskLevel = riskLevel;
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
		return "HouseInsurance [type=" + type + ", riskLevel=" + riskLevel + ", months=" + months + ", price=" + price
				+ "]";
	}

}
