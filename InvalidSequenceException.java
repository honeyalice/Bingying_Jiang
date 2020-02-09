package Project1;
/**
 * This exception is thrown when the password contains more than two of the same charcter in sequence.
 * @author Bingying_Jiang
 *
 */

public class InvalidSequenceException extends Exception{
	
	
	public InvalidSequenceException() {
		//set up the exception message
		super("The password cannot contain more than two of the same character in sequence.");
	}

}
