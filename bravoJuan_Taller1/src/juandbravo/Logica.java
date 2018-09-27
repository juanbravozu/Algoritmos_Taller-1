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
		etapa = 2;
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
			break;
			
		case 2:
			etapas[2].pintar();
		}
	}

	public void click() {
		
		switch(etapa) {
		case 0:
			((Duelo) etapas[0]).click();
			texto[0] = etapas[0].devolverTexto();
			if(((Duelo)etapas[0]).getLloviendo()) {
				crearTxt(etapa);
				etapa++;
				String[] temp;
				temp = app.loadStrings("textoActualizado.txt");
				for (int i = 0; i < temp.length; i++) {
					System.out.println(temp[i]);
				}
			}
			break;
			
		case 2:
			((Ira)etapas[2]).click();
			if(((Ira)etapas[2]).getFill() >= 45) {
				etapa++;
			}
			break;
		}
	}
	
	public void clickMan() {
		
	}
	
	public void tecla() {
		switch(etapa) {
		case 1:
			((Negacion)etapas[1]).tecla();
			texto[1] = etapas[1].devolverTexto();
			if(((Negacion)etapas[1]).getOpacidad() <= 0) {
				actualizarTxt(etapa);
				etapa++;
				String[] temp;
				temp = app.loadStrings("textoActualizado.txt");
			}
		}
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
		bw.write(texto[0]);
		for(int i = 1; i <= etapa; i++) {
			bw.newLine();
			bw.write(texto[i]);
		}
		
		bw.flush();
		bw.close();
		} catch(Exception e) {
		}
	}
}
