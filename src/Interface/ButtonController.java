package Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JButton;

public class ButtonController {

	//LinkedList<Button> buttonMap;
	Button [][] ButtonMatrix;
	int boardSize;
	
	public ButtonController(int boardSize) {
		//buttonMap = new LinkedList<Button>();
		ButtonMatrix = new Button[boardSize][boardSize];  
		this.boardSize = boardSize;
	}
	
	
	public LinkedList<int[]> activeButton(int row, int column){
		General.buttonPressed();
		LinkedList<int[]> result = new LinkedList<int[]>();
		//Button button = buttonMap.get(Integer.parseInt(JButtonName));
		Button button = ButtonMatrix[row][column];
		button.changeColor();
		if (colorMatch(button,neighborhood(row, column))) {
			neighborsOFF(row,column);
			result = neighborCoords(row, column);
			return result;
		}
		else
			if (fullGrid()) {
				winSequence();
			}
		return result;
	}

	public void addNewButton(int row, int column) {
		Button newButton = new Button();
		//buttonMap.add(newButton.buttonID, newButton);
		ButtonMatrix [row][column] = newButton;
	}

	private ArrayList<Button> neighborhood(int row, int column){
		
		ArrayList<Button> list = new ArrayList<Button>();
		
		if (column > 0) { 
			list.add(ButtonMatrix[row][column-1]);
		}
		
		if (column < boardSize-1) {
			list.add(ButtonMatrix[row][column+1]);
		}
		
		if (row > 0) {
			list.add(ButtonMatrix[row-1][column]);
		}
		
		if (row < boardSize-1) {
			list.add(ButtonMatrix[row+1][column]);
		}
		
		return list; 
	}
	
	private LinkedList<int[]> neighborCoords(int row, int column){
		
		LinkedList<int[]> list = new LinkedList<int[]>();
		int[] temp = new int[2];
		int[] temp2 = new int[2];
		int[] temp3 = new int[2];
		int[] temp4 = new int[2];
		if (column > 0) { 
			temp[0] = row;
			temp[1] = column-1;
			list.add(temp);
		}
		
		if (column < boardSize-1) {
			temp2[0] = row;
			temp2[1] = column+1;
			list.add(temp2);
		}
		
		if (row > 0) {
			temp3[0] = row-1;
			temp3[1] = column;
			list.add(temp3);
		}
		
		if (row < boardSize-1) {
			temp4[0] = row+1;
			temp4[1] = column;
			list.add(temp4);
		}
		return list; 
	}
	
	private boolean neighborON(Button neighbor){
	
			if(neighbor.color != COLOR.gray) {
				return true;
			}
		return false;
	}
	
	private void neighborsOFF(int row, int column) {
		Button button = ButtonMatrix[row][column];
		if (colorMatch(button, neighborhood(row, column))) {
			
			button.turnOff();
			for (Button neighbor : neighborhood(row, column)) {
				neighbor.turnOff();
			}
		}
	}
	
	private boolean colorMatch(Button button, ArrayList<Button> neighborhood) {
		
		for (Button neighbor : neighborhood) {
			if (neighborON(neighbor) && neighbor.color == button.color) {
				return true;
			}
		}
		return false;
	}
	
	private boolean fullGrid() {
		for(int row = 0; row < ButtonMatrix.length; row++) {
			for(int column = 0; column < ButtonMatrix[0].length; column++) {
			if (ButtonMatrix[row][column].color == COLOR.gray)
				return false;
			}
		}
		return true;
	}
	
	
	private void winSequence() {
		System.out.println(General.clicks);
		
	}
}


