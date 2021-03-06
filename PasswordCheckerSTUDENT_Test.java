package Project1;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Bingying_Jiang
 *
 */
public class PasswordCheckerSTUDENT_Test {
	
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		String[] p = {"3Jk", "IJK98ujd", "234juyl", "Alicean", "ville187", "Jan0111","UM12345",
				"FebMon0234"
				};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));
		
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("3Jk"));
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("234juyl"));
			PasswordCheckerUtility.isValidPassword("ville187");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			PasswordCheckerUtility.isValidPassword("UM12345");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("IJK98ujd"));
			assertTrue(PasswordCheckerUtility.isWeakPassword("IJK98ujd"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			PasswordCheckerUtility.isValidPassword("Jan0111");
			assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			PasswordCheckerUtility.isValidPassword("Alicean");
			assertTrue("Did not throw an NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw an NoDigitExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an NoDigitException",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("FebMon0234"));
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw an exception",false);
		}
	}
	
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testValidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.invalidPasswords(passwords);
		
		Scanner scan = new Scanner(results.get(0));
		assertEquals("3Jk", scan.next());
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("characters long"));
		
		scan = new Scanner(results.get(1));
		assertEquals("234juyl", scan.next());
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		
		scan = new Scanner(results.get(2));
		assertEquals("Alicean", scan.next());
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		
		scan = new Scanner(results.get(3));
		assertEquals("ville187", scan.next());
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		
		scan = new Scanner(results.get(4));
		assertEquals("Jan0111", scan.next());
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("more than two"));
		
		scan = new Scanner(results.get(5));
		assertEquals("UM12345", scan.next());
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		
		
		
		
	}


	}
	

