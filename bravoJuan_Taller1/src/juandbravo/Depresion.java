package juandbravo;

import java.util.Iterator;
import java.util.LinkedList;

import processing.core.PApplet;

public class Depresion extends Etapa {

	private LinkedList<Lagrima> lagrimas;
	private String[] palabras;
	
	public Depresion(PApplet app, String texto) {
		super(app);
		palabras = app.splitTokens(texto);
		lagrimas = new LinkedList<Lagrima>();
	}
	
	//Pinta los elementos
	public void pintar() {
		texto = app.join(palabras,' ');
		app.background(0);
		app.fill(25);
		app.textAlign(app.CENTER);
		app.text("CLICK para interactuar", x, y+300);
		app.text("Presiona ESPACIO para continuar", x, y+320);
		Iterator<Lagrima> it = lagrimas.iterator();
		while(it.hasNext()) {
			Lagrima l = it.next();
			l.pintar();
			l.mover();
		}
		borrarLagrima();	
	}
	
	//Elimina de la lista las lágrimas que ya no se vean
	public void borrarLagrima() {
		Iterator<Lagrima> it = lagrimas.iterator();
		while(it.hasNext()) {
			Lagrima l = it.next();
			if(l.borrar()) {
				it.remove();
			}
		}
	}
	
	//Interacciones con el mouse
	public void click() {
		if(app.mouseButton == app.LEFT) {
			lagrimas.add(new Lagrima(app, x-175, y-248));
			lagrimas.add(new Lagrima(app, x+175, y-170));
			StringBuffer temp = new StringBuffer(palabras[5]);
			temp.append(' ');
			palabras[5] = temp.toString();
		}
	}
	
	//Pinta la cara
	public void pintarCara() {
		app.fill(160);
		app.noStroke();
		app.quad(x, y+160, x+200, y+195, x, y+180, x-200, y+195);
		app.triangle(x+50, y+65, x, y-120, x, y+40);
		app.fill(135);
		app.quad(x, y+40, x+50, y+65, x, y+80, x-50, y+65);
		app.fill(240);
		app.quad(x+70, y-205, x+180, y-260, x+280, y-195, x+180, y-140);
		app.quad(x-70, y-205, x-180, y-260, x-280, y-195, x-180, y-140);
		app.fill(0);
		app.quad(x-175, y-210, x-185, y-200, x-175, y-190, x-165, y-200);
		app.quad(x+175, y-210, x+185, y-200, x+175, y-190, x+165, y-200);
	}
}
