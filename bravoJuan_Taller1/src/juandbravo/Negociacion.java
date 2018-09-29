package juandbravo;

import processing.core.PApplet;

public class Negociacion extends Etapa {

	private int fondo;
	private String[] palabras;
	private float ang;
	private int opacidad;
	private float x1, y1;
	private float x2, y2;
	
	public Negociacion(PApplet app, String texto) {
		super(app);
		fondo = 45;
		palabras = app.splitTokens(texto);
		ang = 0;
	}
	
	//Pinta los elementos 
	public void pintar() {
		app.background(fondo);
		app.fill(40, opacidad);
		app.textAlign(app.CENTER);
		
		app.text("Usa las FLECHAS para interactuar", x, y+310);
		app.text("Presiona ESPACIO para continuar", x, y+330);
		if(fondo != 0) { //Transicion entre etapa anterior y esta
			fondo--;
		} else if(opacidad+2 < 255) {
			opacidad += 2;
		}
		pintarBal();
		rotar();
		if(!app.keyPressed) {
			palabras[12] = "pros";
			palabras[14] = "contras";
		}
	}
	
	//Interacciones con el teclado
	public void tecla() {
		if(app.keyCode == app.LEFT) {
			palabras[12] = "####";
			palabras[14] = "contras";
			texto = app.join(palabras, ' ');			
		} else if(app.keyCode == app.RIGHT) {
			palabras[14] = "???????";
			palabras[12] = "pros";	
			texto = app.join(palabras, ' ');
		}
	}
	
	//Cambia el ángulo de rotacion
	public void rotar() {
		for (int i = 0; i < palabras.length; i++) {
			if(palabras[i] == "####" && ang > -45) {
				ang -= 0.4;
			} else if(palabras[i] == "???????" && ang < 45) {
				ang += 0.4;
			}
		}
	}
	
	//Pinta la balanza y rota algunas partes de esta
	public void pintarBal() {
		app.noStroke();
		app.fill(214, 115, 10, opacidad);
		app.rectMode(app.CENTER);
		app.rect(x, y, 20, 550);
		app.quad(x-10, y+275, x-150, y+290, x+150, y+290, x+10, y+275);
		app.ellipse(x, y-275, 50, 50);
		
		app.pushMatrix();
		app.translate(x, y-240);
		app.rotate(app.radians(ang));
		x1 = 400 * app.cos(app.radians(ang));
		x2 = -400 * app.cos(app.radians(ang));
		y1 = 400 * app.sin(app.radians(ang));
		y2 = -400 * app.sin(app.radians(ang));
		app.rect(0, 0, 800, 10);
		app.popMatrix();
		
		app.pushMatrix();
		app.translate(x, y-240);
		app.ellipse(x1, y1, 30, 30);
		app.ellipse(x2, y2, 30, 30);
		app.stroke(214, 115, 10, opacidad);
		
		app.line(x1, y1, x1, y1+150);
		app.line(x1, y1+150, x1-80, y1+230);
		app.line(x1, y1+150, x1+80, y1+230);
		app.fill(0, 38, 175, opacidad);
		app.noStroke();
		app.ellipse(x1, y1+215, 60, 60);
		app.fill(214, 115, 10, opacidad);
		app.arc(x1, y1+230, 160, 30, 0, app.PI);
		
		app.stroke(214, 115, 10, opacidad);
		app.line(x2, y2, x2, y2+150);
		app.line(x2, y2+150, x2-80, y2+230);
		app.line(x2, y2+150, x2+80, y2+230);
		app.fill(175, 38, 0, opacidad);
		app.noStroke();
		app.rect(x2, y2+214, 60, 60);
		app.fill(214, 115, 10, opacidad);
		app.arc(x2, y2+230, 160, 30, 0, app.PI);
		app.popMatrix();
	}
}
