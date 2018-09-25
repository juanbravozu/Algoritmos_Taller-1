package juandbravo;

import processing.core.PApplet;

public abstract class Etapa {

	protected PApplet app;
	protected float x;
	protected float y;
	protected String texto;
	
	public Etapa(PApplet app) {
		this.app = app;
		x = app.width/2;
		y = app.height/2;
	}
	
	public abstract void pintar();
	
	public boolean sigEtapa() {
		return true;
	}
	
	public String devolverTexto() {
		return texto;
	}
}
