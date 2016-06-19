package com.task.insuranceCommitments;

public class PropertyInsuranceFactory extends SpeciesFactory {
	private Anket anket;

	public int setRiskLevel() {
		int riskLevel = 1;
		if (anket.isWorker()) {
			riskLevel = riskLevel + 2;

		}
		if (anket.isConvict()) {
			riskLevel = riskLevel + 1;
		}

		return riskLevel;
	}

	@Override
	public InsuranceCommitment getInsuranceCommitment(String insuranceType, Anket anket, int months) {
		this.anket = anket;
		int riskLevel = setRiskLevel();
		switch (insuranceType) {
		case "car": {
			return new CarInsurance("car", riskLevel, months);
		}
		case "house": {
			return new HouseInsurance("house", riskLevel, months);
		}
		}
		return null;

	}

}
