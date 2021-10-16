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

import Algorithms.Edge;
import Algorithms.MaxFlow;
import Algorithms.Node;

import java.awt.TextArea;
import java.awt.SystemColor;

public class MaxFlowGui extends JFrame {

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
					MaxFlowGui frame = new MaxFlowGui();
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
	public MaxFlowGui() {setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 807, 650);
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBackground(SystemColor.textHighlight);
	panel.setBounds(0, 13, 791, 135);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JLabel lblMinimumDistance = new JLabel("Maximum");
	lblMinimumDistance.setForeground(Color.WHITE);
	lblMinimumDistance.setFont(new Font("Ink Free", Font.BOLD, 25));
	lblMinimumDistance.setBounds(313, 13, 116, 50);
	panel.add(lblMinimumDistance);
	
	JLabel lblFlow = new JLabel("Flow");
	lblFlow.setForeground(Color.WHITE);
	lblFlow.setFont(new Font("Ink Free", Font.BOLD, 25));
	lblFlow.setBounds(347, 45, 72, 50);
	panel.add(lblFlow);
	JTextField nNodes = new JTextField();
	nNodes .setBounds(29, 174, 176, 41);
	contentPane.add(nNodes );
	nNodes .setColumns(10);
	JSeparator separator = new JSeparator();
	separator.setBounds(404, 98, 262, -7);
	contentPane.add(separator);
	
	JLabel lblNumberOfNodes = new JLabel("Number of nodes");
	lblNumberOfNodes.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	lblNumberOfNodes.setBounds(36, 148, 169, 24);
	contentPane.add(lblNumberOfNodes);
	
	nEdges = new JTextField();
	nEdges .setColumns(10);
	nEdges .setBounds(217, 174, 176, 41);
	contentPane.add(nEdges );
	
	JLabel lblNumberOfEdges = new JLabel("Number of edges");
	lblNumberOfEdges.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	lblNumberOfEdges.setBounds(230, 148, 169, 24);
	contentPane.add(lblNumberOfEdges);
	
	TextArea textArea = new TextArea();
	textArea.setBounds(565, 325, 219, 244);
	contentPane.add(textArea);
	
	JLabel lblEnterNodesAs = new JLabel("Enter edges like => from to weight");
	lblEnterNodesAs.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	lblEnterNodesAs.setBounds(565, 295, 219, 24);
	contentPane.add(lblEnterNodesAs);
	
	TextArea Egdes = new TextArea();
	Egdes.setBounds(10, 325, 219, 244);
	contentPane.add(Egdes);
	
	JLabel lblEnterVerticesNames = new JLabel("Enter nodes names each in a line");
	lblEnterVerticesNames.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	lblEnterVerticesNames.setBounds(10, 295, 214, 24);
	contentPane.add(lblEnterVerticesNames);
	
	TextArea outputArea = new TextArea();
	outputArea.setFont(new Font("French Script MT", Font.PLAIN, 15));
	outputArea.setBounds(235, 325, 324, 181);
	contentPane.add(outputArea);
	
	JLabel lblOutputArea = new JLabel("Output Area ");
	lblOutputArea.setBounds(345, 295, 90, 24);
	contentPane.add(lblOutputArea);
	
	sourceNode = new JTextField();
	sourceNode.setColumns(10);
	sourceNode.setBounds(404, 174, 176, 41);
	contentPane.add(sourceNode);
	
	JLabel lblEnterTargetNode = new JLabel("Enter source node name");
	lblEnterTargetNode.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	lblEnterTargetNode.setBounds(420, 148, 169, 24);
	contentPane.add(lblEnterTargetNode);
	
	destinationNode = new JTextField();
	destinationNode.setColumns(10);
	destinationNode.setBounds(592, 174, 176, 41);
	contentPane.add(destinationNode);
	
	JLabel label_1 = new JLabel("Enter target node name");
	label_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	label_1.setBounds(611, 148, 169, 24);
	contentPane.add(label_1);
	
	Button button = new Button("Run");
	button.setBounds(292, 523, 199, 57);
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
			Node allNodes[]=new Node[nOfNodes];
			int ni=0;
			for( int i=0;i<tokens.length;i++) {
				Node v= new Node(tokens[i]);
				Nodes.put(tokens[i],v);		
				allNodes[ni++]=v;
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
			
			String target=destinationNode.getText();
			Node t=Nodes.get(target);
			
			MaxFlow MF = new MaxFlow();
			MF.nodes=allNodes;
			int maxFlow=MF.getMaxFlow( source, t);
			
			output+=("The maximum possible flow is " + maxFlow);
			System.out.println("The maximum possible flow is " +maxFlow); 
			output+="\n";
			
			outputArea.setText(output);
		}
	});
	
	}
}


/**
0 1 16
0 2 13
1 2 10
1 3 12
2 1 4
2 4 14
3 2 9
3 5 20
4 3 7
4 5 4

0
1
2
3
4
5
**/