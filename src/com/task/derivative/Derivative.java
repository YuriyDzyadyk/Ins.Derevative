package com.task.derivative;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.task.insuranceCommitments.AbstractFactory;
import com.task.insuranceCommitments.Anket;
import com.task.insuranceCommitments.InsuranceCommitment;
import com.task.insuranceCommitments.SpeciesFactory;
/**
 * Derivative 
 */
public class Derivative implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5969779860158640989L;
	static Logger logger = Logger.getLogger(Derivative.class.getName());
	private List<InsuranceCommitment> derivative;
	 

	public Derivative() {
		derivative = new ArrayList<>();
	}

	public void addCommitment(InsuranceCommitment commitment) {
		derivative.add(commitment);
		logger.info(derivative.size());
	}

	/**
	 * method creatingOfInsuranceCommitment create  InsuranceCommitment and add to Derivative
	 */
	public void creatingOfInsuranceCommitment(Anket anket) {
		AbstractFactory abstractFactory = new AbstractFactory();
		SpeciesFactory propertySpeciesFactory;
		SpeciesFactory personalSpeciesFactory;
		InsuranceCommitment commitment = null;
		boolean success = false;
		String choice = "";
		int months = 0;
		String[] chooser = new String[0];
		while (!success) {
			System.out.println(
					"Please type what you want to insure (car, house, health, life) and number of monthes you want insure. Or if you want exit - \"exit\"");
			
			try {
			Scanner sc = new Scanner(System.in);
			String questions = sc.nextLine();
//			do{
//				
			chooser = questions.split(" ");
//			
//				}while(!isCorrect(chooser));
		
				choice = chooser[0];
				months = Integer.parseInt(chooser[1]);
				switch (choice) {
				case "car": {
					propertySpeciesFactory = abstractFactory.getSpeciesFactory("property", anket);
					commitment = propertySpeciesFactory.getInsuranceCommitment("car", anket, months);
					success = true;
					break;
				}
				case "health": {
					personalSpeciesFactory = abstractFactory.getSpeciesFactory("personal", anket);
					commitment = personalSpeciesFactory.getInsuranceCommitment("health", anket, months);
					success = true;
					break;
				}
				case "house": {
					propertySpeciesFactory = abstractFactory.getSpeciesFactory("property", anket);
					commitment = propertySpeciesFactory.getInsuranceCommitment("house", anket, months);
					success = true;
					break;
				}
				case "life": {
					personalSpeciesFactory = abstractFactory.getSpeciesFactory("personal", anket);
					commitment = personalSpeciesFactory.getInsuranceCommitment("life", anket, months);
					success = true;
					break;
				}
				case "exit": {
					System.exit(0);
					break;
				}
				}
				if (!isCommitmentExist(commitment)) {
					addCommitment(commitment);
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				logger.warn("Error: " + e.getMessage()
						+ " in creatingOfInsuranceCommitment method \nChosen not correct variant");
			}
		}
	}


	public boolean isCorrect(String[] chooser){
		if (chooser.length == 2) {

		} else {
			logger.info("wrong entry. Try again");
			return false;
		}
		try {
			Integer.parseInt(chooser[1]);
			return true;
		} catch (NumberFormatException e) {
			logger.info("wrong entry for question 2. Try again");
			return false;
		}
		}
	
	/**
	 * method isCommitmentExist check if  Commitment Exist
	 */
	public boolean isCommitmentExist(InsuranceCommitment commitment) {
		if (derivative.contains(commitment)) {
			System.out.println(
					"This type of insurance is already Exist. \n To overwrite it press \"Y\" \n To leave both press \"N\" \n To cancel this action press \"C\" ");
			Scanner sc = new Scanner(System.in);
			boolean success = false;
			while (!success) {
				try {
					String keyboard = sc.nextLine();
					if ("y".equalsIgnoreCase(keyboard)) {
						derivative.remove(commitment);
						System.out.println("Done");
						logger.info("Sise of derivative is " + derivative.size());
						success = true;
						return true;
					} else if ("n".equalsIgnoreCase(keyboard)) {
						logger.info("Sise of derivative is " + derivative.size());
						success = true;
						return false;
					} else if ("c".equalsIgnoreCase(keyboard)) {
						logger.info("Sise of derivative is " + derivative.size());
						success = true;
						return true;
					} else {
						logger.info("wrong variant ");
						System.out.println("Please choose variant");
					}

				} catch (Exception e) {
					success = false;
					System.out.println("Please choose variant");
					logger.warn(
							"Error: " + e.getMessage() + " in isCommitmentExist method \nChosen not correct variant");
				}

			}
		}
		return false;
	}

	public boolean isEmpty() {
		if (derivative.size() != 0) {
			return false;
		} else {
			System.out.println("Yuor derivative is empty");
			return true;
		}

	}

	public List<InsuranceCommitment> getDerivative() {
		return derivative;
	}
	
	

	public void calculatePrice() {
		int totalPrice = 0;
		for (InsuranceCommitment insuranceCommitment : derivative) {
			totalPrice = totalPrice + insuranceCommitment.getPrice();
		}
		System.out.println(totalPrice);
	}
	
	/**
	 * method deleteCommitment delete Commitment
	 */

	public void deleteCommitment() {

		System.out.println("Please type what you want to delete (car, house, health, life)");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		try {
			boolean isFound = false;
			for (InsuranceCommitment insuranceCommitment : derivative) {
				if (insuranceCommitment.getType().equals(choice)) {
					isFound = true;
					derivative.remove(insuranceCommitment);
					logger.info("Done, now size of derivative is " + derivative.size());
				}
			}
			if (!isFound) {
				System.out.println("There is no such commitment");
			}
		} catch (Exception e) {
			logger.warn("Error: " + e.getMessage() + "in deleteCommitment method \nChosen not correct variant");
		}
	}

	public void sort() {
		// insuranceList.getDerivative().forEach(System.out::println);
		derivative.sort((arg0, arg1) -> arg1.getRiskLevel() - arg0.getRiskLevel());
		System.out.println();
		derivative.forEach(System.out::println);
	}

	public void find() {
		// TODO Auto-generated method stub
		System.out.println("Please type what you want to find (car, house, health, life)");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		try {
			boolean isFound = false;
			for (InsuranceCommitment insuranceCommitment : derivative) {
				if (insuranceCommitment.getType().equals(choice)) {
					System.out.println(insuranceCommitment);
					isFound = true;
				}
			}
			if (!isFound) {
				System.out.println("There is no such commitment");
			}
		} catch (Exception e) {
			logger.warn("Error: " + e.getMessage() + "in find method \nChosen not correct variant");
		}
	}
}
