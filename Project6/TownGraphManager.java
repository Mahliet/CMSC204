import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TownGraphManager implements TownGraphManagerInterface 
{
	private ArrayList<Town> town;
	private ArrayList<Road> road;
	private Graph graphRd;
	
	public TownGraphManager()
	{
		town = new ArrayList<Town>();
		road = new ArrayList<Road>();
	}

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) 
	{
		Town sourceVertex = new Town(town1);
		Town destinationVertex = new Town(town2);
		sourceVertex.addAdjacentTown(destinationVertex);
		destinationVertex.addAdjacentTown(sourceVertex);

		Road road = new Road(sourceVertex, destinationVertex, roadName, weight);
		((List<Town>) road).addAll((Collection<? extends Town>) road);
		return true;
	}

	@Override
	public String getRoad(String town1, String town2) 
	{
		Town sourceV = null;
		Town destinationV = null;
		
		for(int i = 0; i < town.size(); i++)
		{
			if(town.get(i).getName().equals(town1))
			{
				sourceV=town.get(i);
			}
			if (town.get(i).getName.equals(town2))
			{
				destinationV=town.get(i);
			}
		}
		
		for(Road rd : road)
		{
			if (((rd.getEndPoint1().compareTo(sourceV) == 0)&& (rd.getEndPoint2().compareTo(destinationV) == 0))||
					((rd.getEndPoint2().compareTo(sourceV) == 0)&&
							 (rd.getEndPoint1().compareTo(destinationV) == 0)))
			{
				return rd.getName();
			}
		}
		return null;
	}
	
	@Override
	public boolean addTown(String v) 
	{
		Town sv = null;
		for(int i = 0; i < town.size(); i++)
		{
		if(town.get(i).getName().equals(v))
		{
		sv = town.get(i);
		}
		}
		return town.add(sv);
	}

	@Override
	public boolean containsTown(String v) 
	{
		for (Town t : town)
		{
			if (( town).getName().compareToIgnoreCase(v) == 0)
				return true;
		}
		return false;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) 
	{
		Town sourceV = null;
		Town destinationV = null;
		
		for(int i=0; i<town.size(); i++)
		{
			if(town.get(i).getName().equals(town1))
			{
				sourceV = town.get(i);
			}

			if(town.get(i).getName().equals(town2))
			{
				destinationV = town.get(i);
			}
		}
		
		for (Road rd : road)
		{
			if (road.contains(sourceV) && road.contains(destinationV))
				return true;
		}
		return false;
	}

	@Override
	public ArrayList<String> allRoads() 
	{
		ArrayList<String> res = new ArrayList<String>();
		for(int i = 0; i < road.size(); i++)
		{
		res.add(road.get(i).getName());
		}

		return res;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) 
	{
		if (graphRd.removeEdge(new Town(town1), new Town(town2), 0,road) == null))
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteTown(String v) 
	{
		return graphRd.removeVertex(new Town(v));
	}

	@Override
	public ArrayList<String> allTowns() 
	{
		ArrayList<String> town = new ArrayList<String>();
		for(Town t : graphRd.vertexSet())
		{
			town.add(t.getName());
		}
		
		if(town.size()<=0)
		{
			return town;	
		}
		
		Collections.sort(town);
		
		return town;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) 
	{
		return graphRd.shortestPath(new Town(town1), new Town(town2));
	}

	@Override
	public boolean getTown(String name) 
	{
		return graphRd.addVertex(new Town(name));
	}
	
	public void populateTownGraph (File file) throws FileNotFoundException, IOException
	{
		String[] t;
		String currentLine;
		Scanner fileReader = new Scanner(file);
		while (fileReader.hasNextLine()) 
		{
			currentLine = fileReader.nextLine();
			t = currentLine.split(";|,");
			graphRd.addVertex(new Town(t[2]));
			graphRd.addVertex(new Town(t[3]));
			graphRd.addEdge(new Town(t[2]), new Town(t[3]),Integer.parseInt(t[1]), t[0]);
		}
	}
}
