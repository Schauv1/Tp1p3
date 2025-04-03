package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class View {

	JFrame frame;
	int gridSize;
	JButton[][] JButtonMatrix;
	ButtonController buttonController;
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
		//LinkedList <JButton> jButtonMap = new LinkedList<JButton>();
		gridSize = i;
		JButtonMatrix = new JButton[i][i];
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(60, 60, 60));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(i, i, 1, 1));
		
	
		//Creamos un presentador
		buttonController = new ButtonController(i);
		
		//Creamos todos los botones y los agregamos al diccionario jButtonMap
		for(int row = 0; row < JButtonMatrix.length; row++) {
			for(int column = 0; column < JButtonMatrix[0].length; column++) {
			JButton button = new JButton("");
			button.setBackground(new Color(50,50,50));
			frame.getContentPane().add(button);
			//button.setName("" + j);
			//jButtonMap.add(button);
			JButtonMatrix[row][column] = button;
		//Creamos el objeto Button asociado al JButton
			buttonController.addNewButton(row,column);
		 }
		}
		
		//Recorremos los JButtons informando al buttonController cuando uno esté activo
		for(int row = 0; row < JButtonMatrix.length; row++) {
			for(int column = 0; column < JButtonMatrix[0].length; column++) {
				int r=row;
				int c=column;
				JButtonMatrix[row][column].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LinkedList<int[]> temp1 = buttonController.activeButton(r,c);
					if (!temp1.isEmpty()) {
						for (int[] coord: temp1) {
							JButtonMatrix[coord[0]][coord[1]].setBackground(new Color(50, 50, 50));
							JButtonMatrix[r][c].setBackground(new Color(50, 50, 50));
						}
					}
					if (temp1.isEmpty()) {
						updateViews(r, c);
					}
					//updateViews(r, c);
					}
				});
			}
		}
	}

	private void updateViews(int r, int c) {
		COLOR color = buttonController.ButtonMatrix[r][c].color; 
		switch(color) {
		case red:
			JButtonMatrix[r][c].setBackground(new Color(255,0,0));
			break;
		case blue:
			JButtonMatrix[r][c].setBackground(new Color(0,0,255));
			break;
		case green:
			JButtonMatrix[r][c].setBackground(new Color(0,255,0));
			break;
		case yellow:
			JButtonMatrix[r][c].setBackground(new Color(255,255,0));
			break;
		case cyan:
			JButtonMatrix[r][c].setBackground(new Color(0,255,255));
			break;
		case magenta:
			JButtonMatrix[r][c].setBackground(new Color(255,0,255));
			break;
		}
	}
	/*	
private ArrayList<JButton> getNeighbor(int row, int column){
		
		ArrayList<JButton> list = new ArrayList<JButton>();
		
		if (column > 0) { 
			list.add(JButtonMatrix[row][column-1]);
		}
		
		if (column < gridSize-1) {
			list.add(JButtonMatrix[row][column+1]);
		}
		
		if (row > 0) {
			list.add(JButtonMatrix[row-1][column]);
		}
		
		if (row < gridSize-1) {
			list.add(JButtonMatrix[row+1][column]);
		}
		
		return list; 
	}
	*/
}
