package juandbravo;

import processing.core.PApplet;

public abstract class Etapa {

	protected PApplet app;
	protected float x;
	protected float y;
	
	public Etapa(PApplet app) {
		
	}
	
	public abstract void pintar();
	
	public boolean sigEtapa() {
		return false;
	}
}
