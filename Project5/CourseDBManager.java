import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface
{
	private CourseDBStructure CDS = new CourseDBStructure(20);
	
	public void add(String id, int crn, int credits, String roomNum, String instructor)
	{
		CourseDBElement newElement = new CourseDBElement(id, crn, credits, roomNum, instructor);
		CDS.add(newElement);
	}
	
	public CourseDBElement get(int crn) 
	{
		try 
		{
			return CDS.get(crn);
		}
		catch (IOException e) 
		{
			e.getMessage();
		}
		return null;
	}

public void readFile(File file) throws FileNotFoundException 
	{
		try 
		{
			Scanner fileData = new Scanner(file);
			while(fileData.hasNext()) 
			{
				String id = fileData.next();
				if(id.charAt(0)!='#')
				{
					
					if(id.charAt(0)=='C'&& id.charAt(1)=='M'&&id.charAt(2)=='S'&&id.charAt(0)=='C')
					{
						  int crn= fileData.nextInt();
						  if(crn>0)
						try  
						  {
							  int numCredits=fileData.nextInt();
							  if(numCredits>=1&&numCredits<=4)
							  {
								  String roomNum = fileData.next();
								  String instructor = fileData.nextLine();
								  add(id, crn, numCredits, roomNum, instructor);
							  }
							  else
							  {
								  fileData.next();
							  }
						  }
						  catch(InputMismatchException e)
						  {
							  System.out.println("Invalid entries");
						  }
						  else
						  {
							  fileData.next();
						  }
						}
						else
						{
						fileData.next();
						}
				}
			
			}
				fileData.close();
			}
			catch(FileNotFoundException e) 
			{
				System.out.print("File not found");
				e.getMessage();
			}
	
	}
	
	public ArrayList<String> showAll() 
	{
		ArrayList<String> list = new ArrayList<String>();
		for (int i =0; i < CDS.hashTable.length; i++) 
		{ 
			LinkedList<CourseDBElement> listAll = CDS.hashTable[i];
			if(listAll!= null) 
			{
				for(int j = 0; j < listAll.size(); j++) 
				{ 
					
					CourseDBElement element=listAll.get(j);
					list.add(element.toString());
				}
			}
		}
		return list;
	}
	
	public void add1(String id, int crn, int credits, String roomNum, String instructor) 
	{
		CourseDBElement newElement = new CourseDBElement(id, crn, credits, roomNum, instructor);
		CDS.add(newElement);
		
	}
}
