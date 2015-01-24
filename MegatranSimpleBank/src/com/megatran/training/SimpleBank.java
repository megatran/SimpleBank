package com.megatran.training;

public class SimpleBank {
	public static void main (String[] args) {
		SimpleBank bank = new SimpleBank();
		bank.printWelcomeMsg()
	}
	
	private void printWelcomeMsg() {
		System.out.println("Welcome to Megatran Banking...");
		printHelpMenu();
	}
	
	private void printHelpMenu() {
		System.out.println("You can do the following operations...");
		System.out.println("open <amount> - )
	}
}
