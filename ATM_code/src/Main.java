import java.io.FileNotFoundException;

//Main driver code
//Ideas I could've added  :
//1. A date and time based ATM which will be open at certain times only and not be 24x7.
//2. A reset function which will reset the cash in ATM every 24 hours or so.
//3. A transfer class to transfer money between accounts.
//4. A method to print a mini bank statement.
//5. E-banking options.
//6. An option to pay Credit Card bill / EMIs on loans.
//7. To accept cheques/DDs.
//I may update this code with the above said features later so do check my GitHub.
public class Main {
	public static void main(String args[]) throws FileNotFoundException {
		ATM MyATM = new ATM();
		MyATM.run();
	}
}
