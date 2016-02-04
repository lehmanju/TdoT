package de.kfg_heidelberg.tdot;

public class Main
{
    public static void main (String args[])
    {
	System.out.println("Alle Räume:           " + Vertices.map.size());
	System.out.println("Räume in der adjList: " + Edges.adjList.size());
    }
}
