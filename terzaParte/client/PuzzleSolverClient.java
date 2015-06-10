package client;
import java.rmi.*;
import shared.Puzzle;
import shared.SolverAlgorithm;

public class PuzzleSolverClient {
	
		public static void main(String[] args)throws Exception{

			String inputPath = args[0];
			String outputPath = args[1];
			String host = args[2];
			Puzzle puzzle=new Puzzle();
			Puzzle p=new Puzzle();
		    IOReader reader=new IOReader();
		    reader.readContent(inputPath, puzzle);
		    try{
		    	SolverAlgorithm ref=(SolverAlgorithm) Naming.lookup("rmi://"+host+"/Hello");
		    	p=ref.solve(puzzle);
		    }
		    catch(ConnectException e){
		    	System.out.println("problemi di connessionie a server!");
		    }
		    catch(Exception exc){
		    	exc.printStackTrace();
		    }
			IOWriter writer=new IOWriter();
			writer.print(p, outputPath);
	}
}
