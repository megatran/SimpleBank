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
			
			if (commandStr.trim().startsWith("open")) {
				int accNum = bank.openNewAccount(commandStr);
				System.out.println("\tAccount opened with number: " + accNum);
				System.out.println("\nPlease note the account number for later use.");
			}
			if (commandStr.trim().startsWith("deposit")) {
				String params = commandStr.substring(8);
				int accNum = bank.extractAccountNumber(params);
				double amount = bank.extractAccountNumber(params);
				double balance = bank.deposit(accNum, amount);
				System.out.println("\tDeposited " + amount + " in account number " + accNum);
				System.out.println("\tCurrent balance in the account is $" + balance);
			}
			
			if (commandStr.trim().startsWith("withdraw")) {
				String params = commandStr.substring(9);
				int accNum = bank.extractAccountNumber(params);
				double amount = bank.extractAccountNumber(params);
				double balance = bank.withdraw(accNum, amount);
				System.out.println("\tDispensed " + amount + " from account number " + accNum);
				System.out.println("\tCurrent balance in the account is $" + balance);
			}
			if (commandStr.trim().startsWith("balance")) {
				int accNum = Integer.parseInt(commandStr.substring(8));
				BankAccount acc = bank.find(accNum);
				System.out.println("\tAccount Number: " + accNum + " currently has $" + acc.getBalance());
			}
			
		} while(true);
		System.out.println("Thanks for using the system.");
	}
	
	private double withdraw(int accNum, double amount) {
		BankAccount acc = find(accNum);
		acc.withdraw(amount);
		return acc.getBalance();
	}
	
	private int extractAccountNumber(String params) {
		return Integer.parseInt(params.substring(params.indexOf(' ')+1).trim());
	}
	
	private double deposit(int accountNumber, double amount) {
		BankAccount acc = find(accountNumber);
		acc.deposit(amount);
		return acc.getBalance();
	}
	
	
	private int openNewAccount(String commandStr) {
		double initialDepositAmount = Double.parseDouble(commandStr.substring(5));
		BankAccount bankAccount = new BankAccount (generateAccountNumber(), initialDepositAmount);
		storeAccount (bankAccount);
		return bankAccount.getAccountNumber();
		
	}
	
	private BankAccount find(int accNum) {
		for (int i=0; i < accounts.length; i++) {
			if (accounts[i] != null && accNum == accounts[i].getAccountNumber()) {
				return accounts[i];
			}
		}
		return null;
	}
	
	public void storeAccount(BankAccount acc) {
		int i = 0;
		//search for empty slot
		while (i < accounts.length && accounts[i] != null) {
			i++;
		}
		if (i == accounts.length-1) {
			System.out.println("Storage is full...");
			return;
		}
		accounts[i] = acc;
	}
	private static int generateAccountNumber() {
		return ACC_NUM_GENERATOR++;
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
