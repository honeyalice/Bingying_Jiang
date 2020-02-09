package Project1;
/**
 * This exception is thrown when the password doesn't contain at least one lower case.
 * @author Bingying_Jiang
 *
 */

public class NoLowerAlphaException extends Exception{
	
	//set up exception message
	public NoLowerAlphaException() {
		super("The password must contain at least one lower case.");
	}
	
}
