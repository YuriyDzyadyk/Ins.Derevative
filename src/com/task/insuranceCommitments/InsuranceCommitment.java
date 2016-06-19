package com.task.insuranceCommitments;

import java.io.Serializable;

/**
 * class InsuranceCommitment
 */

public abstract class InsuranceCommitment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2313496531922615857L;
	private String type;
	private int price;
	private int months;
	private int riskLevel;

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

	public int getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + months;
		result = prime * result + price;
		long temp;
		temp = Double.doubleToLongBits(riskLevel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InsuranceCommitment other = (InsuranceCommitment) obj;
		if (months != other.months)
			return false;
		if (price != other.price)
			return false;
		if (Double.doubleToLongBits(riskLevel) != Double.doubleToLongBits(other.riskLevel))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
