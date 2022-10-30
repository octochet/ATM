import java.util.Scanner;

//class for keypad object in ATM
//Again IRL keypad is an electronic object and hence will contain the respective code here.
//this is just to imitate keypad
public class Keypad {
	private Scanner input;
	
	public Keypad() {
		input  = new Scanner(System.in);
	}
	
	public int getInput() {
		return input.nextInt();
	}
}
