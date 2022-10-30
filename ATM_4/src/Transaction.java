//An abstract class Transaction which encompasses all types of various transaction a user can do.
// like withdrawal, deposit, balance Inquiry, change PIN, etc.
public abstract class Transaction {
	
	// Declare required fields.
	private int accountNumber;
	private Screen screen;
	private BankDatabase bankDataBase;	
	
	//constructor
	public Transaction (int userAccountNumber, Screen atmScreen, BankDatabase atmBankDataBase)
	{
		accountNumber = userAccountNumber;
		screen = atmScreen;
		bankDataBase = atmBankDataBase;
	}
	//getter setter methods.
	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	public Screen getScreen()
	{
		return screen;
	}
	
	public BankDatabase getBankDataBase()
	{
		return bankDataBase;
	}
	
	//abstract method execute which will be overridden to child class.
	abstract public void execute();

}
