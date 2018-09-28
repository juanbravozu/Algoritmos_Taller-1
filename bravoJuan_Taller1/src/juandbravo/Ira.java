package juandbravo;

import processing.core.PApplet;

public class Ira extends Etapa {

	private int clic;
	private int fill;
	private String[] palabras;
	
	public Ira(PApplet app, String texto) {
		super(app);
		fill = 0;
		palabras = app.splitTokens(texto);
	}
	
	public void pintar() {
		clic = 0;
		boolean a = false, e = false, i = false, o = false, u = false;
		for (int ind = 0; ind < palabras.length; ind++) {
			for (int j = 0; j < palabras[ind].length(); j++) {
				if(palabras[ind].charAt(j) == 'A' && !a) {
					clic++;
					a = true;
				} 
				
				if(palabras[ind].charAt(j) == 'E' && !e) {
					clic++;
					e = true;
				} 
				
				if(palabras[ind].charAt(j) == 'I' && !i) {
					clic++;
					i = true;
				} 
				
				if(palabras[ind].charAt(j) == 'O' && !o) {
					clic++;
					o = true;
				}
				
				if(palabras[ind].charAt(j) == 'U' && !u) {
					clic++;
					u = true;
				} 
			}
		}
		app.background(fill);
		romperPantalla();
		if(clic == 5 && fill <= 45) {
			fill++;
			texto = app.join(palabras, ' ');
		}
	}
	
	public void click() {
		switch(clic) {
		case 0:
			for (int i = 0; i < palabras.length; i++) {
				for (int j = 0; j < palabras[i].length(); j++) {
					if(palabras[i].charAt(j) == 'a') {
						palabras[i] = palabras[i].replace('a', 'A');
					}
				}
			}
			break;
			
		case 1:
			for (int i = 0; i < palabras.length; i++) {
				for (int j = 0; j < palabras[i].length(); j++) {
					if(palabras[i].charAt(j) == 'e') {
						palabras[i] = palabras[i].replace('e', 'E');
					}
				}
			}
			break;
			
		case 2:
			for (int i = 0; i < palabras.length; i++) {
				for (int j = 0; j < palabras[i].length(); j++) {
					if(palabras[i].charAt(j) == 'i') {
						palabras[i] = palabras[i].replace('i', 'I');
					}
				}
			}
			break;
			
		case 3:
			for (int i = 0; i < palabras.length; i++) {
				for (int j = 0; j < palabras[i].length(); j++) {
					if(palabras[i].charAt(j) == 'o') {
						palabras[i] = palabras[i].replace('o', 'O');
					}
				}
			}
			break;
			
		case 4:
			for (int i = 0; i < palabras.length; i++) {
				for (int j = 0; j < palabras[i].length(); j++) {
					if(palabras[i].charAt(j) == 'u') {
						palabras[i] = palabras[i].replace('u', 'U');
					}
				}
			}
			break;
		}
		
	}
	
	public void romperPantalla() {
		 switch(clic) {
		 case 5:
			 
		 case 4:
			 app.triangle(x-149, y+92, x-109, y+22, x-111, y+22);
			 app.triangle(x+8, y-1, x+4, y+2, x+117, y+207);
			 app.triangle(x+5, y-36, x-11, y-29, x-126, y-332);
			 app.triangle(x-17, y-21, x-20, y-17, x-298, y-102);
			 app.quad(x-64, y+2, x-66, y+3, x-70, y-32, x-67, y-32);
			 app.quad(x-69, y-36, x-67, y-36, x-51, y-53, x-53, y-55);
		 case 3:
			 app.triangle(x+6, y-36, x+11, y-35, x+111, y-294);
			 app.quad(x+18, y-53, x+17, y-51, x+44, y-22, x+47, y-23);
			 app.triangle(x-11, y-4, x-14, y-5, x-72, y+64);
			 app.quad(x+10, y-3, x+18, y-8, x+136, y+58, x+131, y+64);
			 app.triangle(x+136, y+58, x+131, y+64, x+290, y+101);
			 app.triangle(x-25, y-11, x-18, y-8, x-268, y+73);
		 case 2:
			 app.quad(x+2, y+3, x-5, y, x-5, y+68, x+2, y+70);
			 app.triangle(x-5, y+68, x+2, y+70, x-44, y+102);
			 app.triangle(x+24, y-13, x+21, y-17, x+202, y-57);
			 app.triangle(x-12, y-29, x-17, y-22, x-209, y-200);
			 
		 case 1:
			 app.fill(45);
			 app.stroke(45);
			 app.quad(x+24, y-13, x-22, y-29, x-25, y-11, x+2, y+3);
			 app.triangle(x+10, y-38, x+24, y-13, x-22, y-29);
		 }
	}
	
	public int getFill() {
		return fill;
	}
}
