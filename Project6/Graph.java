import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>
{
	private Set<Town> town;
	private Set<Road> road;
	
	public Graph()
	{
		HashSet<Town> town = new HashSet<Town>();
		HashSet<Road> road = new HashSet<Road>();
	}
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) 
	{
		if (!containsVertex(sourceVertex))
		{
			return null;
		}
		if (!containsVertex(destinationVertex))
		{
			return null;
		}
		if(sourceVertex == null)
		{
			return null;
		}
		if(destinationVertex==null)
		{
			return null;
		}
		
		for(Road rd : edgesOf(sourceVertex))
		{
			if (((rd.getDestination().compareTo(sourceVertex) == 0) && (rd.getDestination().compareTo(destinationVertex) == 0))
					|| ((rd.getDestination().compareTo(sourceVertex) == 0) && (road.getDestination().compareTo(destinationVertex) == 0)))
			{
				return rd;
			}
		}
		return null;	
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) 
	{
		Road newRd = new Road(sourceVertex, destinationVertex, description,weight);
		
		((LinkedList<Town>) town).get(sourceVertex.getName()).addAdjacentTown(destinationVertex);
		((LinkedList<Town>) town).get(destinationVertex.getName()).addAdjacentTown(sourceVertex);
		road.add(newRd);
		
		return newRd;
	}

	@Override
	public boolean addVertex(Town v) 
	{
		if (v == null)
			throw new NullPointerException();
		if (containsVertex(v))
			return false;
		((HashMap<Town, Boolean>) town).put(v.getName(), new Town(v));
		return true;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) 
	{
		for (Road road : road)
		{
			if (road.contains(sourceVertex) && road.contains(destinationVertex))
			{
				return true;
			}
		}
	}

	@Override
	public boolean containsVertex(Town v) 
	{
		for (Town town : town)
		{
			if (town.getName().compareToIgnoreCase(v.getName()) == 0) 
			{
				return true;
			}
		}
		
	}

	@Override
	public Set<Road> edgeSet() 
	{
		return road;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) 
	{
		Set<Road> adj = new HashSet<Road>();
		
		for(Road rd : road)
		{
			if(road.getSource().equals(vertex))
			{
				adj.add(rd);
			}
			if(road.getDestination().equals(vertex))
			{
				adj.add(new Road(vertex, road.getSource(), road.getWeight(), road.getName()));
			}
				
		}
		return adj;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) 
	{
		Road rd = new Road(sourceVertex, destinationVertex, weight, description);
		road.remove(rd);
		
		return rd;
	}

	@Override
	public boolean removeVertex(Town v) 
	{
		Road curr;
		Iterator<Road> iter = road.iterator();
		while (iter.hasNext()) 
		{
			curr = iter.next();
			if (curr.contains(v))
			{
				iter.remove();
			}
		}
	}

	@Override
	public Set<Town> vertexSet() 
	{
		return town;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) 
	{
		dijkstraShortestPath(sourceVertex);

		ArrayList<String> list = new ArrayList<String>();
		LinkedList<Town> listTown = destinationVertex.getShortestPath();
		
		for (int i = 0; i < listTown.size(); i++)
		{
			list.add(listTown.get(i).toString());
		}
		
		list.add(destinationVertex.toString());
		
		return list;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) 
	{
		HashMap<Town, Boolean> visitedTowns = new HashMap<Town,Boolean>();   
		dist = new HashMap<Town, Integer>();
		
		listOfPaths = new HashMap<Town, ArrayList<String>>();
		
		PriorityQueue<Vector2D> queue = new PriorityQueue<Vector2D>();
		
		Vector2D currentTown;
		
		int newDist;
		
		for (Map.Entry<String, Town> entry : towns.entrySet())
		{
			visitedTowns.put(entry.getValue(), false);
			
			dist.put(entry.getValue(), INFINITY);
		}
		
		dist.put(sourceVertex, 0);
		queue.add(new Vector2D(sourceVertex, 0));
		
		while (!queue.isEmpty()) 
		{
			currentTown = queue.poll();
			visitedTowns.replace(currentTown.town, true);
			
			if (dist.get(currentTown.town) != INFINITY &&dist.get(currentTown.town) < currentTown.distance)
			{
				continue;
			}
			
			for (Road road : edgesOf(currentTown.town))
			{
				if (visitedTowns.get(road.getDestination()) == true)
				{
					continue;
				}
				
				newDist = dist.get(currentTown.town) +road.getWeight();
				
				if (newDist < dist.get(road.getDestination()) ||dist.get(road.getDestination()) == INFINITY)
				{
					dist.replace(road.getDestination(), newDist);
					queue.add(new Vector2D(road.getDestination(),newDist));
				}
				
				if (listOfPaths.get(currentTown.town) == null)
				{
					listOfPaths.put(road.getDestination(), newArrayList<String>());
				}
				else
				{
					listOfPaths.put(road.getDestination(),newArrayList<String>(listOfPaths.get(currentTown.town)));
				}
				
				listOfPaths.get(road.getDestination()).add(road.toString());
			}
		}
	}
	
	private class Vector2D implements Comparable<Vector2D> 
	{
		Town town;
		int distance;
		
		public Vector2D(Town town, int distance)
		{
			this.town=town;
			this.distance=distance;
		}
		
		public int compareTo(Vector2D otherVector)
		{
			return this.distance - otherVector.distance;
		}
	}

}
