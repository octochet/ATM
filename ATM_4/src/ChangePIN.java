//Change PIN class inheriting transaction class
public class ChangePIN extends Transaction{
	//declare fields to be used
	private Keypad keypad;
	private int newPIN;

	//public constructor.
	public ChangePIN(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDataBase, Keypad atmkeypad) {
		super(userAccountNumber, atmScreen, atmBankDataBase);
		this.keypad = atmkeypad;
	}

	@Override
	public void execute() {
		BankDatabase bankDataBase = getBankDataBase();
		Screen screen = getScreen();
		//get new PIN from user.
		newPIN = promptForNewPIN();
		
		@SuppressWarnings("static-access")
		Account userAccount = bankDataBase.getAccount(super.getAccountNumber());
		if(newPIN<10000 || newPIN>99999) { //PIN is five digit only.
			screen.displayMessage("Cancelled."); //If cancelled.
		}
		else {
			userAccount.changePIN(newPIN); //change PIN
		}
		
		if(userAccount.ValidatePin(newPIN)) {
			Screen screen2 = new Screen();
			screen2.displayMessage("PIN changed successfully!!"); //Success message
		}
		else {
			screen.displayMessage("Cancelled/Unknown error occurred."); //error message
		}
		
	}
	
	//function for getting new PIN
	private int promptForNewPIN() {
		Screen screen = getScreen();
		int input3=1;
		screen.displayMessage("\nEnter NEW PIN :");
		int input1 = keypad.getInput();	
		boolean b = true;
		while(b) {
			//taking PIN input again for confirmation
			screen.displayMessage("\nConfirm NEW PIN :");
			int input2 = keypad.getInput(); 
			//if both PINs are not same
			if(input1 != input2) {
				//Error message
				screen.displayMessage("Password not matching ! please enter again.");
				//Option to cancel.
				screen.displayMessage("Press 0 for Cancel or Press 1 to enter PIN again.");
				input3 = keypad.getInput();
				if(input3==0) {
					b=false;
				}
			}
			else {
				b=false;
			}
		}
		if(input3==0) return 0;
		return input1;
	}

}
