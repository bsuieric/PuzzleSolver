package puzzle;
import puzzle.PuzzleToSolve;
import puzzle.IOWriter;

public class PuzzleSolver {
	public static void main(String[] args) {
		String inputPath = args[0];
	    String outputPath = args[1];
		PuzzleToSolve unsolved=new PuzzleToSolve(inputPath);
		unsolved.solve();
		IOWriter writer=new IOWriter();
		writer.print(unsolved, unsolved.getPuzzle() , outputPath);
	}
}
