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
	
	public ArrayList<String[]> leerArchivo(){
		String texto;
        int tamañoCuadrado;
        int numeroCiudades;
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
                        
                        for (int j = 0; j < ciudades.size(); j++) {
                            String[] value = ciudades.get(j);
                            System.out.println("Element: " + Arrays.toString(value));
                        }
                        
                fr.close();
                bf.close();
                } catch (IOException e2) {
                        JOptionPane.showMessageDialog(null, "Error Al Cargar Archivo");
                }
        }
       return ciudades;
    }

}
