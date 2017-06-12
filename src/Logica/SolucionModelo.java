package Logica;

import java.util.Arrays;

import LectorTexto.LectorArchivos;
import lpsolve.LpSolve;
import lpsolve.LpSolveException;

public class SolucionModelo {

	public void solucionar(LectorArchivos archivo) {
		// TODO Auto-generated method stub
		for (int j = 0; j < archivo.getCiudades().size(); j++) {
            String[] ciudad = archivo.getCiudades().get(j);
            for(int i=0; i< ciudad.length; i++){
            	String val = ciudad[i].toString();
            	System.out.println("Element: " + val);
            }
            System.out.println("Element: " + Arrays.toString(ciudad));
        }
		int numeroVariables = (archivo.getNumeroCiudades() * 4)+2;
		System.out.println("Numero: " + numeroVariables);
		try {
			//creamos el problema con n*4+2 variables donde n= numero de ciudades
			LpSolve solver = LpSolve.makeLp(0, numeroVariables);
			//añadimos las restricciones (4 por ciudad)
			for(int i=0; i<archivo.getCiudades().size();i++){
				String ciudad[] = archivo.getCiudades().get(i);
					//se deden de crear reetricciones así por cada ciudad
				// basicamente por cada ciudad toca crear esas cuatro restricciones, teniendo en cuenta el numero de ciudades (abajo es de 3 por eso son 14 variables)
					solver.strAddConstraint("1 -1 0 0 0 0 0 0 0 0 0 0 1 0", LpSolve.GE, Integer.parseInt(ciudad[1].toString()));
					solver.strAddConstraint("1 -1 0 0 0 0 0 0 0 0 0 0 -1 0", LpSolve.GE, (Integer.parseInt(ciudad[1].toString())*-1));
					solver.strAddConstraint("0 0 1 -1 0 0 0 0 0 0 0 0 0 1", LpSolve.GE, Integer.parseInt(ciudad[2].toString()));
					solver.strAddConstraint("0 0 1 -1 0 0 0 0 0 0 0 0 0 -1", LpSolve.GE, (Integer.parseInt(ciudad[2].toString())*-1));
			}
			
		} catch (LpSolveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
