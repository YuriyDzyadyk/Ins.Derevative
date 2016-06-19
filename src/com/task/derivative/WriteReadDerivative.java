package com.task.derivative;

import java.io.FileInputStream;

/**
 * class Read and Write from file
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.task.view.Menu;

public class WriteReadDerivative {
	static Logger logger = Logger.getLogger(Menu.class.getName());
	
	public boolean isWrite(){
		System.out.println("Do you want to save data? (Yes - 'y', No - 'n')");
		Scanner sc = new Scanner(System.in);
		boolean success = false;
		while (!success) {
			try {
				String keyboard = sc.nextLine();
				if ("y".equalsIgnoreCase(keyboard)) {
					success = true;
					return true;
				}else if("n".equalsIgnoreCase(keyboard)){
					logger.error("Data was not saved ");
					success = true;
					return false;
				}else{
					logger.info("wrong variant ");
					System.out.println("Please choose variant");
				}
			} catch (Exception e) {
				success = false;
				System.out.println("Please choose variant");
				logger.warn("Error: " + e.getMessage()+" in isCommitmentExist method \nChosen not correct variant");
				}
		}
		return false;
	}

	public void WriteToFile(Derivative insuranceList) {
		try{
			FileOutputStream fos = new FileOutputStream("f:\\Y\\fileWithDerevative.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(insuranceList);
			oos.close();
	        fos.close();
	        logger.info("Data saved ");
		}catch(IOException ioe){
			logger.error("Data is saved " +ioe);
			ioe.printStackTrace();
		}

		
	}
	
public Derivative readFile(Derivative insuranceList){
		
		try{
			FileInputStream fis = new FileInputStream("f:\\Y\\fileWithDerevative.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			insuranceList = (Derivative) ois.readObject();
			ois.close();
			
	        fis.close();
			
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
	}
		return insuranceList;
}
}
