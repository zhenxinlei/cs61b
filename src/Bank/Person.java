package Bank;

public class Person implements Runnable {
	private BankAccount bankAccount;
	private double transactionAmount;//Transaction amount
	public Person (BankAccount bankAccount,double transactionAmount){
		this.bankAccount=bankAccount;
		this.transactionAmount=transactionAmount;
	}
	
	
	
	public double getTransactionAmount() {
		return transactionAmount;
	}

//	public void setTransactionAmount(double amount) {
//		this.transactionAmount = amount;
//	}

	@Override
	public void run() {
		System.out.println("\nAccount Balance before transaction: "+bankAccount.getBalance());
		System.out.println(this.toString()+"Start transaction");
		bankAccount.deposite(getTransactionAmount());
		System.out.println("Account Balance after transaction: "+bankAccount.getBalance());
		System.out.println(this.toString()+"Close transaction\n");
		
		
	}
	
	

}
