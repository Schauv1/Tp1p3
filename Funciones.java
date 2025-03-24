package main;

import java.awt.Color;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JButton;

public class Funciones {
	static Botones botones;
	static HashMap<String, JButton> botones1 = new HashMap<String, JButton>();
	public static void colorChange(JButton boton) {
		Random random = new Random();
		int colorRand = random.nextInt(Colores.values().length-1);
		System.out.println(colorRand);
		int pos = Integer.parseInt(boton.getName());
		switch(colorRand) {
		case 0:
			boton.setBackground(new Color(255,0,0));
			botones.getBotones().get(boton.getName()).color = Colores.Rojo;
			break;
		case 1:
			boton.setBackground(new Color(0,0,255));
			botones.getBotones().get(boton.getName()).color = Colores.Azul;
			break;
		case 2:
			boton.setBackground(new Color(0,255,0));
			botones.getBotones().get(boton.getName()).color = Colores.Verde;
			break;
		case 3:
			boton.setBackground(new Color(255,0,255));
			botones.getBotones().get(boton.getName()).color = Colores.Violeta;
			break;
		case 4:
			boton.setBackground(new Color(255,100,0));
			botones.getBotones().get(boton.getName()).color = Colores.Naranja;
			break;
		case 5:
			boton.setBackground(new Color(255,255,0));
			botones.getBotones().get(boton.getName()).color = Colores.Amarillo;
			break;
		}
		Colores color = botones.getBotones().get(boton.getName()).color;
		if (pos+1 < botones.getBotones().size()) {
			if (botones.getBotones().get(boton.getName()).color == botones.getBotones().get((pos+1)+"").color) {
				botones.getBotones().get(boton.getName()).color = Colores.Blanco;
				botones.getBotones().get(""+(pos+1)).color = Colores.Blanco;
				boton.setBackground(new Color(255,255,255));
				eliminarVecinos(pos);
			}
		}
		if (pos-1 >= 0) {
			if (botones.getBotones().get(boton.getName()).color == botones.getBotones().get((pos-1)+"").color) {
				botones.getBotones().get(boton.getName()).color = Colores.Blanco;
				botones.getBotones().get(""+(pos-1)).color = Colores.Blanco;
				boton.setBackground(new Color(255,255,255));
				eliminarVecinos(pos);
			}
		}
		if (pos+5 < botones.getBotones().size()) {
			if (botones.getBotones().get(boton.getName()).color == botones.getBotones().get((pos+5)+"").color) {
				botones.getBotones().get(boton.getName()).color = Colores.Blanco;
				botones.getBotones().get(""+(pos+5)).color = Colores.Blanco;
				boton.setBackground(new Color(255,255,255));
				eliminarVecinos(pos);
			}
		}
		if (pos-5 >= 0) {
			if (botones.getBotones().get(boton.getName()).color == botones.getBotones().get((pos-5)+"").color) {
				botones.getBotones().get(boton.getName()).color = Colores.Blanco;
				botones.getBotones().get(""+(pos-5)).color = Colores.Blanco;
				boton.setBackground(new Color(255,255,255));
				eliminarVecinos(pos);
			}
		}
	}
	
	private static void eliminarVecinos(int pos) {
		if (pos-5 >= 0)
			botones1.get(""+(pos-5)).setBackground(new Color(255,255,255));
		if (pos+5 < botones.getBotones().size())
			botones1.get(""+(pos+5)).setBackground(new Color(255,255,255));
		if (pos-1 >= 0)
			botones1.get(""+(pos-1)).setBackground(new Color(255,255,255));
		if (pos+1 < botones.getBotones().size())
			botones1.get(""+(pos+1)).setBackground(new Color(255,255,255));
	}

	public static void addButton(JButton boton) {
		botones1.put(boton.getName(), boton);
		botones.getBotones().put(boton.getName(), new Boton(Colores.Blanco));
	}
	
	public static void iniciar() {
		botones = new Botones(25);
	}
}
