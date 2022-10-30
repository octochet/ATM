//Account class containing getter setter functions.


public class Account {
	private final int accountNumber; // Account number is private and final
	private int pin;                 // Account PIN is private
	private double Balance;          // Account balance is private
	public int PINTries = 0;         // Number of pin tries on this account
	
	
	//public Constructor
	public Account (int number, int pin, int balance) {
		this.accountNumber = number;
		this.pin = pin;
		this.Balance = balance; 
	}
	
	//PIN validation
	public boolean ValidatePin(int userPIN) {
		if(this.pin==userPIN) return true;
		else return false;
	}
	
	
	//Getter setter for various fields
	public double getBalance() {
		return this.Balance;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	// updating balance after credit and debit
	public void credit(double amount) {
		this.Balance += amount;
	}
	
	public void debit(double amount) {
		this.Balance -= amount;
	}
	
	//updating PIN function
	public void changePIN(int newPIN) {
		this.pin = newPIN;
	}
}
