package Algorithms;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Dijkstra {
	
	public void calculateSourceNetworkDistances(Node source){
        PriorityQueue<Node> network = new PriorityQueue<Node>();
        
		source.distance=0;			
        source.visited=true;
        network.add(source);
        while( !network.isEmpty() )
        {
    
        	Node currentNode = network.poll();
            List<Edge> edgs=currentNode .neighbours;
            for(Edge edge : edgs)
            {
            	Node n = edge.targetNode;
                if(!n.visited)
                {
                	
                	
                        double newDistance = currentNode .distance + edge.weight;
                        if( newDistance < n.distance )
                        {
	                        n.distance=newDistance;
	                        n.previous=currentNode ;
	                        network.add(n);
                        }
                
                }
            }
            currentNode.visited=true;
        }
    }
  
    public List<Node> getShortestPathTo(Node targetNode)
    {
    	
        List<Node> path = new ArrayList<Node>();
        for(Node node=targetNode;node!=null;node=node.previous){
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }

}