package com.task.insuranceCommitments;

import java.io.Serializable;
/**
 * 
 * class Car Insurance
 *
 */

public class CarInsurance extends InsuranceCommitment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7344351015803929313L;
	private String type;
	private int riskLevel;
	private int months;
	private int price;

	public CarInsurance(String type, int riskLevel, int months) {
		this.type = type;
		this.months = months;
		this.riskLevel = riskLevel * 2;
		price = (int) (7 * months * riskLevel);
	}

	public String getType() {
		return type;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public int getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(int riskLevel) {
		this.riskLevel = riskLevel;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "CarInsurance [type=" + type + ", riskLevel=" + riskLevel + ", months=" + months + ", price=" + price
				+ "]";
	}

}
