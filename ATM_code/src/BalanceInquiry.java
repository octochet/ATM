//Balance inquiry class which extends from abstract class transaction
public class BalanceInquiry extends Transaction{
	
	//constructor
	public BalanceInquiry (int userAccountNumber, Screen atmScreen, BankDatabase atmBankDataBase)
	{
		super(userAccountNumber, atmScreen, atmBankDataBase);
	}
	
	//execute function
	public void execute()
	{
		//get bank data base
		BankDatabase bankDataBase = getBankDataBase();
		//get screen object to display messages
		Screen screen = getScreen(); 
		//get account balance
		double availableBalance = bankDataBase.getBalance(getAccountNumber());	
		//get total available balance
		double totalBalance = bankDataBase.getBalance(getAccountNumber());
		
		//display INFO on screen
		screen.displayMessage("\nAccount information");
		screen.displayMessage("\nBalance available:");
		screen.displayAmount(availableBalance);
		screen.displayMessage("\nTotal balance:");
		screen.displayAmount(totalBalance);
		screen.displayMessage("");
	}

}