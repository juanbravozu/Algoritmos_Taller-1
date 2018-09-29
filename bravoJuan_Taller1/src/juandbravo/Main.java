package juandbravo;

import processing.core.PApplet;

public class Main extends PApplet {

	private Logica log;
	
	public static void main(String[] args) {
		PApplet.main("juandbravo.Main");
	}
	
	public void settings() {
		size(1200, 700);
	}
	
	public void setup() {
		log = new Logica(this);
		textSize(16);
	}
	
	public void draw() {
		log.dibujar();
	}
	
	public void mousePressed() {
		log.click();
	}
	
	public void keyPressed() {
		log.tecla();
	}

}
