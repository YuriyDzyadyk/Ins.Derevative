package com.task.view;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.task.derivative.Derivative;
import com.task.derivative.WriteReadDerivative;
import com.task.insuranceCommitments.Anket;

/**
 * class Menu
 */

public class Menu {
	static Logger logger = Logger.getLogger(Menu.class.getName());
	Derivative insuranceList = new Derivative();
	WriteReadDerivative file = new WriteReadDerivative();
	Anket anket;

	public Menu(Anket anket) {
		this.anket = anket;
	}

	public void displayChoiceList() {
		for (MenuCommands c : MenuCommands.values()) {
			System.out.println(c.getCode() + " " + c);
		}
	}

	public void runMenu() {
		boolean success = false;
		int choice = 999;
		while (!success) {
			System.out.println("To create derivative select apropriate option");
			displayChoiceList();
			Scanner sc = new Scanner(System.in);
			try {
				choice = sc.nextInt();
				runMenuOptions(choice);
				success = true;

			} catch (Exception e) {
				logger.warn("Error: " + e.getMessage() + " in displayChoiceList method \nChosen not correct variant");
			}
		}

	}

	public void runMenuOptions(int FirstChoice) {
		MenuCommands command = MenuCommands.get(FirstChoice);
		// System.out.println("You chose '" + command.getMessage() + "'");
		switch (command) {
		case CREATE: {
			insuranceList.creatingOfInsuranceCommitment(anket);
			System.out.println("To create new one press 1");
			runMenu();
			break;
		}
		case CALCULATE_PRICE: {
			if (!insuranceList.isEmpty()) {
				insuranceList.calculatePrice();
			}
			System.out.println("To create new one press 1, or choose another option");
			runMenu();
			break;
		}
		case DELETE: {
			if (!insuranceList.isEmpty()) {
				insuranceList.getDerivative().forEach(System.out::println);
				insuranceList.deleteCommitment();
			}
			System.out.println("To create new one press 1, or choose another option");
			runMenu();
			break;
		}
		case FIND: {
			insuranceList.find();
			System.out.println("To create new one press 1");
			runMenu();
			break;
		}
		case READE_FROM_FILE: {
			insuranceList = file.readFile(insuranceList);
			insuranceList.getDerivative().forEach(System.out::println);
			System.out.println("To create new one press 1");
			runMenu();
			break;
		}
		case SORT: {
			if (!insuranceList.isEmpty()) {
				insuranceList.sort();
			}
			System.out.println("To create new one press 1, or choose another option");
			runMenu();
			break;
		}
		case EXIT: {
			if (file.isWrite()) {
				file.WriteToFile(insuranceList);

			}

			System.exit(0);
			break;
		}
		}
	}

}
