import java.util.ArrayList;
public interface PasswordCheckerInterface {

   /**
   * Will check the validity of the password passed in, and returns true if the password is valid, or throws an exception if invalid.
   */
   public boolean isValidPassword (String passwordString) throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException;
  
  
   /**
   * Will check an ArrayList of passwords and returns an ArrayList with the status of any invalid passwords.
   */
   public ArrayList<String> validPasswords (ArrayList<String> passwords);

}