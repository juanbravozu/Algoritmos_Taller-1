package juandbravo;

import processing.core.PApplet;

public class Negacion extends Etapa {

	private int opacidad;
	private String[] palabras;
	
	public Negacion(PApplet app, String texto) {
		super(app);
		palabras = app.splitTokens(texto);
		for (int i = 0; i < palabras.length; i++) {
			System.out.println(palabras[i]);
		}
	}
	
	public void pintar() {
		app.background(0);
		app.fill(232, 203, 141);
		app.noStroke();
		app.quad(x, y+150, x+200, y+210, x, y+180, x-200, y+210);
	}
	
	public void click() {
		
	}
}
