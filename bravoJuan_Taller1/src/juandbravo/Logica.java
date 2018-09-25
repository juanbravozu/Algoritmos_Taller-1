package juandbravo;

import processing.core.PApplet;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Logica {
	
	private PApplet app;
	private int etapa;
	private Etapa[] etapas;
	private String[] texto;
	
	public Logica(PApplet app) {
		this.app = app;
		etapa = 1;
		texto = app.loadStrings("texto.txt");
		etapas = new Etapa[6];
		
		etapas[0] = new Duelo(app, texto[0]);
		etapas[1] = new Negacion(app, texto[1]);		
		etapas[2] = new Ira(app);
		etapas[3] = new Negociacion(app);
		etapas[4] = new Depresion(app);
		etapas[5] = new Aceptacion(app);
	}
	
	public void dibujar() {
		switch(etapa) {
		case 0:
			etapas[0].pintar();
			break;
			
		case 1: 
			etapas[1].pintar();
		}
	}

	public void click() {
		switch(etapa) {
		case 0:
			((Duelo) etapas[0]).click();
			texto[0] = etapas[0].devolverTexto();
			System.out.println(etapas[0].devolverTexto());
			if(((Duelo)etapas[0]).getLloviendo()) {
				crearTxt(etapa);
				etapa++;
			}
			break;
			
		case 1:
			((Negacion)etapas[1]).click();
		}
	}
	
	public void clickMan() {
		
	}
	
	public void tecla() {
		
	}
	
	public void crearTxt(int etapa) {
		try {
			File archivo = new File("textoActualizado.txt");
			archivo.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
			bw.write(texto[etapa]);
			bw.flush();
			bw.close();
		} catch(Exception e) {			
		}
	}
	
	public void actualizarTxt(int etapa) {
		try {
		BufferedWriter bw = new BufferedWriter(new FileWriter("textoActualizado.txt"));
		bw.newLine();
		bw.write(texto[etapa]);
		bw.flush();
		bw.close();
		} catch(Exception e) {
		}
	}
}
