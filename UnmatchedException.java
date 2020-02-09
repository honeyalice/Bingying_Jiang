package Project1;

/**
 * This exception is thrown when the two passwords are not matched.
 * @author Bingying_Jiang
 *
 */

public class UnmatchedException extends Exception{
	
	//set up exception message.
	public UnmatchedException() {
		super("The passwords are not matched");
	}

}
