import java.util.ArrayList; 

  

public class PasswordCheckerUtility extends java.lang.Object  

{ 

	public void comparePasswords(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException 

	{ 

		if(!(password== passwordConfirm))  

		{ 

			throw new UnmatchedException("Passwords do not match"); 

		} 

	} 

	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException

	{ 

		if(password.equals(passwordConfirm)) 

		{ 

			return true;

		} 
		if(!(password== passwordConfirm))  

		{ 

			throw new UnmatchedException("Passwords do not match"); 

		} 

			return false;
			
			

		
 


	} 

	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords) 

	{ 

		ArrayList <String> invalidPasswords = new ArrayList<>(); 

		for(String password : passwords) 

		{ 

			try 

			{ 

				isValidPassword(password); 

			} 

			catch (Exception e) 

			{ 

				invalidPasswords.add(password+ ":"+ e.getMessage()); 

			} 

		} 

		return invalidPasswords; 

	} 

	public static boolean hasBetweenSixAndNineChars(java.lang.String password) 

	{ 

		if(password.length()>=6 && password.length()<=9) 

		{ 

			return true; 
	
		} 

		return false; 

	} 

	public static boolean hasDigit(java.lang.String password)throws NoDigitException 

	{ 

		char[] characters=password.toCharArray(); 

		for(char c : characters) 

		{ 

			if(Character.isDigit(c)) 

			{ 

				return true; 

			} 

		} 

		throw new NoDigitException("Password must have at least 1 numeric character"); 

	} 

	public static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException 

	{ 

		char[] characters=password.toCharArray(); 

		for(char c : characters) 

		{ 

			if(Character.isLowerCase(c)) 

			{ 

				return true; 

			} 

		} 

		throw new NoLowerAlphaException("Password must have at least 1 lowercase alphabetic character."); 

	} 

	public static boolean hasSameCharInSequence(java.lang.String password) throws InvalidSequenceException 

	{ 

		char[] characters = password.toCharArray(); 

		for(int i=0; i<characters.length; i++) 

		{ 

			Character c = characters[i]; 

			if(i>3) 

			{ 

				if(c.equals(characters[i-1])&& c.equals(characters[i-2])) 

				{ 

					throw new InvalidSequenceException("Password must have no more than 2 of the same character in a sequence."); 

				} 

			} 

		} 

		return false; 

	} 

	public static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException 

	{ 

		String specialCharactersString=" ..!@#$%&*()'+,-./:;<=>?\r\n" + "\r\n" + "[]^_`{|}"; 

		char[] characters=password.toCharArray(); 

		for(char c : characters) 

		{ 

			if(specialCharactersString.contains(Character.toString(c))) 

			{ 

				return true; 

			} 

		} 

		throw new NoSpecialCharacterException("Password must have at least 1 special charcter."); 

	} 

	public static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException 

	{ 

		char[] characters=password.toCharArray(); 

		for(char c : characters) 

		{ 

			if(Character.isUpperCase(c)) 

			{ 

				return true; 

			} 

		} 

		throw new NoUpperAlphaException("Password must have at least 1 uppercase alphabetic charcter."); 

	} 

	public static boolean isValidLength(java.lang.String password) throws LengthException 

	{ 

		if(password.length()>6) 

		{ 

			return true; 

		} 

		throw new LengthException("The password must be at least 6 characters long"); 

	} 

	public static boolean isValidPassword(java.lang.String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException 

	{ 

		try 

		{ 

			isValidLength(password); 

		} 

		catch(LengthException e) 

		{ 

			throw new LengthException(e.getMessage()); 

		} 

		try 

		{ 

			hasUpperAlpha(password);	 

		} 

		finally 

		{ 

 

		} 

		try 

		{ 

			hasLowerAlpha(password); 

		} 

		catch(NoLowerAlphaException e) 

		{ 

			throw new NoLowerAlphaException(e.getMessage()); 

		} 

		try 

		{ 

			hasSpecialChar(password); 

		} 

		catch(NoSpecialCharacterException e) 

		{ 

			throw new NoSpecialCharacterException(e.getMessage()); 

		} 

		try 

		{ 

			hasSameCharInSequence(password); 

		} 

		catch(InvalidSequenceException e) 

		{ 

			throw new InvalidSequenceException(e.getMessage()); 

		} 

		return true; 

	} 

 

	public static boolean isWeakPassword(java.lang.String password) throws Exception 

	{ 

		hasBetweenSixAndNineChars(password); 

		throw new Exception("Password is weak"); 

	} 

} 