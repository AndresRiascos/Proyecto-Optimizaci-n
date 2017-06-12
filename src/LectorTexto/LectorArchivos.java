package LectorTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.print.attribute.standard.NumberOfDocuments;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SingleSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LectorArchivos {
	
	public int tamanoCuadrado;
	public int numeroCiudades;
	public ArrayList<String[]> ciudades;
	
	public LectorArchivos(){
    }
	
	public LectorArchivos(int tC, int nC, ArrayList<String[]> cities){
		tamanoCuadrado = tC;
		numeroCiudades = nC;
		ciudades = cities;
    }
	
	public void setTamanoCuadrado(int n) { 
		this.tamanoCuadrado = n; 
	}
	
	public void setNumeroCiudades(int n){ 
		this.numeroCiudades = n; 
	}
	
	public void setCiudades(ArrayList<String[]> n){ 
		this.ciudades = n; 
	}
	
	public int getTamanoCuadrado() { 
		return tamanoCuadrado; 
	}
	
	public int getNumeroCiudades(){ 
		return numeroCiudades;
	}
	
	public ArrayList<String[]> getCiudades(){ 
		return ciudades;
	}
	
	public void leerArchivo(){
		String texto;
        int tamañoCuadrado = 0;
        int numeroCiudades = 0;
        ArrayList<String[]> ciudades = new ArrayList<String[]>();
        
        String file = "";
        JFileChooser JFC = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto","txt","TXT");
        JFC.setFileFilter(filtro);
        String usuario = System.getProperty("user.name");//Obtenemos nombre de usuario
        JFC.setCurrentDirectory(new File("C:/Users/"+usuario+"/Desktop")); //donde se quiere empezar a buscar el archivo
        int abrir = JFC.showDialog(null, "Abrir"); 
        try {
			file = JFC.getSelectedFile().getName();
		} catch (NullPointerException e) {
			// TODO Bloque catch generado automáticamente
			//error al cancelar
		}

        if(abrir == JFileChooser.APPROVE_OPTION){
                File archivo = JFC.getSelectedFile();
                file = JFC.getSelectedFile().getAbsolutePath();
                try {
                        FileReader fr = new FileReader(archivo);
                        BufferedReader bf = new BufferedReader(fr);
                        String strLinea;
                        int i=0;
                        while ((strLinea = bf.readLine()) != null){
                        	texto = String.valueOf(strLinea);//obtenemos linea por linea
                        	if(i==0){
                        		tamañoCuadrado = Integer.parseInt(texto);
                        	}if(i==1){
                        		numeroCiudades = Integer.parseInt(texto);
                        	}if(i>1){
                        		String []ciudad = texto.split(" ");
                        		ciudades.add(ciudad);                        		                        		
                        	}                                
                            i++;    
                        }                        
                        
                fr.close();
                bf.close();
                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(null, "Error en el formato de archivo de entrada");
                }catch (IOException e2) {
                    JOptionPane.showMessageDialog(null, "Error Al Cargar Archivo");
                }
        }
        setTamanoCuadrado(tamañoCuadrado);
        setNumeroCiudades(numeroCiudades);
        setCiudades(ciudades);
    }

}
