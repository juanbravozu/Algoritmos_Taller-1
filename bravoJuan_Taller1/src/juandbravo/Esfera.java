package juandbravo;

import processing.core.PApplet;
import processing.core.PVector;

public class Esfera {

	private PApplet app;
	private PVector pos;
	private PVector vel;
	private int tam;
	
	public Esfera(PApplet app) {
		this.app = app;
		pos = new PVector(app.random(app.width), app.random(app.height));
		vel = new PVector(app.random(1, 2), app.random(1, 2));
		tam = (int)app.random(30, 80);
	}
	
	public void pintar() {
		app.fill(255, 200);
		app.noStroke();
		app.ellipse(pos.x, pos.y, tam, tam);
	}
	
	public void mover() {
		pos.add(vel);
		if(pos.x < 0 || pos.x > app.width) {
			vel.set(-vel.x, vel.y);
		}
		
		if(pos.y < 0 || pos.y > app.height) {
			vel.set(vel.x, -vel.y);
		}
	}
	
	public boolean validarClick(float mx, float my) {
		if(app.dist(pos.x, pos.y, mx, my) < tam/2) {
			return true;
		} else {
			return false;
		}
	}
}
