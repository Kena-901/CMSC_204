import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordCheckerUtilityTestStudent {
	String pass1,pass2,pass3,pass4,pass5,pass6,pass7,pass8;
	ArrayList<String> list= new ArrayList<String>();

	@BeforeEach
	void setUp() throws Exception {
		pass1 = "Kenu1";
		pass2 = "enu19.y";
		pass3 = "KEVIN9.";
		pass4 = "KEVIir.";
		pass5 = "KEVIN9rt";
		pass6 = "KeeeVIN9.";
		pass7 = "KEna39.d03";
		pass8 = "Ken12>7";
		list.add(pass1);
		list.add(pass8);
		list.add(pass7);
	}

	@AfterEach
	void tearDown() throws Exception {
		pass1 = pass2 = pass3 = pass4 = pass5 = pass6 = pass7 = pass8 =null;
		list = null;
	}

	/**
	 * junit to test comparePassword
	 */
	@Test
	void testComparePasswords​() {
		try{
			PasswordCheckerUtility.comparePasswords​(pass1,pass2);
		}
		catch(UnmatchedException e)
		{
			assertEquals("Passwords do not match",e.getMessage());
		}
	}

	/**
	 * junit to test comparePasswordWithReturn
	 */
	@Test
	void testComparePasswordsWithReturn​() {
		assertTrue(PasswordCheckerUtility.comparePasswordsWithReturn​(pass1,pass1));
		assertTrue(!PasswordCheckerUtility.comparePasswordsWithReturn​(pass1,pass2));
	}

	/**
	 * junit to test invalidPassword
	 */
	@Test
	void testGetInvalidPasswords​() {
		
		assertEquals("Kenu1  The password must be at least 6 characters long",PasswordCheckerUtility.getInvalidPasswords​(list).get(0));
	}

	/**
	 * junit to test hasBetweenSixAndNineChars​
	 */
	@Test
	void testHasBetweenSixAndNineChars​() {
		
		assertTrue(!PasswordCheckerUtility.hasBetweenSixAndNineChars​(pass1));
		assertTrue(PasswordCheckerUtility.hasBetweenSixAndNineChars​(pass3));
	}

	/**
	 * junit to test hasDigit​
	 */
	@Test
	void testHasDigit​() {
		try{
			assertTrue(PasswordCheckerUtility.hasDigit​(pass1));
			PasswordCheckerUtility.hasDigit​(pass4);
		}
		catch(NoDigitException e)
		{
			assertEquals("The password must contain at least one digit",e.getMessage());
		}
	}

	/**
	 * junit to test hasLowerAlpha​
	 */
	@Test
	void testHasLowerAlpha​() {
		try{
			assertTrue(PasswordCheckerUtility.hasLowerAlpha​(pass1));
			PasswordCheckerUtility.hasLowerAlpha​(pass3);
		}
		catch(NoLowerAlphaException e)
		{
			assertEquals("The password must contain at least one lowercase alphabetic character",e.getMessage());
		}
	}

	/**
	 * junit to test hasSpecialChar​
	 */
	@Test
	void testHasSpecialChar​() {
		try{
			assertTrue(PasswordCheckerUtility.hasSpecialChar​(pass2));
			PasswordCheckerUtility.hasSpecialChar​(pass1);
		}
		catch(NoSpecialCharacterException e)
		{
			assertEquals("The password must contain at least one special character",e.getMessage());
		}
	}

	/**
	 * junit to test hasUpperAlpha​
	 */
	@Test
	void testHasUpperAlpha​() {
		try{
			assertTrue(PasswordCheckerUtility.hasUpperAlpha​(pass1));
			PasswordCheckerUtility.hasUpperAlpha​(pass2);
		}
		catch(NoUpperAlphaException e)
		{
			assertEquals("The password must contain at least one uppercase alphabetic character",e.getMessage());
		}
	}

	/**
	 * junit to test isValidLength​​
	 */
	@Test
	void testIsValidLength​() {
		try{
			assertTrue(PasswordCheckerUtility.isValidLength​(pass2));
			PasswordCheckerUtility.isValidLength​(pass1);
		}
		catch(LengthException e)
		{
			assertEquals("The password must be at least 6 characters long",e.getMessage());
		}
	}

	/**
	 * junit to test isValidPassword​​
	 */
	@Test
	void testIsValidPassword​() {
			try {
				assertTrue(PasswordCheckerUtility.isValidPassword​(pass7));
				PasswordCheckerUtility.isValidPassword​(pass1);
				PasswordCheckerUtility.isValidPassword​(pass2);
				PasswordCheckerUtility.isValidPassword​(pass3);
				PasswordCheckerUtility.isValidPassword​(pass4);
				PasswordCheckerUtility.isValidPassword​(pass5);
				PasswordCheckerUtility.isValidPassword​(pass6);
				
			} catch (LengthException e) {
				assertEquals("The password must be at least 6 characters long",e.getMessage());
			} catch (NoUpperAlphaException e) {
				assertEquals("The password must contain at least one uppercase alphabetic character",e.getMessage());
			} catch (NoLowerAlphaException e) {
				assertEquals("The password must contain at least one lowercase alphabetic character",e.getMessage());
			} catch (NoDigitException e) {
				assertEquals("The password must contain at least one digit",e.getMessage());
			} catch (NoSpecialCharacterException e) {
				assertEquals("The password must contain at least one special character",e.getMessage());
			} catch (InvalidSequenceException e) {
				assertEquals("The password cannot contain more than two of the same character in sequence",e.getMessage());
			}
		   
	}

	/**
	 * junit to test isWeakPassword​​
	 */
	@Test
	void testIsWeakPassword​() throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		try{
			assertTrue(!PasswordCheckerUtility.isWeakPassword​(pass7));
			PasswordCheckerUtility.isWeakPassword​(pass8);
		}
		catch(WeakPasswordException e)
		{
			assertEquals("The password is OK but weak - it contains fewer than 10 characters",e.getMessage());
		}
	}

	/**
	 * junit to test noSameCharInSequence​​
	 */
	@Test
	void testNoSameCharInSequence​() {
		try{
			assertTrue(PasswordCheckerUtility.NoSameCharInSequence​(pass7));
			PasswordCheckerUtility.NoSameCharInSequence​(pass6);
		}
		catch(InvalidSequenceException e)
		{
			assertEquals("The password cannot contain more than two of the same character in sequence",e.getMessage());
		}
	}

}
