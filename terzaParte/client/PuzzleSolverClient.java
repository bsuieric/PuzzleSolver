package client;
import java.rmi.*;
import shared.Puzzle;
import shared.SolverAlgorithm;

public class PuzzleSolverClient {
	private static final String HOST = "localhost";	
	public static void main(String[] args)throws Exception{

	    String inputPath = null;
		String outputPath = null;
		String name = null;
		try{
			inputPath = args[0];
			outputPath = args[1];
			name = args[2];
		}catch(ArrayIndexOutOfBoundsException excep){
			System.err.println("Give input file, output file and server name");
			System.exit(1);
		}

		Puzzle puzzle=new Puzzle();
		Puzzle p=new Puzzle();
	    IOReader reader=new IOReader();
	    reader.readContent(inputPath, puzzle);
	    try{
	    	SolverAlgorithm ref=(SolverAlgorithm) Naming.lookup("rmi://"+HOST+"/"+ name);
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
