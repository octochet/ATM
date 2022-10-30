//class for screen object in the ATM.
//This is to imitate the screen hardware in the actual ATM.
//So IRL this will contain the hardware related code here.
public class Screen {
	public void displayMessage(String Message) {
		System.out.println(Message);
	}
	
	public void displayAmount(double amount) {
		System.out.println(amount);
	}
}
