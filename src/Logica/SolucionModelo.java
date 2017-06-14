package Logica;



import LectorTexto.LectorArchivos;
import lpsolve.LpSolve;
import lpsolve.LpSolveException;

public class SolucionModelo {

	public String solucionar(LectorArchivos archivo) {
		// TODO Auto-generated method stub
		int numeroVariables = (archivo.getNumeroCiudades() * 4)+2;
		String resultado = null;
		try {
			//creamos el problema con n*4+2 variables donde n= numero de ciudades
			LpSolve solver = LpSolve.makeLp(0, numeroVariables);
			//añadimos las restricciones (4 por ciudad)
			String vacia ="";
			for (int i = 0; i < numeroVariables; i++) {
				vacia += "0 ";
			}
			StringBuilder restriccion1,restriccion2,restriccion3,restriccion4;
			String ciudad[];
			for(int i=0; i<archivo.getCiudades().size()*8;i+=8){
				ciudad = archivo.getCiudades().get(i/8);// obtener la ciudad con sus datos 
				
				restriccion1 = new StringBuilder(vacia); // se inicializan las restricciones vacias
				restriccion2 = new StringBuilder(vacia); // se inicializan las restricciones vacias
				restriccion3 = new StringBuilder(vacia); // se inicializan las restricciones vacias
				restriccion4 = new StringBuilder(vacia); // se inicializan las restricciones vacias
				
				// se crea la primer restriccion de la ciudad 
				restriccion1.replace(i, i+1, "1");// colocar positiva la primer variable auxiliar
				restriccion1.replace(i+2, i+3, "-1");// colocar negativa la segunda variable auxiliar
				restriccion1.replace((numeroVariables*2-3), (numeroVariables*2-2), "-1"); // colocar negativa la X, después del despeje
				
				// se crea la segunda restricción de la ciudad
				restriccion2.replace(i, i+1, "1");// colocar positiva la primer variable auxiliar
				restriccion2.replace(i+2, i+3, "-1");// colocar negativa la segunda variable auxiliar
				restriccion2.replace((numeroVariables*2-3), (numeroVariables*2-2), "1"); // colocar positiva la X, después del despeje
				
				// se crea la tercera restricción de la ciudad
				restriccion3.replace(i+4, i+5, "1");// colocar positiva la tercera variable auxiliar
				restriccion3.replace(i+6, i+7, "-1");// colocar negativa la cuarta variable auxiliar
				restriccion3.replace((numeroVariables*2-1), (numeroVariables*2), "-1"); // colocar negativa la Y, después del despeje
				
				// se crea la Cuarta restricción de la ciudad
				restriccion4.replace(i+4, i+5, "1");// colocar positiva la tercera variable auxiliar
				restriccion4.replace(i+6, i+7, "-1");// colocar negativa la cuarta variable auxiliar
				restriccion4.replace((numeroVariables*2-1), (numeroVariables*2), "1"); // colocar positiva la Y, después del despeje
				
					//se deden de crear reetricciones así por cada ciudad
				// basicamente por cada ciudad toca crear esas cuatro restricciones, teniendo en cuenta el numero de ciudades (abajo es de 3 por eso son 14 variables)
					solver.strAddConstraint(restriccion1.toString(), LpSolve.GE, Integer.parseInt(ciudad[1].toString())*-1);
					solver.strAddConstraint(restriccion2.toString(), LpSolve.GE, (Integer.parseInt(ciudad[1].toString())));
					solver.strAddConstraint(restriccion3.toString(), LpSolve.GE, Integer.parseInt(ciudad[2].toString())*-1);
					solver.strAddConstraint(restriccion4.toString(), LpSolve.GE, Integer.parseInt(ciudad[2].toString()));
			}
			// restriccines obvias;
			restriccion1 = new StringBuilder(vacia); // se inicializan la restriccion obvia de X
			restriccion2 = new StringBuilder(vacia); // se inicializan la restriccion obvia de Y
			
			// restricion obvia de X 
			restriccion1.replace((numeroVariables*2-4), (numeroVariables*2-3), "1");
		
			// restricion obvia de Y 
			restriccion2.replace((numeroVariables*2-1), (numeroVariables*2), "1");
			
			// agregando las restricciones 
			solver.strAddConstraint(restriccion1.toString(), LpSolve.GE,0);
			solver.strAddConstraint(restriccion2.toString(), LpSolve.GE,0);
			solver.strAddConstraint(restriccion1.toString(), LpSolve.LE, archivo.getTamanoCuadrado()); //  X menor que N
			solver.strAddConstraint(restriccion2.toString(), LpSolve.LE, archivo.getTamanoCuadrado()); //  Y menor que N
			
			// agregando la función objetivo
			String FuncionObjetivo = "";
			for (int j = 0; j < numeroVariables-2; j+=2) {
				FuncionObjetivo+="1 ";
				FuncionObjetivo+="-1 ";
			}
			FuncionObjetivo+=" 0 0";
			solver.strSetObjFn(FuncionObjetivo.toString()); // agregar funcion objetivo
			solver.printLp();
			
			solver.solve(); // si esto retorna 0 es porque sí encontró la solucion optima
			solver.printObjective();
			solver.printSolution(1);
			solver.printConstraints(1);
			
			double[] var = solver.getPtrVariables();
			System.out.println("Solución Variables");
			System.out.println("X = "+var[var.length-2]);
			System.out.println("Y = "+var[var.length-1]);
			resultado = "Valor de la función objetivo="+solver.getObjective()+"\nX ="+var[var.length-2]+"\nY ="+var[var.length-1];
			solver.deleteLp();
			
		} catch (LpSolveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = "Ha ocurrido un error, por favor revisar los datos de entrada";
		}
		return resultado;		
	}

}
