package server;
import java.rmi.*;
import server.PuzzleToSolve;
import java.net.MalformedURLException;

public class PuzzleSolverServer {
	private static final String HOST = "localhost";
	public static void main(String[] args)throws Exception{
        String name = null;
        try{
        	name = args[0];
        }catch(ArrayIndexOutOfBoundsException e){
        	System.err.println("Select a server name!");
        	System.exit(1);
        }

		PuzzleToSolve pts=new PuzzleToSolve();
		String rmiObjName="rmi://"+HOST+"/" + name;
		try{
			Naming.rebind(rmiObjName, pts);
		}catch(RemoteException exec){
			System.err.println("Error during the rebind!");
			System.exit(1);
		}catch(MalformedURLException exec){
			System.err.println("Malformed URL!");
			System.exit(1);
		}
		System.out.println("Server Pronto");
	}
}
