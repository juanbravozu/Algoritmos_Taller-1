package juandbravo;

import java.util.Iterator;
import java.util.LinkedList;

import processing.core.PApplet;

public class Aceptacion extends Etapa {

	private LinkedList<Esfera> esferas;
	private float fondo;
	private int opacidad;
	private String[] palabras;
	private int contador;
	
	public Aceptacion(PApplet app, String texto) {
		super(app);
		fondo = 0;
		contador = 0;
		esferas = new LinkedList<Esfera>();
		for(int i = 0; i < 10; i++) {
			esferas.add(new Esfera(app));
		}
		palabras = app.splitTokens(texto);
	}
	
	//Pinta los elementos, cuando el fondo es blanco, la cara aparece lentamente
	public void pintar() {
		texto = app.join(palabras, ' ');
		for (int i = 0; i < contador; i++) {
			StringBuffer temp = new StringBuffer();
			if(palabras[i].charAt(1) != ' ') {
				for (int j = 0; j < palabras[i].length(); j++) {
					temp.append(palabras[i].charAt(j));
					temp.append(' ');
				}
				palabras[i] = temp.toString();
			}			
		}
		
		app.background(fondo);
		Iterator<Esfera> it = esferas.iterator();
		while(it.hasNext()) {
			Esfera e = it.next();
			e.mover();
			e.pintar();
		}
		
		if(fondo >= 250) {
			pintarCara();
			opacidad++;
			if(opacidad >= 255) {
				app.fill(0);
				app.textAlign(app.CENTER);
				app.text("Presiona ESPACIO para terminar", x, y + 300);
			}
		}
	}
	
	//Interacciones con el mouse, aclara el fondo al clickear las esferas
	public void click() {
		Iterator<Esfera> it = esferas.iterator();
		while(it.hasNext()) {
			Esfera e = it.next();
			if(e.validarClick(app.mouseX, app.mouseY)) {
				it.remove();
				fondo += 25.5;
				contador++;
			}
		}
		
		
	}
	
	//Pinta la cara
	public void pintarCara() {
		app.fill(242, 202, 157, opacidad);
		app.noStroke();
		app.quad(x, y+160, x+200, y+145, x, y+180, x-200, y+145);
		app.triangle(x+50, y+65, x, y-120, x, y+40);
		app.quad(x+70, y-205, x+180, y-170, x+280, y-195, x+180, y-150);
		app.quad(x-70, y-205, x-180, y-170, x-280, y-195, x-180, y-150);
		app.fill(204, 162, 116, opacidad);
		app.quad(x, y+40, x+50, y+65, x, y+80, x-50, y+65);		
	}
	
	public int getOpacidad() {
		return opacidad;
	}
}
