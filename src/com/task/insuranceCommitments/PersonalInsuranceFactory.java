package com.task.insuranceCommitments;

public class PersonalInsuranceFactory extends SpeciesFactory {
	private Anket anket;

	public int setRiskLevel() {
		int riskLevel = 2;
		if (anket.isWorker()) {
			riskLevel = riskLevel + 1;
		}
		if (anket.isRiskyPerson()) {
			riskLevel = riskLevel + 2;
		}
		if (anket.isChronicDiseases()) {
			riskLevel = riskLevel + 1;
		}
		if (anket.getAge() > 45) {
			riskLevel = riskLevel + 2;
		}
		return riskLevel;
	}

	@Override
	public InsuranceCommitment getInsuranceCommitment(String insuranceType, Anket anket, int months) {
		this.anket = anket;
		int riskLevel = setRiskLevel();
		switch (insuranceType) {
		case "health": {
			return new HealthInsurance("health", riskLevel, months);
		}
		case "life": {
			return new LifeInsurance("life", riskLevel, months);
		}
		}
		return null;
	}
}