package Model;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(String name, double initialBalance) {
		super(name, initialBalance);
		// TODO Auto-generated constructor stub
	}
	
	public void writeCheck() {
		System.out.println("writing check");
	}

}
