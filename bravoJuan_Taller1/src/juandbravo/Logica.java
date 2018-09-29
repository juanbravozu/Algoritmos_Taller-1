package juandbravo;

import processing.core.PApplet;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Logica {
	
	private PApplet app;
	private int etapa;//Indica en cuál etapa se encuentra
	private Etapa[] etapas;//Arreglo con las 6 etapas
	private String[] texto;//Arreglo con el texto separado en 6 líneas
	
	//Inicializa cada variable y arreglo
	public Logica(PApplet app) {
		this.app = app;
		etapa = 0;
		texto = app.loadStrings("texto.txt");
		etapas = new Etapa[6];
		
		etapas[0] = new Duelo(app, texto[0]);
		etapas[1] = new Negacion(app, texto[1]);		
		etapas[2] = new Ira(app, texto[2]);
		etapas[3] = new Negociacion(app, texto[3]);
		etapas[4] = new Depresion(app, texto[4]);
		etapas[5] = new Aceptacion(app, texto[5]);
	}
	
	//Pinta cada etapa
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
			break;
			
		case 3:
			etapas[3].pintar();
			break;
			
		case 4:
			etapas[4].pintar();
			break;
			
		case 5:
			etapas[5].pintar();
		}
		
	}

	//Ejecuta todas las acciones del mouse
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
				texto[2] = etapas[2].devolverTexto();
				actualizarTxt(etapa);
				etapa++;
			}
			break;
			
		case 4:
			((Depresion)etapas[4]).click();
			break;
			
		case 5:
			((Aceptacion)etapas[5]).click();
		}
	}
	
	//Ejecuta todas las interacciones del teclado
	public void tecla() {
		switch(etapa) {
		case 1:
			((Negacion)etapas[1]).tecla();
			texto[1] = etapas[1].devolverTexto();
			if(((Negacion)etapas[1]).getOpacidad() <= 0) {
				actualizarTxt(etapa);
				etapa++;
			}
			break;
			
		case 3:
			((Negociacion)etapas[3]).tecla();
			if(app.key == ' ') {
				texto[3] = etapas[3].devolverTexto();
				actualizarTxt(etapa);
				etapa++;
			}
			break;
			
		case 4:
			if(app.key == ' ') {
				texto[4] = etapas[4].devolverTexto();
				actualizarTxt(etapa);
				etapa++;
			}
			break;
			
		case 5:
			if(app.key == ' ' && ((Aceptacion)etapas[5]).getOpacidad() >= 255) {
				texto[5] = etapas[5].devolverTexto();
				actualizarTxt(etapa);
				app.exit();
			}
		}
	}
	
	//Crea un nuevo archivo .txt y guarda en él la primera linea de texto
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
	
	//Guarda en el archivo .txt ya creado nueva información
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
