package de.kfg_heidelberg.tdot;

public class Vertex
{
    public boolean visible;
    public int roomId;
    public String roomName;
    public int cardId;
    public int cardX;
    public int cardY;

    public int hashCode() { return roomId; }
    public String toString() { return "Vertex[id=" + roomId + ";name=" + roomName + "]"; }
}
