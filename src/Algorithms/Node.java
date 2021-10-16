package Algorithms;

import java.util.ArrayList;
import java.util.List;
public class Node implements Comparable  {
	public boolean visited;
	public String name;
	public List<Edge> neighbours;
	public double distance = Double.MAX_VALUE;
	public Node previous;
     
  
    public Node(String name) {
        this.name = name;
        this.neighbours = new ArrayList<Edge>();
    }
    public void addNeighbour(Edge edge) {
        this.neighbours.add(edge);
    }
	@Override
	public int compareTo(Object node) {
        return Double.compare(this.distance, ((Node) node).distance);
	}

}
