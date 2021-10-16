package Algorithms;

// Java program for implementation of Ford Fulkerson algorithm 
import java.util.*; 
public 
class MaxFlow 
{ 
	static final int V = 6; //Number of vertices in graph public 
	Node[] nodes;
	boolean BFS( Node source, Node t) 
	{ 
		int target_number=0;
		for(int i=0; i<nodes.length; ++i) 
			nodes[i].visited=false; 

		PriorityQueue<Node> network = new PriorityQueue<Node>();
        
		source.visited=true;
		network.add(source); 
		source.previous=null;
		
		while (network.size()!=0) 
		{ 
			Node u = network.poll(); 

			for (int v=0; v<nodes.length; v++) 
			{ 
				if (nodes[v].name.equals(t.name))
				{
					target_number=v;
				}
				double current_cost=0;
				for (Edge e:u.neighbours) {
					if(e.targetNode.name.equals(nodes[v].name))
					{
						current_cost=e.weight;
					}
				}
				if (nodes[v].visited==false && current_cost > 0) 
				{ 
					nodes[v].previous=u;
					network.add(nodes[v]); 
					nodes[v].visited = true; 
				} 
			} 
		} 

		return (nodes[target_number].visited == true); 
	} 
 public 
	int getMaxFlow( Node s, Node t) 
	{ 

		int max_flow = 0; 

		while (BFS(s, t)) 
		{ 
			double path_flow = Double.MAX_VALUE; 
	        //for(Node node=targetNode;node!=null;node=node.previous){
			for (Node v=t; v!=s; v=v.previous) 
			{ 
				Node u = v.previous;
				double current_cost=Double.MAX_VALUE;
				for (Edge e:u.neighbours) {
					if(e.targetNode.name.equals(v.name))
					{
						current_cost=e.weight;
					}
				}
				path_flow = Math.min(path_flow, current_cost); 

			} 

			for (Node v=t; v!=s; v=v.previous) 
			{ 
				Node u = v.previous;
				Edge temp=new Edge();
				for (Edge e:u.neighbours) {
					if(e.targetNode.name.equals(v.name))
					{
						temp=e;
					}
				}
				temp.weight -= path_flow;
				Edge temp2=new Edge();
				for (Edge e:v.neighbours) {
					if(e.targetNode.name.equals(v.name))
					{
						temp2=e;
					}
				}
				
				temp2.weight += path_flow; 
			} 
			max_flow += path_flow; 
		} 
		return max_flow; 
	} 

	// Driver program to test above functions 
	public static void main (String[] args) throws java.lang.Exception 
	{ 

		MaxFlow m = new MaxFlow(); 
		
		Node nodes[] = new Node[6];
		Node n0=new Node("0");
		nodes[0]=n0;
		Node n1=new Node("1");
		nodes[1]=n1;
		Node n2=new Node("2");
		nodes[2]=n2;
		Node n3=new Node("3");
		nodes[3]=n3;
		Node n4=new Node("4");
		nodes[4]=n4;
		Node n5=new Node("5");
		nodes[5]=n5;
		m.nodes=nodes;
		
		n0.addNeighbour(new Edge(n0,n1,16));
		n0.addNeighbour(new Edge(n0,n2,13));
		
		n1.addNeighbour(new Edge(n1,n2,10));
		n1.addNeighbour(new Edge(n1,n3,12));
		

		n2.addNeighbour(new Edge(n2,n1,4));
		n2.addNeighbour(new Edge(n2,n4,14));
		

		n3.addNeighbour(new Edge(n3,n2,9));
		n3.addNeighbour(new Edge(n3,n5,20));
		

		n4.addNeighbour(new Edge(n4,n3,7));
		n4.addNeighbour(new Edge(n4,n5,4));
		System.out.println("The maximum possible flow is " + 
						m.getMaxFlow( n0, n5)); 

	} 
} 
