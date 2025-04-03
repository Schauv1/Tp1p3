package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InitScreen {

	private JFrame frmHysteria;
	private JTextField gridDecision;
	private JButton startButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitScreen window = new InitScreen();
					window.frmHysteria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InitScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { 
		initComponents();
		createEvents();
		
	}
	
	private void initComponents() {
		frmHysteria = new JFrame();
		frmHysteria.setTitle("Hysteria");
		frmHysteria.getContentPane().setBackground(new Color(60, 60, 60));
		frmHysteria.getContentPane().setLayout(null);
		frmHysteria.setBounds(100, 100, 450, 300);
		frmHysteria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gridDecision = new JTextField();
		gridDecision.setBounds(158, 104, 86, 20);
		frmHysteria.getContentPane().add(gridDecision);
		gridDecision.setColumns(10);
		
		startButton = new JButton("Start");
		
		startButton.setBounds(155, 143, 89, 23);
		frmHysteria.getContentPane().add(startButton);
		
		JLabel decisionLabel = new JLabel("Grid size:");
		decisionLabel.setForeground(new Color(255, 255, 255));
		decisionLabel.setBounds(102, 107, 46, 14);
		frmHysteria.getContentPane().add(decisionLabel);
	}
	
	private void createEvents() {
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int gridSize = Integer.parseInt(gridDecision.getText());
					View vw = new View(gridSize);
					frmHysteria.dispose();
					vw.frame.setVisible(true);
				} 
				catch (Exception ex) {
					gridDecision.setText("");
					JOptionPane.showMessageDialog(null, "Debes ingresar un numero (menor a 7)");
				}
			}
		});
	}
}
