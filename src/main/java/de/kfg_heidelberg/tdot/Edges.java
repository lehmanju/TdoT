package de.kfg_heidelberg.tdot;

import java.io.*;
import java.util.*;

public class Edges
{
    public static HashMap<Integer, LinkedList<Edge>> adjList;
    static
    {
	adjList = new HashMap<>();
	for (int v : Vertices.map.keySet())
	    adjList.put(v, new LinkedList<>());
	System.out.println("Reading edges from ways.txt");
	try (BufferedReader in = new BufferedReader(new InputStreamReader(Edges.class.getResourceAsStream("ways.txt"))))
	    {
		String line;
		while ((line = in.readLine()) != null)
		    {
			line = line.trim();
			if (line.startsWith("#"))
			    continue;
			String s[] = line.split("\\s+");
			if (s.length != 4)
			    {
				System.out.println("Syntax error in ways.txt in line: " + line);
				continue;
			    }
			Edge e = new Edge();
			e.start = Integer.parseInt(s[0]);
			e.end = Integer.parseInt(s[1]);
			e.meters = Double.parseDouble(s[2]);
			e.footsteps = Integer.parseInt(s[3]);
			adjList.get(e.start).add(e);
			adjList.get(e.end).add(e);
		    }
	    }
	catch (Exception e)
	    {
		throw new RuntimeException(e);
	    }
    }
}
