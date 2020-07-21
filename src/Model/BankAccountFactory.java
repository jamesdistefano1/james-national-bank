package Model;

public class BankAccountFactory {
	
	
	public BankAccount getAccount(String account, String name) {
		if(account.equalsIgnoreCase("checkingaccount") || account.equalsIgnoreCase("checking account")) {
			return new CheckingAccount(name);
		}
		else if(account.equalsIgnoreCase("savingsaccounts") || account.equalsIgnoreCase("savings account")) {
			return new SavingsAccount(name);
		}
		else{
			System.out.println("Please indicate savings or checking account");
			return null;
		}
	}

	public BankAccount getAccount(String account, String name, double balance) {
		if(account.equalsIgnoreCase("checkingaccount") || account.equalsIgnoreCase("checking account")) {
			return new CheckingAccount(name, balance);
		}
		else if(account.equalsIgnoreCase("savingsaccounts") || account.equalsIgnoreCase("savings account")) {
			return new SavingsAccount(name, balance);
		}
		else{
			System.out.println("Please indicate savings or checking account");
			return null;
		}
	}

}
