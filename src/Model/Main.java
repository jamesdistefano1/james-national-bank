package Model;

public class Main {

	public static void main(String[] args) {
		Bank bankOfJames = new Bank();
		BankAccountFactory fact = new BankAccountFactory();
		BankAccount james = fact.getAccount("savings account","james", 1000.0);
		Thread[] users = new Thread[10];
		int[] threadNames = new int[10];
		for(int i = 0; i < users.length; i++) {
			if(i % 2 == 0) users[i] = new Depositer(james);
			else users[i] = new Withdrawer(james);
		}
		for(int i = 0; i < users.length; i++) {
			System.out.println("Starting thread " + users[i].getName());
			users[i].start();
		}
		for(int i = 0; i < users.length; i++) {
			try {
				System.out.println("Joining thread " + users[i].getName());
				users[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
	}
	
	static class Depositer extends Thread{
		BankAccount account;
		Depositer(BankAccount account){
			this.account = account;
		}
		public void run() {
			account.deposit(100);
		}
		
	}
	
	static class Withdrawer extends Thread{
		BankAccount account;
		Withdrawer(BankAccount account){
			this.account = account;
		}
		public void run() {
			account.withdraw(50);
		}
	}

}
