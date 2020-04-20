
public class CheckingAccount extends BankAccount{
	
	static final double FEE = .15;
	private String AccountNumber;
	

	
public CheckingAccount(String name, double number) {
	super(name,number);
	
	this.AccountNumber = this.getAccountNumber()+"-10";
	this.setAccountNumber(this.AccountNumber);
}
	

public boolean widthdraw(double A) {
	
	if (A > this.getBalance()) { return false; }
	if (A + (this.FEE) > this.getBalance()) { return false; }


	boolean result = super.withdraw(A + (this.FEE));

	
	return result;
}
	
	


	
	
}
