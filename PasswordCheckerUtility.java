package Project1;

/**
 * This utility is designed to check if the password entered is valid.
 * @author Bingying_Jiang
 */

import java.util.ArrayList;

public class PasswordCheckerUtility {
	
	private static ArrayList<String> in_pwds;
	public static final int pwd_Length = 6;
	
	/**
	 * 
	 * @param pwdString
	 * @return boolean true if the password is valid 
	 * @throws LengthException thrown 
	 * @throws NoDigitException thrown when there is no digit in the password
	 * @throws NoUpperAlphaException thrown when there is no uppercase in the password
	 * @throws NoLowerAlphaException thrown when there is no lowercase in the password
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String pwdString)
            throws LengthException,
                   NoDigitException,
                   NoUpperAlphaException,
                   NoLowerAlphaException,
                   InvalidSequenceException
                   {
		// if the password is less than 6 character, throws a lengthexception
		if (pwdString.length() < pwd_Length)
			throw new LengthException();
		
		boolean upperCase = false;
		boolean lowerCase = false;
	    boolean digit = false;
	    //check through the loop if there is uppercase, lowercase, or digit.
	    for(char ch: pwdString.toCharArray()){
	        if(Character.isUpperCase(ch)) 
	        	upperCase = true;
	        if(Character.isLowerCase(ch)) 
	        	lowerCase = true;
	        if(Character.isDigit(ch)) 
	        	digit = true;
	    }
	    //if the password doesn't contain upper case, throw a NoUpperAlphaException.
	    if(!upperCase)
	    	throw new NoUpperAlphaException();
	    //if the password doesn't contain a lower case, throw a NoLowerAlphaException.
	    if(!lowerCase)
	    	throw new NoLowerAlphaException();
	    //if the password doesn't contain a digit, throw a NoDigitException
	    if(!digit)
	    	throw new NoDigitException();
                   
	    for (int i =0; i<pwdString.length()-2; i++) {
	    	//if there are there same letters, if so, throw a InvalidSequenceException.
	    	if( (pwdString.charAt(i) == pwdString.charAt(i + 1)) && (pwdString.charAt(i) == pwdString.charAt(i+2)) )
	    	{
	    		throw new InvalidSequenceException ();
	    	}

	    }
	    return true;
		
		
                   }
	/**Return true if length of password is greater than or equal to 6 but less than or equal to 9
	 * 
	 * @param pwdString - string to be checked if weak password
	 * @return true if length of password is greater than or equal to 6 but less than or equal to 9
	 */
	
	public static boolean isWeakPassword(String pwdString) {
		return (pwdString.length()<= 9 && pwdString.length()>= 6);
			
		
	}
	
	
	/**
	 * Returns an arraylist of invalid passwords (weak passwords are not considered invalid)
	 * @param pwds arraylist of passwords to check for validity
	 * @return arraylist of invalid passwords. It will not return weak passwords.
	 */
	public static ArrayList<String> invalidPasswords(ArrayList<String> pwds){
		// an arraylist to hold all the invalid password.
		in_pwds = new ArrayList<String>();
	      
	       String error = null;
	      // use try-catch to find all errors.
	       for(int i = 0; i < pwds.size(); i++)
	       {
	           try
	           {
	               isValidPassword(pwds.get(i));
	           }
	          
	           catch (LengthException e)
	            {
	               error = pwds.get(i) + " The password must be at least 6 characters long.";
	                in_pwds.add(error);
	            }
	           
	           catch (NoUpperAlphaException e) {
	               error = pwds.get(i) + " The password must contain at least one uppercase character.";
	                in_pwds.add(error);
	           }
	           catch (NoLowerAlphaException e) {
	               error = pwds.get(i) + " The password must contain at least one lowercase character.";
	                in_pwds.add(error);
	           }
	           catch (NoDigitException e) {
	               error = pwds.get(i) + " The password must contain at least one digit.";
	                in_pwds.add(error);
	           }
	           catch (InvalidSequenceException e) {
	               error = pwds.get(i) + " The password cannot contain more than two of the same character in sequence.";
	                in_pwds.add(error);
	           }
	       }
	      
	       //Return the ArrayList that contains all the invalid passwords only
	       return in_pwds;
	   }
	
	}  
	
