package server;
import java.rmi.*;
import server.PuzzleToSolve;

public class PuzzleSolverServer {
	
	public static void main(String[] args)throws Exception{
        String host = args[0];
		PuzzleToSolve pts=new PuzzleToSolve();
		String rmiObjName="rmi://"+host+"/Hello";
		Naming.rebind(rmiObjName, pts);
		System.out.println("Server Pronto");
	}
}
