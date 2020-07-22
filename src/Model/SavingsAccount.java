package Model;

public class SavingsAccount extends BankAccount {
	private double interestRate;

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public SavingsAccount(String name) {
		super(name);
	}

	public SavingsAccount(String name, double initialBalance) {
		super(name, initialBalance);
	}
	
	public void compoundInterest() {
		double current = getBalance();
		current *= interestRate;
		setBalance(current);
	}

}
