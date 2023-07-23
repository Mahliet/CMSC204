import java.util.List;
import java.util.ArrayList;

public class Town implements Comparable<Town>
{

	private String name; 
	private ArrayList<Town> adjacent_Towns;
	
	
	 


	public Town(String name)
	{
		this.name = name;
		ArrayList<Town> adjacent_Towns = new ArrayList<Town>();
	}


	public Town(Town templateTown)
	{

		name = templateTown.name;

		this.adjacent_Towns = new ArrayList<Town>();

		for(int i=0;i<((ArrayList<Town>) templateTown.adjacent_Towns).size();i++)
			adjacent_Towns.add(((ArrayList<Town>) templateTown.adjacent_Towns).get(i));
	}


	public String getName()
	{
		return name;
	}


	@Override
	public int compareTo(Town t) 
	{
		return name.compareTo(t.getName());
	}


	public String toString()
	{
		return ( "Name=" + name + ", AdjTowns=" + adjacent_Towns );
	}


	public int hashCode()
	{
		return name.hashCode();
	}

	public boolean equals(Object obj)
	{

		if(obj instanceof Town)
		{
			Town t = (Town)obj; 
			return name.equals(t.name);
		}

		return false;
	}
	
	public void addAdjacentTown(Town t) 
	{
		if(( adjacent_Towns).contains(t))
			return;
		((ArrayList<Town>) adjacent_Towns).add(t);
	}
	
	public void removeAdjacentTown(Town t) 
	{
		((ArrayList<Town>) adjacent_Towns).remove(t);
	}
	
	public boolean isAdjacentTo(Town t) 
	{
		return ( adjacent_Towns).contains(t);
	}
	

}
