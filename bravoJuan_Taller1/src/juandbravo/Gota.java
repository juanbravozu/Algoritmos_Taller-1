package juandbravo;

import processing.core.PApplet;

public class Gota {

	PApplet app;
	float x;
	float y;
	float vel;
	float tam;
	
	//Las gotas se crean en posiciones aleatorias arriba del lienzo
	public Gota(PApplet app) {
		this.app = app;
		x = app.random(app.width);
		y = app.random(-800, -100);
		vel = app.random(4, 10);
		tam = app.random(10, 20);
	}
	
	//Pinta la gota
	public void pintar() {
		app.stroke(66, 183, 224);
		app.strokeWeight(1);
		app.line(x, y, x, y + tam);
	}
	
	//Hace que la gota caiga
	public void caer() {
		y += vel;
		vel += 0.02;
		
		if(y > app.height) {
			y = app.random(-800, -100);
			vel = app.random(4, 10);
		}
	}
}
