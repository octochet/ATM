//class for cash dispenser in ATM.
//This class contains the denominations option for withdrawal.
//It also contains access to the cash inside the ATM hence has data regarding it.

public class CashDispenser {
	//initializing the variable 
	private static int two_thousands = 2200; //Number of various types of notes inside the ATM.
	private static int five_hundreds = 2200;
	private static int two_hundreds = 2200;
	private static int one_hundreds = 2200;
	private static int fifty = 2200;
	private int transaction_count;            //number of notes in a transaction/withdrawal
	private static int count;                 //total number of notes currently in ATM
	int current_twothousand, current_fivehundred, current_hundred, current_fifty, current_twohundred; //current number of notes in a transaction
	
	//constructor initializing variables to zero
	CashDispenser() {
		count = two_thousands+five_hundreds+two_hundreds+one_hundreds+fifty;
		transaction_count=0;
		current_twothousand=0;
		current_fivehundred=0;
		current_twohundred=0;
		current_hundred=0;
		current_fifty=0;
	}
	
	//dispense cash method which will output the required cash in the form of notes.
	//for a particular withdrawal the lowest denomination being a Rs. 50 and Highest being Rs. 2000 note.
	//amount is always a multiple of 50.
	public void dispenseCash(int amount) {
		//check variable to check if there is money in ATM or not
		boolean check=true; 
		transaction_count=0;
		current_twothousand=0;
		current_fivehundred=0;
		current_twohundred=0;
		current_hundred=0;
		current_fifty=0;
		//temp variable so that value of amount doesn't change
		int temp = amount;
		while(temp != 0) {
			if(temp>=2000 && two_thousands>0) {      //if amount greater than two thousand and notes available give a two thousand note.
				current_twothousand++;
				two_thousands--;
				temp -= 2000;                        //for each note give decrease the temp amount by that amount and update the respective counters.
			}
			else if(temp>=500 && five_hundreds>0) {  //if amount greater than five hundred and notes available give a five hundred note.
				current_fivehundred++;
				five_hundreds--;
				temp -= 500;
			}
			else if(temp>=200 && two_hundreds>0) {  //if amount greater than two hundred and notes available give a two hundred note.
				current_twohundred++;
				two_hundreds--;
				temp -= 200;
			}
			else if(temp>=100 && one_hundreds>0) {  //if amount greater than one hundred and notes available give a one hundred note.
				current_hundred++;
				one_hundreds--;
				temp -= 100;
			}
			else if(fifty>0) {                      //if amount greater than fifty and notes available give a fifty note.
				current_fifty++;
				fifty--;
				temp -= 50;
			}
			else {                                 //if no notes available print error message.
				System.out.println("Sorry !! Your transaction can not be processed "
						+ "due to no cash.\n        Please visit us later.     ");
				check=false;
			}
		}
		//calculate total number of notes and decrease total count.
		transaction_count = current_twothousand+current_fivehundred+current_hundred+
				current_fifty;
		count -= transaction_count;
		//if no error print the details of withdrawal.
		if(check) {
			System.out.println("Please collect your cash from the dispenser :");
			System.out.println("Total amount = "+amount+"\nTotal Note count : "+transaction_count); //print amount and total number of notes.
			//print relevant note info.
			if(current_twothousand>0) {
				System.out.println(current_twothousand+"x Two thousands.");
			}
			if(current_fivehundred>0) {
				System.out.println(current_fivehundred+"x Five Hundreds.");
			}
			if(current_twohundred>0) {
				System.out.println(current_twohundred+"x Two Hundreds.");
			}
			if(current_hundred>0) {
				System.out.println(current_hundred+"x One Hundreds.");
			}
			if(current_fifty>0) {
				System.out.println(current_fifty+"x Fifties.");
			}
		}
	}

	//checker function if notes are available or not.
	public boolean isSufficientCashAvailable( int amount)
	{
		int billsRequired = amount/50;
		
		if( count >= billsRequired)
			return true;
		else
			return false;
	}
}
