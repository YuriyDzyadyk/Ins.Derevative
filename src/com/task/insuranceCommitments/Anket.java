package com.task.insuranceCommitments;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * 
 * class for "insurance" questions and answers
 *
 */

public class Anket {

	private int age;
	private boolean isConvict;
	private boolean isWorker;
	private boolean isChronicDiseases;
	private boolean isRiskyPerson;
	static Logger logger = Logger.getLogger(Anket.class.getName());

	public int getAge() {
		return age;
	}

	public boolean isWorker() {
		return isWorker;
	}

	public boolean isChronicDiseases() {
		return isChronicDiseases;
	}

	public boolean isConvict() {
		return isConvict;
	}

	public boolean isRiskyPerson() {
		return isRiskyPerson;
	}

	public void questionnaire() {
		System.out.println(
				"Please answer some questions below (put age and answers yes('Y') or no('N') in one line, by space)"
						+ "\n Your Age \n Do you have a work \n Do you have Chronic Diseases \n Do you was imprisoned \n Do you like risk");
		String[] answers = new String[0];
		Scanner sc = new Scanner(System.in);
		do {
			String questions = sc.nextLine();
			answers = questions.split(" ");

		} while (dataProcessing(answers));
	}

	private boolean dataProcessing(String[] answesProcessing) {
		if (answesProcessing.length == 5) {

		} else {
			logger.info("wrong entry. Try again");
			return true;
		}
		try {

			age = Integer.parseInt(answesProcessing[0]);
		} catch (NumberFormatException e) {
			logger.info("wrong entry for question 1. Try again");
			return true;
		}
		if (answesProcessing[1].equalsIgnoreCase("y")) {
			isWorker = true;
		} else if (answesProcessing[1].equalsIgnoreCase("n")) {
			isWorker = false;
		} else {
			logger.info("wrong entry for question 2. Try again");
			return true;
		}
		if (answesProcessing[2].equalsIgnoreCase("y")) {
			isChronicDiseases = true;
		} else if (answesProcessing[2].equalsIgnoreCase("n")) {
			isChronicDiseases = false;
		} else {
			logger.info("wrong entry for question 3. Try again");
			return true;
		}
		if (answesProcessing[3].equalsIgnoreCase("y")) {
			isConvict = true;
		} else if (answesProcessing[3].equalsIgnoreCase("n")) {
			isConvict = false;
		} else {
			logger.info("wrong entry for question 4. Try again");
			return true;
		}
		if (answesProcessing[4].equalsIgnoreCase("y")) {
			isRiskyPerson = true;
			return false;
		} else if (answesProcessing[4].equalsIgnoreCase("n")) {
			isRiskyPerson = false;
			return false;
		} else {
			logger.info("wrong entry for question 5. Try again");

			return true;
		}

	}

	@Override
	public String toString() {
		return "Anket [age=" + age + ", isConvict=" + isConvict + ", isWorker=" + isWorker + ", isChronicDiseases="
				+ isChronicDiseases + ", isRiskyPerson=" + isRiskyPerson + "]";
	}

}
