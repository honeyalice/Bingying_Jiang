package Project1;
/**
 * This exception is thrown when the password doesn't reach 6 characters.
 * @author Bingying_Jiang
 *
 */

public class LengthException extends Exception{
	
	//set up exception message.
	public LengthException() {
		
		super("The password must be at least 6 length");
	}
	
	
}
