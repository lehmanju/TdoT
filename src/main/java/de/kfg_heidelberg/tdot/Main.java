package de.kfg_heidelberg.tdot;

import java.util.*;
import java.util.stream.*;

public class Main
{
    public static void main (String args[])
    {
	System.out.println("Alle Räume:           " + Vertices.map.size());
	System.out.println("Räume in der adjList: " + Edges.adjList.size());
	Algorithm a = new GreedyAlgorithm();
        Algorithm.AlgorithmResult ar = a.shortestPath(
	  Arrays.asList(101,102,052,407)
	    .stream()
            .map((i) -> Vertices.findRoom(i))
	    .collect(Collectors.toList()));
	System.out.println("Computed Way (len):   " + (ar==null ? "null" : ar.len));
    }
}
