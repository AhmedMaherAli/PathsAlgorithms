package Algorithms;

public class Edge {
	
    public double weight;
    public Node sourceNode;
    public Node targetNode;
    public Edge() {} 
    public Edge( Node sourceNode, Node targetNode, double weight) {
        this.weight = weight;
        this.sourceNode = sourceNode;
        this.targetNode = targetNode;
    }
}