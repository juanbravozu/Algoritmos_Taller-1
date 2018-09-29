package juandbravo;

import processing.core.PApplet;
import processing.core.PVector;

public class Rama {

	private PApplet app;
	private PVector inicio;
	private PVector fin;
	private float newx, newy;
	private float hojay;
	private float difx, dify;
	private boolean finali;
	private boolean complet;
	
	public Rama(PApplet app, PVector inicio, PVector fin){
	  this.app = app;
	  this.inicio = inicio;
      this.fin = fin;
      finali = false;
      newx = inicio.x;
      newy = inicio.y;
      difx = (fin.x - inicio.x)/60;
      dify = (fin.y - inicio.y)/60;
	}
		  
	//Pinta las ramas
	public void pintar(){
		app.stroke(255);
		app.strokeWeight(2);
	    app.line(inicio.x, inicio.y, newx, newy);
	    if(app.dist(inicio.x, inicio.y, newx, newy) < app.dist(inicio.x, inicio.y, fin.x, fin.y)) {
	        newx += difx;
	        newy += dify;
	     } else {
	       if(!complet) {
	         hojay = newy;
	       }
	       complet = true;	       
	     }
	}
		  
	//Crea una nueva rama hacia la derecha desde el final de la rama anterior
	public Rama ramaA(){
		PVector dir = PVector.sub(fin, inicio);
		dir.rotate(app.PI / 6);
		dir.mult((float) 0.67);
		PVector newEnd = PVector.add(fin, dir);
	    Rama b = new Rama(app, fin, newEnd);
	    return b;
	}
		  
	//Crea una nueva rama hacia la izquierda desde el final de la rama anterior
	public Rama ramaB(){
	    PVector dir = PVector.sub(fin, inicio);
	    dir.rotate(- app.PI / 4);
	    dir.mult((float) 0.67);
	    PVector newEnd = PVector.add(fin, dir);
	    Rama b = new Rama(app, fin, newEnd);
	    return b;
	}
	
	//Hace caer las hojas
	public void caer(float vel) {
		boolean caer = false;
	    if(complet) {
	      caer = true;
	    }

	    if(caer) {
	      hojay += vel;
	    }	
	}
	
	public float getNewx() {
		return newx;
	}
	
	public float getNewy() {
		return newy;
	}
	public float getHojay() {
		return hojay;
	}
	
	public PVector getInicio() {
		return inicio;
	}
	
	public PVector getFin() {
		return fin;
	}
	
	public boolean getFinali() {
		return finali;
	}
	
	public boolean getComplet() {
		return complet;
	}
	
	public void setFinali(boolean f) {
		finali = f;
	}
}
