package GUI;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Algorithms.Dijkstra;
import Algorithms.Edge;
import Algorithms.Node;

import java.awt.TextArea;
import java.awt.SystemColor;

public class DijkstraGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nEdges;
	private JTextField sourceNode;
	private JTextField destinationNode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DijkstraGui frame = new DijkstraGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DijkstraGui() {setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 792, 630);
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBackground(SystemColor.textHighlight);
	panel.setBounds(12, 13, 755, 135);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JLabel lblShortestPath = new JLabel("Shortest Path");
	lblShortestPath.setForeground(Color.WHITE);
	lblShortestPath.setFont(new Font("Lucida Handwriting", Font.BOLD, 20));
	lblShortestPath.setBounds(230, 13, 177, 50);
	panel.add(lblShortestPath);
	
	JLabel lblMinimumDistance = new JLabel("Minimum Distance");
	lblMinimumDistance.setForeground(Color.WHITE);
	lblMinimumDistance.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
	lblMinimumDistance.setBounds(299, 47, 217, 50);
	panel.add(lblMinimumDistance);
	JTextField nNodes = new JTextField();
	nNodes .setBounds(12, 174, 176, 41);
	contentPane.add(nNodes );
	nNodes .setColumns(10);
	JSeparator separator = new JSeparator();
	separator.setBounds(404, 98, 262, -7);
	contentPane.add(separator);
	
	JLabel lblNumberOfNodes = new JLabel("Number of nodes");
	lblNumberOfNodes.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	lblNumberOfNodes.setBounds(40, 148, 169, 24);
	contentPane.add(lblNumberOfNodes);
	
	nEdges = new JTextField();
	nEdges .setColumns(10);
	nEdges .setBounds(200, 174, 176, 41);
	contentPane.add(nEdges );
	
	JLabel lblNumberOfEdges = new JLabel("Number of edges");
	lblNumberOfEdges.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	lblNumberOfEdges.setBounds(218, 148, 169, 24);
	contentPane.add(lblNumberOfEdges);
	
	TextArea textArea = new TextArea();
	textArea.setBounds(549, 325, 214, 244);
	contentPane.add(textArea);
	
	JLabel lblEnterNodesAs = new JLabel("Enter edges like => from to weight");
	lblEnterNodesAs.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	lblEnterNodesAs.setBounds(549, 295, 214, 24);
	contentPane.add(lblEnterNodesAs);
	
	TextArea Egdes = new TextArea();
	Egdes.setBounds(12, 325, 214, 244);
	contentPane.add(Egdes);
	
	JLabel lblEnterVerticesNames = new JLabel("Enter nodes names each in a line");
	lblEnterVerticesNames.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	lblEnterVerticesNames.setBounds(12, 295, 214, 24);
	contentPane.add(lblEnterVerticesNames);
	
	TextArea outputArea = new TextArea();
	outputArea.setFont(new Font("French Script MT", Font.PLAIN, 15));
	outputArea.setBounds(232, 325, 311, 181);
	contentPane.add(outputArea);
	
	JLabel lblOutputArea = new JLabel("Output Area ");
	lblOutputArea.setBounds(340, 295, 90, 24);
	contentPane.add(lblOutputArea);
	
	sourceNode = new JTextField();
	sourceNode.setColumns(10);
	sourceNode.setBounds(388, 174, 176, 41);
	contentPane.add(sourceNode);
	
	JLabel lblEnterTargetNode = new JLabel("Enter source node name");
	lblEnterTargetNode.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	lblEnterTargetNode.setBounds(427, 148, 169, 24);
	contentPane.add(lblEnterTargetNode);
	
	destinationNode = new JTextField();
	destinationNode.setColumns(10);
	destinationNode.setBounds(576, 174, 176, 41);
	contentPane.add(destinationNode);
	
	JLabel label_1 = new JLabel("Enter target node name");
	label_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	label_1.setBounds(615, 148, 169, 24);
	contentPane.add(label_1);
	
	Button button = new Button("Run");
	button.setBounds(286, 512, 199, 57);
	contentPane.add(button);
	button.setForeground(Color.WHITE);
	button.setBackground(new Color(241, 57,83));
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			int nOfNodes, nOfEdges;
			String output="";
			if( !nNodes.getText().equals("") && !nEdges.getText().equals(""))
			{
				nOfNodes=Integer.parseInt(nNodes.getText());
				nOfEdges=Integer.parseInt(nEdges.getText());
				
			}
			else
			{
				outputArea.setText("Please Enter number of Nodes and Edges first.");
				System.out.println("Please Enter number of Nodes and Edges first.");
				return;
			}
			
			Map<String,Node> Nodes=new HashMap<String,Node>();
			String tA=Egdes.getText().replaceAll("(\\t|\\r?\\n)+", " ");
			String []tokens=tA.split(" ");
			String source_name=sourceNode.getText();
			for( int i=0;i<tokens.length;i++) {
				Node v= new Node(tokens[i]);
				Nodes.put(tokens[i],v);		
				
			}
			
			tA=textArea.getText().replaceAll("(\\t?\\n)+", " ");
			tokens=tA.split(" ");
			for( int i=0;i<tokens.length-1;i++) {
				Node source;
				if(Nodes.containsKey(tokens[i]))
				{
					source=Nodes.get(tokens[i]);
				}
				else
				{
					System.out.println("You've entered: "+tokens[i]+" which is invalid node name.");
					outputArea.setText("You've entered: "+tokens[i]+" which is invalid node name.");
					return;
				}
				Node dest;
				if(Nodes.containsKey(tokens[i+1]))
				{
					dest=Nodes.get(tokens[i+1]);
				}
				else
				{
					System.out.println("You've entered: "+tokens[i+1]+" which is invalid node name.");
					outputArea.setText("You've entered: "+tokens[i+1]+" which is invalid node name.");
					return;
				}
				Double cost=Double.parseDouble(tokens[i+2]);
				Nodes.get(tokens[i]).addNeighbour(new Edge(source,dest,cost));				
				i+=2;
			}
			
			Node source=Nodes.get(source_name);
			
			
			Dijkstra dij = new Dijkstra();
			dij.calculateSourceNetworkDistances(source);
			String target=destinationNode.getText();
			Node t=Nodes.get(target);
			
			output+=("Minimum distance from: "+source_name+" to node: "+t.name+" is: "+t.distance+'\n');
			System.out.println("Minimum distance from: "+source_name+" to node: "+t.name+" is: "+t.distance+'\n');
			
			java.util.List<Node>  path = dij.getShortestPathTo(t) ;
			
			output+=("Shortest Path from node: "+source_name+" to node: "+t.name+" => ");
			System.out.print("Shortest Path from node: "+source_name+" to node: "+t.name+" => ");
			for ( Node p : path) {
				output+= (p.name +" ");
				System.out.print(p.name +" ");
			}
			output+="\n";
			
			outputArea.setText(output);
		}
	});
	
	}
}
