package Bank;

public class BankAccount {
	
	public BankAccount (double amount){
		this.balance=amount;
	}
	
	public double balance;
	
	public synchronized double getBalance(){
		return this.balance;
	}
	
	public synchronized void deposite(double amount){
		this.balance=this.balance+amount;
	}
	
//	public synchronized void withdraw(double amount){
//		this.balance=this.balance-amount;
//	}
	

}
