package Project1;

/**
 * This exception is thrown when the password doesn't contain at least one digit.
 * @author Bingying_Jiang
 *
 */

public class NoDigitException extends Exception {
	
	
	//set up exception message.
	public NoDigitException() {
		super("The password must contain at least one digit.");
	}
	
	

}
