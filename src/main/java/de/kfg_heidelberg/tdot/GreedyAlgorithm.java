package de.kfg_heidelberg.tdot;

import java.util.*;

public class GreedyAlgorithm implements Algorithm
{
    public AlgorithmResult shortestPath (Collection<Vertex> vertices)
    {
	double len = 0;
	Vertex curr = Vertices.findRoom(0);
	if (curr == null)
	    throw new RuntimeException("Can't find room 0 wich is start & end of path");
	int prev = 0;
	while (0 < vertices.size())
	    {
		System.out.println("entering while loop, remaining " + vertices.size() + " rooms.");
		double best = Math.abs(0xdeadbeef);
		Vertex next = null;
		for (Edge e : Edges.adjList.get(curr.roomId))
		    {
			int n = e.start==curr.roomId ? e.end : e.start;
			if (n == prev)
			    continue;
			System.out.println("possible next edge is " + n + "; current best: " + best);
			Vertex v = Vertices.findRoom(n);
			if ((vertices.contains(v) || ((next==null || !next.visible) && !v.visible))
			        && e.meters < best) // TODO include footsteps
			    {
				best = e.meters;
				next = v;
			    }
		    }
		if (next == null)
		    return null;
		if (next.visible)
		    vertices.remove(next);
		prev = curr.roomId;
		len += best;
		curr = next;
	    }
	AlgorithmResult ar = new AlgorithmResult();
	ar.len = len;
	return ar;
    }
}
