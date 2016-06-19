package com.task.view;

import com.task.insuranceCommitments.Anket;

/**
 * @author Dziadyk Yuriy
 * @version 1
 */
public class Main {

	public static void main(String[] args) {

		Anket anket = new Anket();
		anket.questionnaire();
		Menu menu = new Menu(anket);
		menu.runMenu();
	}

}
