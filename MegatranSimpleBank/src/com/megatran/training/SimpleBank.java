package com.megatran.training;

import java.util.Scanner;

public class SimpleBank {
	
	private static int ACC_NUM_GENERATOR = 10001;
	// array of bank account of size 10 -> you can only open upto 10 accounts
	private static BankAccount[] accounts = new BankAccount[10]; 
	
	public static void main (String[] args) {
		SimpleBank bank = new SimpleBank();
		bank.printWelcomeMsg();
		Scanner scanner = new Scanner (System.in);
		do {
			bank.printPrompt();
			String commandStr = scanner.nextLine();
			if (bank.shouldQuit(commandStr))
				break;
			if (commandStr.trim().equalsIgnoreCase("help")) {
				bank.printHelpMenu();
			}
		} while(true);
		System.out.println("Thanks for using the system.");
	}
	
	private void printPrompt() {
		System.out.print(">");
	}
	
	private void printWelcomeMsg() {
		System.out.println("Welcome to Megatran Banking...");
		printHelpMenu();
	}
	
	private void printHelpMenu() {
		System.out.println("You can do the following operations...");
		System.out.println("open <amount> - to open a new account." );
		System.out.println("\tAn accound number will be printed which you must remember. ");
		System.out.println("close <accountNumber> - to close an existing account. ");
		System.out.println("deposit <accountNumber> <amount> - to deposit money in an account");
		System.out.println("withdraw <accountNumber> <amount> - to withdraw money from an account");
		System.out.println("balance <accountNumber> - for balance enquiry");
		System.out.println("help - to print this help");
		System.out.println("quit - to close the application");
	}
	private boolean shouldQuit(String command) {
		return command.trim().equalsIgnoreCase("quit");
	}
}
