//Deposit class inheriting transaction
public class Deposit extends Transaction{
	//fields required 
	private double amount;
	private Keypad keypad;
	private DepositSlot depositSlot; //deposit slot object
	private final static int CANCELLED = 0;
	
	//public constructor.
	public Deposit ( int userAccountNumber, Screen atmScreen, BankDatabase atmBankDataBase, Keypad atmKeypad, DepositSlot atmDepositSlot)
	{
		super(userAccountNumber, atmScreen, atmBankDataBase);	
		
		keypad = atmKeypad;
		depositSlot = atmDepositSlot;
	}
	
	//overriding execute in abstract class transaction
	@Override
	public void execute()
	{
		BankDatabase bankDataBase = getBankDataBase();  //get database and screen
		Screen screen = getScreen();
		
		amount = promptForDepositAmount();	           //get deposit amount 
		
		//if not cancelled 
		if(amount != CANCELLED)
		{
			//display prompt to insert envelope
			screen.displayMessage("\n Insert the envelope with the money"); 
			screen.displayAmount(amount);
			screen.displayMessage(".");
			
			//check if envelope received or not
			boolean envelopeReceived = depositSlot.isEnvelopeReceived();
			
			
			if(envelopeReceived)
			{
				screen.displayMessage("\n Your envelope has been received. \\nNOTE: Money will be deposited as soon as possible."
						+ "First we will have to check the envelope.");
				//display message and update the account balnce respectively
				
				bankDataBase.credit(getAccountNumber(), amount);
			}
			else	//display error message
			{
				screen.displayMessage("\n You did not insert the envelope, so the transaction will be cancelled. :(");
			}
		}
		else	//cancelled
		{
			screen.displayMessage("\n Canceling transaction...");
		}
	}
	
	//method to get deposit amount
	private double promptForDepositAmount()
	{
		Screen screen = getScreen();
		
		screen.displayMessage("\n Enter the deposit amount in Rupees [option 0 cancels]: ");
		int input = keypad.getInput();	
		
		if (input == CANCELLED)
			return CANCELLED;
		else
		{
			return (double) input;
		}
	}
	
	

}