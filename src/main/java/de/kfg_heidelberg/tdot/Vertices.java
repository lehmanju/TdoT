package de.kfg_heidelberg.tdot;

import java.io.*;
import java.util.*;

public class Vertices
{
    public static HashMap<Integer, Vertex> map;
    static
    {
	map = new HashMap<>();
	try (BufferedReader in = new BufferedReader(new InputStreamReader(Vertices.class.getResourceAsStream("rooms.txt"))))
	    {
		System.out.println("Reading vertices from file rooms.txt");
		String line;
		while ((line = in.readLine()) != null)
		    {
			line = line.trim();
			if (line.startsWith("#"))
			    continue;
			String s[] = line.split("\\s");
			if (s.length != 6)
			    {
				System.out.println("Syntax error in rooms.txt in line: " + line);
				continue;
			    }
			Vertex v = new Vertex();
			v.visible = Boolean.parseBoolean(s[0]);
			v.roomId = Integer.parseInt(s[1]);
			v.roomName = s[2].replace('_', ' ');
			v.cardId = Integer.parseInt(s[3]);
			v.cardX = Integer.parseInt(s[4]);
			v.cardY = Integer.parseInt(s[5]);
			map.put(v.roomId, v);
		    }
	    }
	catch (Exception e)
	    {
		throw new RuntimeException(e);
	    }
    }

    public static Vertex findRoom (int id)
    {
	return map.get(id);
    }
}
