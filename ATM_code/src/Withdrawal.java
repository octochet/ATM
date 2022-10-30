//Withdrawal class extending transaction
public class Withdrawal extends Transaction{
	private int amount;
	private Keypad keypad;
	private CashDispenser cashDispenser; //Cash dispenser required for giving money.
	double availableBalance;
	
	//constructor
	public Withdrawal (int userAccountNumber, Screen atmScreen, BankDatabase atmBankDataBase, Keypad atmKeyPad, CashDispenser atmCashDispenser)
	{
		//initialize parent class fields
		super( userAccountNumber, atmScreen, atmBankDataBase);		
		
		keypad = atmKeyPad;
		cashDispenser = atmCashDispenser;
	}
	
	//overriding 
	@Override
	public void execute()
	{
		//max limit is Rs. 50,000.
		System.out.println("Max Limit: Rs. 50,000.");
		//while loop runs until cancelled by user.
		while(true) {
			//prompt to enter amount.
			System.out.println("Enter amount to withdraw:");
			amount = keypad.getInput();
			//get available balance in account
			availableBalance = BankDatabase.getuserBalance(getAccountNumber());
			//if invalid amount entered shows error message
			if(amount>availableBalance) { 
				System.out.println("Enter amount less than your balance to withdraw money.");
			}
			else { 
				//dispense the required amount of cash.
				cashDispenser.dispenseCash(amount);
				//update bank balance
				BankDatabase.debit(getAccountNumber(),amount);
				//end function.
				break;
			}
		}
	}
}