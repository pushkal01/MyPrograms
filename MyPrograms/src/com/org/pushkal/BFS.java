package com.org.pushkal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	private int V; //no of vertices
	private LinkedList<Integer> adj[]; // adjecent list
	
	BFS(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i=0;i<v;i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	
	void addEdge(int v, int w)
	{
		adj[v].add(w);
	}
	
	
	void findBFS(int s)
	{
		boolean visited[] = new boolean[V];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		
		
		while(!queue.isEmpty())
		{
			s = queue.poll();
			System.out.print(s+" ");
			Iterator<Integer> itr = adj[s].iterator();
			while(itr.hasNext())
			{
				int l = itr.next();
				
				if (!visited[l])
				{
					visited[l] = true;
					queue.add(l);
				}
			}
		}
	}
		public static void main(String args[])
	    {
	        BFS g = new BFS(4);
	 
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	 
	        System.out.println("Following is Breadth First Traversal "+
	                           "(starting from vertex 2)");
	 
	        g.findBFS(2);
	    }
		
		
		
		
}
