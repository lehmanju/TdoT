package de.kfg_heidelberg.tdot;

public class Edge
{
    public int start, end;
    public double meters;
    public int footsteps;

    public int hashCode() { return start ^ end; }
    public String toString() { return "Edge[" + start + "-" + end + "]"; }
}
