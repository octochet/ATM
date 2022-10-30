import java.util.Scanner;

public class BankDatabase {
	//bank data base from which we will get the account details.
	//In real life this data base is online in the bank's main server and not in the ATM.
	//the ATM will get info over a secure connection.
	//To replicate this we will just enter the raw info in the constructors.
	
	//file handling may be used but again this is an ATM and not a bank.
	//Hence ATM will in general not contain account files or info.
	//So file handling will also be an incorrect representation of ATM.
	
	private static Account[] accounts;
	
	//constructor Initialising the account info. In the format (Account Number, Account PIN, balance).
	public BankDatabase() {
		accounts = new Account[5];
		accounts[0] = new Account(12345, 54321, 50000);
		accounts[1] = new Account(23456, 65432, 50000);
		accounts[2] = new Account(34567, 76543, 50000);
		accounts[3] = new Account(45678, 87654, 50000);
		accounts[4] = new Account(56789, 98765, 50000);
	}
	
	//method returning the account object for a user inputed account number
	static Account getAccount(int accountNumber) {
		for(Account currentAccount : accounts) {
			if(currentAccount.getAccountNumber()==accountNumber) {
				return currentAccount;
			}
		}
		return null; //if account doesn't exist it will not return any account.
	}
	
	//authentication function.
	public boolean authenticateUser(int userAccountNumber, int userPIN) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Account userAccount = getAccount(userAccountNumber); //check account exists or not.
		
		//if account exists and is locked(i.e.  number of pin tries is equal to 3).
		if(userAccount != null && userAccount.PINTries >=2) { 
			System.out.println("Account locked due to multiple wrong PIN attempts. Please contact bank officials.");
			return false;
		}
		
		//if account exists and is not locked(i.e.  number of pin tries is less than 3).
		else if(userAccount != null && userAccount.PINTries <2) { 
			
			//if user pin is incorrect but account number is correct
			while(!userAccount.ValidatePin(userPIN) && userAccount.PINTries <2) {
				System.out.println("Invalid PIN enter again : ");
				//get PIN again
				userPIN = sc.nextInt(); 
				//for each wrong try increase PIN Tries counter.
				userAccount.PINTries++;
			}
			//if valid PIN return true. else will return false.
			return userAccount.ValidatePin(userPIN);
		}
		//if invalid account number return false
		else {
			return false;
		}
	}
	
	// get balance
	public double getBalance(int userAccountNumber)
	{
		return getAccount(userAccountNumber).getBalance();
	}
	
	//credit money
	public void credit(int userAccountNumber, double amount)
	{
		getAccount(userAccountNumber).credit(amount);
	}

	//debit money
	public static void debit(int userAccountNumber, double amount)
	{
		getAccount(userAccountNumber).debit(amount);
	}

	//get user balance
	public static double getuserBalance(int userAccountNumber) {
		return getAccount(userAccountNumber).getBalance();
	}

}
