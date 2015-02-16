package com.megatran.training;

public class BankAccount {

	private int accountNumber;
	private double balance;
	
	public BankAccount(int accNum, double initialDeposit) {
		this.accountNumber = accNum;
		this.balance = initialDeposit;
		
	}
	public void deposit(double howMuch) {
		this.balance += howMuch;
	}
	public void withdraw(double howMuch) {
		this.balance -= howMuch;
	}
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
}
