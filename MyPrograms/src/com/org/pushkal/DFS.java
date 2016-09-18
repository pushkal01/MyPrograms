package com.org.pushkal;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

	private int V; //no of vertices
	private LinkedList<Integer> adj[]; // adjecent list
	
	DFS(int v)
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
	
	void getDFS(int s)
	{
		boolean visited[] = new boolean[V];
		findDFS(s, visited);
	}
	
	void findDFS(int s, boolean [] visited)
	{

		visited[s] = true;
		System.out.print(s+" ");
		Iterator<Integer> itr = adj[s].iterator();
		while(itr.hasNext())
		{
			int l = itr.next();

			if (!visited[l])
			{
				findDFS(l, visited);
			}
		}
	}
	public static void main(String[] args) {


        DFS g = new DFS(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.getDFS(2);
	}

}
