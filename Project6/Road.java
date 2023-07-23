
public class Road implements Comparable<Road> 
{

	private Town t1, t2;
	private String Name;
	private int Distance;



	public Road(Town t1, Town t2, String Name, int Distance) 
	{
		this.t1 = t1;
		this.t2 = t2;
		this.Name = Name;
		this.Distance = Distance;
	}

	public Town getT1() 
	{
		return t1;
	}

	public void setT1(Town t1) 
	{
		this.t1 = t1;
	}

	public Town getT2() 
	{
		return t2;
	}

	public void setT2(Town t2) 
	{
		this.t2 = t2;
	}

	public String getName() 
	{
		return Name;
	}

	public void setName(String Name) 
	{
		this.Name = Name;
	}

	public int getDistance() 
	{
		return Distance;
	}

	public void setDistance(int Distance) 
	{
		this.Distance = Distance;
	}

	public int compareTo(Road o) 
	{
		if (this.Distance == (o.Distance)) 
		{
			return 1;
		} 
		else 
		{
			return 0;
		}
	}

	public String toString() 
	{	
		return ("t1=" + t1 + ", t2=" + t2 + ", Name=" + Name + ", Distance=" + Distance);
	}

	public void add(Road road) {
		// TODO Auto-generated method stub
		
	}

}
