package juandbravo;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;

public class Duelo extends Etapa {//Representa el inicio del duelo

	private ArrayList<Rama> arbol;//Lista con las diferentes ramas del árbol
	private int count;//Cuenta la cantidad de clicks que ha dado el usuario
	private float vel;//La velocidad a la que caen las hojas
	private String[] palabras;//Arreglo con la línea de texto correspondiente a esta etapa
	private Gota[] lluvia;//Arreglo de gotas para la lluvia
	private boolean lloviendo;//Dice si está lloviendo o no
	
	//Se inicializa cada variable y arreglo
	public Duelo(PApplet app, String texto) {
		super(app);
		arbol = new ArrayList<Rama>();
		count = 0;
		vel = 1;
		PVector a = new PVector(app.width / 2, app.height);
		PVector b = new PVector(app.width / 2, app.height - (app.height/3));
		Rama raiz = new Rama(app, a, b); 
		arbol.add(raiz);
		this.texto = texto;
		palabras = texto.split(" ");	
		lluvia = new Gota[300];
		lloviendo = false;
		for (int i = 0; i < lluvia.length; i++) {
			lluvia[i] = new Gota(app);
		}
	}

	public void pintar() {
		count = 0;
		texto = app.join(palabras, ' ');					
		for (int i = 0; i < palabras.length; i++) {	//----------------------//Cada que encuentra la palabra DUELO, el contador aumenta, representando que se ha dado click
			if(palabras[i] == "DUELO" && count < 8) {
				count++;
			}
		}
		app.background(20);
		for(int i = 0; i < arbol.size(); i++){
		    arbol.get(i).pintar();
		  }
		
		
		for(int i = 0; i < arbol.size(); i++){
			Rama r = arbol.get(i);
			app.fill(66, 183, 224, 100);
		    app.noStroke();
		    if(count < 8 && !r.getFinali()) {
		    	app.ellipse(r.getNewx(), r.getNewy(), 30, 30);
		    } else if(!r.getFinali() && count == 8) {
		    	if(r.getComplet()) {
		        	vel = app.random(1, 3);
		        	r.caer(vel);
		        	app.ellipse(r.getNewx(), r.getHojay(), 30, 30);
		    	} else {
		    		app.ellipse(r.getNewx(), r.getNewy(), 30, 30);
		    	}
		    }
		}
		
		boolean perdida = false;
		for (int i = 0; !perdida && i < palabras.length; i++) {
			if(palabras[i] == "PERDIDA") {
				for (int j = 0; j < lluvia.length; j++) {
					lluvia[j].caer();
					lluvia[j].pintar();
				}
				lloviendo = true;
				perdida = true;
			}
		}
	}
	
	//Interaccion al hacer click
	public void click() {
		System.out.println(count);
		if(count < 8) {
			for(int i = arbol.size() -1; i >= 0; i--){				
			    Rama r = arbol.get(i);
			    if(!r.getFinali() && r.getComplet()){
			    	arbol.add(r.ramaA());
			    	arbol.add(r.ramaB());
				    r.setFinali(true);
				    palabras[count] = "DUELO";						//Reemplaza las primeras palabras cada que se hace click
			    }		    
			}		
		} else {
			for(int i = count; i < palabras.length; i++) {    		//Reemplaza el resto de palabras
				palabras[i] = "PERDIDA";
			}					
		} 
	}
	
	public boolean getLloviendo() {	
		return lloviendo;
	}
}
