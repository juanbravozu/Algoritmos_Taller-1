package juandbravo;

import processing.core.PApplet;

public abstract class Etapa {

	protected PApplet app;
	protected float x;
	protected float y;
	protected String texto; //Línea de texto a modificar
	
	public Etapa(PApplet app) {
		this.app = app;
		x = app.width/2;
		y = app.height/2;
	}
	
	public abstract void pintar();
	
	//Retorna el texto para guardarlo en el archivo .txt
	public String devolverTexto() {
		return texto;
	}
}
