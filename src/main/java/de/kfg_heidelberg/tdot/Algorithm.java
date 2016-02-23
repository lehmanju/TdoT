package de.kfg_heidelberg.tdot;

import java.util.*;

public interface Algorithm
{
    public static class AlgorithmResult
    {
	public Collection<Edge> edges;
	public double len;
    }
    
    public AlgorithmResult shortestPath (Collection<Vertex> vertices);
}
