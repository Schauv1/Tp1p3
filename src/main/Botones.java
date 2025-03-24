package main;

import java.util.HashMap;

class Botones {
	private int vertices;
	private HashMap<String, Boton> botones;
	
	public Botones(int n) {
		vertices = n;
		setBotones(new HashMap<String, Boton>());
	}

	public HashMap<String, Boton> getBotones() {
		return botones;
	}

	public void setBotones(HashMap<String, Boton> botones) {
		this.botones = botones;
	}
}
