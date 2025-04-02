package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class View {

	JFrame frame;
	/**
	 * Create the application.
	 */
	public View(int size) {
		if (size > 7)
			throw new IllegalArgumentException("");
		initialize(size);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int i) { // i = número de filas y columnas
		
		//Creo un diccionario con los JButtons
		LinkedList <JButton> jButtonMap = new LinkedList<JButton>();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(60, 60, 60));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(i, i, 1, 1));
		
	
		//Creamos un presentador
		ButtonController buttonController = new ButtonController(i);
		
		//Creamos todos los botones y los agregamos al diccionario jButtonMap
		for(int j = 0; j < i*i; j++) {
			JButton button = new JButton("");
			button.setBackground(new Color(50,50,50));
			frame.getContentPane().add(button);
			button.setName("" + j);
			jButtonMap.add(button);
		//Creamos el objeto Button asociado al JButton
			buttonController.addNewButton(button.getName(), button);
		}
		
		//Recorremos los JButtons informando al buttonController cuando uno esté activo
		for(JButton button : jButtonMap) {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonController.activeButton(button.getName());
				}
			});
		}	
	}
}
