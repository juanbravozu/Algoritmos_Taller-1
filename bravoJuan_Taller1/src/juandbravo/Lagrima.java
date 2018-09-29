package juandbravo;

import processing.core.PApplet;

public class Lagrima {

	private PApplet app;
	private float x;
	private float y;
	private float vel;
	
	public Lagrima(PApplet app, float x, float y) {
		this.x = x;
		this.y = y;
		this.app = app;
	}
	
	//Pinta la lágrima
	public void pintar() {
		app.fill(0, 38, 175);
		app.noStroke();
		app.quad(x, y, x+10, y+20, x, y+30, x-10, y+20);
	}
	
	//Hace que la lágrima caiga
	public void mover() {
		y += vel;
		vel += 0.2;
	}
	
	//Verifica si la lágrima cayó fuera del lienzo
	public boolean borrar() {
		if(y > app.height) {
			return true;
		} else {
			return false;
		}
	}
}
