package Model;

import java.util.Date;

abstract class BankAccount {
	static private int numberOfAccounts;
	private int accountNumber;
	private double balance;
	private String accountHolder;
	private Date accountOpened;
	private int withdrawsLeft;
	
	public BankAccount(String name) {
		this.accountNumber = ++numberOfAccounts;
		this.balance = 0;
		this.accountHolder = name;
		this.accountOpened = new Date();
	}
	
	public BankAccount(String name, double initialBalance) {
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

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
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

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public Date getAccountOpened() {
		return accountOpened;
	}

	public void setAccountOpened(Date accountOpened) {
		this.accountOpened = accountOpened;
	}

	public int getWithdrawsLeft() {
		return withdrawsLeft;
	}

	public void setWithdrawsLeft(int withdrawsLeft) {
		this.withdrawsLeft = withdrawsLeft;
	}

	public synchronized void deposit(double d) {
		try {
			Thread.sleep(300);
		}
		catch(InterruptedException e) {
			e.getMessage();
		}
		balance += d;
		printReceipt();
	}
	
	public synchronized void withdraw(double w) {
		while (w > balance) {
	        try {
	           wait(); // wait for funds
	        } catch (InterruptedException ie) {
	           System.err.println(ie.getMessage());
	        }
	    }
		if (balance > 0) {
			balance -= w;
			printReceipt();
		}
		else System.out.println("ERROR: You are way too broke for that!");
	}

	public void printReceipt() {
		System.out.println(getAccountHolder() + "\'s balance is " + getBalance() + "0 on " + accountOpened.toString());
		
	}
}

