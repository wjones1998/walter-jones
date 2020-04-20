
public class SavingsAccount extends BankAccount{
	public double rate = .025;
	public double savingsNumber = 0;
	private String AccountNumber;
	



public SavingsAccount(String name, double number) {
	
super(name,number);
	
	this.AccountNumber = this.getAccountNumber() + "-10";
	this.setAccountNumber(this.AccountNumber);
	
	
}

public SavingsAccount(BankAccount T, double N) {
	
	super(T,N);
	this.savingsNumber++;
	this.AccountNumber = super.getAccountNumber();
	this.setAccountNumber(this.AccountNumber);
			
	
	
	
}

public void postInterest() {
	this.setBalance((this.getBalance()*this.rate + this.getBalance()));
	
	
}

public String getAccount() {
	
	return this.AccountNumber + "-" + savingsNumber;
	
}

}