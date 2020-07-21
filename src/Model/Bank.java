package Model;
import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> accounts;
	private static int numberOfBanks;
	private int routingNumber;
	
	public Bank() {
		this.accounts = new ArrayList<BankAccount>();
		this.routingNumber = ++numberOfBanks;
	}
}
