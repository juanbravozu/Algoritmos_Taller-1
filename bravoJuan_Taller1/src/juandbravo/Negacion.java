package juandbravo;

import processing.core.PApplet;

public class Negacion extends Etapa {

	private int opacidad;
	private String[] palabras;
	
	public Negacion(PApplet app, String texto) {
		super(app);
		palabras = app.splitTokens(texto);
		opacidad = 255;
	}
	
	public void pintar() {
		app.background(0);
		pintarCara();
		app.fill(70);
		app.textAlign(app.CENTER);
		app.textSize(20);
		app.text("Presiona ESPACIO para continuar", x, y+300);
		for (int i = 0; i < palabras.length; i++) {
			if(i != 0 && i != palabras.length-1) {
				if(palabras[i+1] == " " && palabras[i] == " " && palabras[i-1] == " ") {
					opacidad--;
				}
			}
			
		}
	}
	
	public void pintarCara() {
		app.fill(160, opacidad);
		app.noStroke();
		app.quad(x, y+160, x+200, y+195, x, y+180, x-200, y+195);
		app.triangle(x+50, y+65, x, y-120, x, y+40);
		app.fill(135, opacidad);
		app.quad(x, y+40, x+50, y+65, x, y+80, x-50, y+65);
		app.fill(240, opacidad);
		app.quad(x+70, y-195, x+150, y-250, x+230, y-205, x+150, y-150);
		app.quad(x-70, y-195, x-150, y-250, x-230, y-205, x-150, y-150);
		app.fill(181, 10, 10);
		app.quad(x-400, y-240, x+450, y-245, x+350, y-190, x-350, y-190);
		app.quad(x-500, y-160, x+400, y-165, x+350, y-195, x-350, y-190);
	}
	
	public void tecla() {
		if(app.key == ' ') {
			for (int i = 0; i < palabras.length; i++) {
				if(i != 3 && i != 10 && i != 11 && i != 12) {
					palabras[i] = " ";
					texto = app.join(palabras, ' ');
				}
			}
		}
	}
	
	public int getOpacidad() {
		return opacidad;
	}
}
