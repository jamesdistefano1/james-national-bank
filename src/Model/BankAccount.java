package Model;

import java.util.Date;

abstract class BankAccount {
	static private int numberOfAccounts;
	private final int accountNumber;
	private double balance;
	private final String accountHolder;
	private final Date accountOpened;
	private int withdrawsLeft;
	
	public BankAccount(String name) {
		this.accountNumber = ++numberOfAccounts;
		this.balance = 0;
		this.accountHolder = name;
		this.accountOpened = new Date();
	}
	
	public BankAccount(String name, double initialBalance) {
		this.accountNumber = ++numberOfAccounts;
		this.balance = initialBalance;
		this.accountHolder = name;
		this.accountOpened = new Date();
	}

	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public static void setNumberOfAccounts(int numberOfAccounts) {
		BankAccount.numberOfAccounts = numberOfAccounts;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public synchronized double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public Date getAccountOpened() {
		return accountOpened;
	}

	public int getWithdrawsLeft() {
		return withdrawsLeft;
	}

	public void setWithdrawsLeft(int withdrawsLeft) {
		this.withdrawsLeft = withdrawsLeft;
	}

	public synchronized void deposit(double depositAmount) {
		try {
			Thread.sleep(300);
		}
		catch(InterruptedException e) {
			e.getMessage();
		}
		balance += depositAmount;
		printReceipt();
	}
	
	public synchronized void withdraw(double withdrawalAmount) {
		while (withdrawalAmount > balance) {
	        try {
	           wait(); // wait for funds
	        } catch (InterruptedException ie) {
	           System.err.println(ie.getMessage());
	        }
	    }
		if (balance > 0) {
			balance -= withdrawalAmount;
			printReceipt();
		}
		else System.out.println("ERROR: You are way too broke for that!");
	}

	public void printReceipt() {
		System.out.println(getAccountHolder() + "\'s balance is " + getBalance() + "0 on " + accountOpened.toString());
		
	}
}

