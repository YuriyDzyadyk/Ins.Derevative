package com.task.insuranceCommitments;

public class AbstractFactory {

	public SpeciesFactory getSpeciesFactory(String insuranceType, Anket anket) {
		if ("personal".equals(insuranceType)) {
			return new PersonalInsuranceFactory();
		} else {
			return new PropertyInsuranceFactory();
		}
	}

}
