package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 544);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 61, 139));
		panel.setBounds(0, 0, 315, 497);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Button button = new Button("Dijkstra");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DijkstraGui lw=new DijkstraGui();
				lw.setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(72, 61, 139));
		button.setBounds(387, 300, 277, 51);
		contentPane.add(button);
		
		Button button_1 = new Button("MaxFlow");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaxFlowGui Rp=new MaxFlowGui();
				Rp.setVisible(true);
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setActionCommand("SignUp");
		button.setForeground(Color.WHITE);
		button_1.setBackground(new Color(72, 61, 139));
		button_1.setBounds(387, 368, 277, 51);
		contentPane.add(button_1);
		
		JLabel lblDrMostafaReda = new JLabel("Choose Your Algorithms");
		lblDrMostafaReda.setBounds(397, 148, 267, 50);
		contentPane.add(lblDrMostafaReda);
		lblDrMostafaReda.setBackground(new Color(0, 0, 0));
		lblDrMostafaReda.setForeground(new Color(0, 0, 0));
		lblDrMostafaReda.setFont(new Font("Javanese Text", Font.BOLD, 20));
	}
}


