import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter extends MorseCodeTree
{
	 public static MorseCodeTree tree = new MorseCodeTree();
	 public static ArrayList list = new ArrayList();
	
	/**
	 * Constructor
	 */
	public MorseCodeConverter() 
	{
		
	}
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them.
	 * @return 
	 */
	
	public static String printTree() 
	{
		list = tree.toArrayList();
		String print = "";
		for(int i = 0; i < list.size(); i++) 
		{
			print +=list.get(i);print += " ";
			return print;
		}
		return print;
	}
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * @param code
	 * @return
	 */
	public static String convertToEnglish(String code) 
	{
		MorseCodeTree tree = new MorseCodeTree();
		String[] worCode = code.split("/");
		String[] line;
		String res = "";
		
		for(int i = 0; i < worCode.length; i++) 
		{
			
			line = worCode[i].split(" ");
			
			for(int j = 0; j < line.length; j++) 
			{
				res += tree.fetch(line[j]);
			}
			res = res + " ";
		}
		res = res.trim();
		return res;
	}
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * @param codeFile
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException 
	{
		
		String line = "";
		Scanner read = new Scanner(codeFile);
		
		while (read.hasNext()) 
		{
			line = read.nextLine();
			line = convertToEnglish(line);
		}
		
		if( codeFile.length() == 0) 
		{
			throw new FileNotFoundException();
		}
		
		read.close();
		return line;
		
	}
	
		
}