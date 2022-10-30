import java.io.FileNotFoundException;

//Main ATM class
public class ATM {
	
	private boolean Authentication;                //to verify if user is Authenticated or not
	private int currentAccountNumber;              //User inputed account number
	private Screen screen;                         //screen object
	private Keypad keypad;                         //keypad object
	private CashDispenser cashDispenser;           //cash dispenser object
	private BankDatabase bankDatabase;             //bank database
	private DepositSlot depositSlot;               //deposit slot object
	private static final int BALANCE_INQUIRY = 1;  //below are the options in the menu which a user can choose from
	private static final int WITHDRAWAL = 2;
	private static final int DEPOSIT = 3;
	private static final int PIN_CHANGE = 4;
	private static final int EXIT = 5;
	
	//public constructor
	public ATM() throws FileNotFoundException {
		Authentication = false;
		currentAccountNumber = 0;
		screen = new Screen();
		keypad = new Keypad();
		cashDispenser = new CashDispenser();
		depositSlot = new DepositSlot();
		bankDatabase = new BankDatabase();
	}
	
	//User Authentication method
	private void authenticateUser() {
		screen.displayMessage("Enter account number: ");      //prompt to enter account number
		int accountNumber = keypad.getInput();	            
		screen.displayMessage("PIN number: ");                //prompt to enter account PIN
		int pin = keypad.getInput();
		
		
		Authentication = bankDatabase.authenticateUser( accountNumber, pin);    //authentication by comparing with data in bank database
		
		
		if(Authentication)                       // If Authentication is successful assign current account number  
		{
			currentAccountNumber = accountNumber;	
		}
		else                                     // Else show error.
		{
			screen.displayMessage("Invalid account number or PIN. Please try again.");
		}
	}
	
	
	//Method describing the Main Menu once a user logs in
	private int displayMainMenu() {
		screen.displayMessage("\nMain Menu");
		screen.displayMessage("\n1 - View Balance.");
		screen.displayMessage("2 - Withdraw.");
		screen.displayMessage("3 - Deposit");
		screen.displayMessage("4 - Change PIN.");
		screen.displayMessage("5 - Logout.");
		screen.displayMessage("\n enter a choice");
		return keypad.getInput();
	}
	
	
	//Transaction method to execute the choice of user after main menu.
	private Transaction createTransaction( int type) {
		Transaction temp = null;	//transaction object
		
		// switch case for transaction type
		switch(type) {
		case BALANCE_INQUIRY:
			//assign temp transaction object to balance inquiry class
			temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);			
			break;
		case WITHDRAWAL:
			//assign temp transaction object to Withdrawal class
			temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);			
			break;
		case DEPOSIT:
			//assign temp transaction object to Deposit class
			temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);			
			break;
		case PIN_CHANGE:
			//assign temp transaction object to ChangePIN class
			temp = new ChangePIN(currentAccountNumber, screen, bankDatabase, keypad);			
			break;
		}	
		return temp; //return the transaction object
	}
	
	
	//Method to run transactions after authentication
	private void performTransactions() {
		Transaction currentTrasaction = null;
		boolean b = true;
		//while loop which will run until user logs out of the system.
		while(b)
		{
			int mainMenuSelection = displayMainMenu(); //select main menu option
			
			//switch case for main menu to execute transaction
			switch(mainMenuSelection)
			{
			case BALANCE_INQUIRY:
			case WITHDRAWAL:
			case DEPOSIT:
			case PIN_CHANGE:
			
			currentTrasaction = createTransaction (mainMenuSelection); //create transaction using method
			currentTrasaction.execute();	 //execute method in transaction class
			break;
			// exit or Log Out of the account.
			case EXIT:
				screen.displayMessage("\nexiting the system..."); //exit message
				b= false;
				break;
				
			//Error message when user enters invalid option number(which is not in menu)
			default:	
				screen.displayMessage("\nYou have not entered a valid option. Try again."); 
				break;
			}
		}
	}
	
	//Driver code which will run all the methods in ATM.
	public void run() {
		
		//This is a 24x7 ATM hence it will always be ON.
		while(true) {
			
			//Until user is authenticated keep ATM in authentication mode only
			while(!Authentication) {  
				//Welcome message.
				screen.displayMessage("\n--------Welcome to ATM!!!--------");
				authenticateUser();				
			}
			//after authenticated perform transactions
			performTransactions();
			//after logging out reset Authentication to false for next user to log in
			Authentication= false; 
			//Exit message
			screen.displayMessage("\n\nThank You for using ATM.");
			
		}
	}
}
