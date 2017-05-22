import lpsolve.*;
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Minimizar
			//z = 2x1 + 3x2 – 2x3 + 3x4
			//Restricciones
			//3x1 + 2x2 + 2x3 + 1x4 ≤ 4
			//4x2 + 3x3 + 1x4 ≥ 3
			 // Create a problem with 4 variables and 0 constraints
			LpSolve solver = LpSolve.makeLp(0, 4);
			 // add constraints
			solver.strAddConstraint("3 2 2 1", LpSolve.LE, 4);
			solver.strAddConstraint("0 4 3 1", LpSolve.GE, 3);
			 // set objective function
			 solver.strSetObjFn("2 3 -2 3");
			 // solve the problem
			solver.solve();
			 // print solution
			System.out.println("Value of objective function: " +
			solver.getObjective());
			double[] var = solver.getPtrVariables();
			 for (int i = 0; i < var.length; i++) {
			System.out.println("Value of var[" + i + "] = " + var[i]);
			}
			 // delete the problem and free memory
			solver.deleteLp();
			}
			catch (LpSolveException e) {
			e.printStackTrace(); 
			 }
		}
	}

