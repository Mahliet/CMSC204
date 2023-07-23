
import java.io.IOException;
import java.util.*;


public class CourseDBStructure implements CourseDBStructureInterface 
{
	protected int size;
	protected LinkedList<CourseDBElement> hashTable[];
	
	/**
	 * Default constructor
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int size) 
	{
		this.size = size;
		hashTable = new LinkedList[size];
	}
	/**
	 * @param testing
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String testing, int size) 
	{
		this.size = size;
		hashTable = new LinkedList[size];
	}
	/**
	 * Creates a linked list if index is null
	 * Adds element if index is not null.
	 * @param element
	 */
	@Override
	public void add(CourseDBElement element) 
	{
		int index = element.hashCode() % size;
		if(hashTable[index] == null)
		{
			hashTable[index] = new LinkedList<CourseDBElement>();
		}
		hashTable[index].add(element);
	}
	/**
	 * gets CRN.
	 * throws an IOException when index is null
	 * @param crn
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException 
	{
		String str = crn + "";
		int index = str.hashCode() % size;
		if(hashTable[index] == null) 
		{
			throw new IOException();
		}
		else 
		{
			for(int i = 0; i < size; i++) 
			{
				CourseDBElement hash= hashTable[index].get(i);
				if(hash.getCRN() == crn)
				{
					return hash;
				}
			}
			return null;
		}
	}
	
	public ArrayList<String> showAll1() 
	{
		ArrayList<String> list = new ArrayList<String>();
		for (int i =0; i < hashTable.length; i++) 
		{ 
			LinkedList<CourseDBElement> listAll = hashTable[i];
			if(listAll!= null) 
			{
				for(int j = 0; j < listAll.size(); j++) 
				{ 
					
					CourseDBElement element=listAll.get(j);
					list.add(element.toString());
					size+=size;
						
				}
			}
		}
		
		return list;
	}
	
	/**
	 * gets the size of hashtable.
	 * @return size
	 */
	@Override
	public int getTableSize() 
	{ 
		return size;
	}
	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
	