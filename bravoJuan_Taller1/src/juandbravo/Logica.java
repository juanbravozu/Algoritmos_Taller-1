package juandbravo;

import processing.core.PApplet;

public class Logica {
	
	private PApplet app;
	private int etapa;
	private Etapa[] etapas;
	
	public Logica(PApplet app) {
		etapas = new Etapa[5];
		etapas[0] = new Negacion(app);
	}
	
	public void dibujar() {
		
	}
	
	public void click() {
		
	}
	
	public void clickMan() {
		
	}
	
	public void tecla() {
		
	}
}
