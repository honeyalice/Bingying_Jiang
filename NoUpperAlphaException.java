package Project1;
/**
 * this exception is thrown when the password doesn't contain at least one upper case.
 * @author Bingying_Jiang
 *
 */

public class NoUpperAlphaException extends Exception{
	
	//set up exception message.
	public NoUpperAlphaException() {
		super("The password must contain at least one upper case.");
	}
	

}
