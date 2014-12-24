package puzzle;

import puzzle.Puzzle;
import puzzle.PuzzleToSolve;
import puzzle.IOWriter;

public class PuzzleSolver {
	public static void main(String[] args) {
			String inputPath = args[0];
		    String outputPath = args[1];
			Puzzle puzzle=new Puzzle(inputPath);
			PuzzleToSolve unsolved=new PuzzleToSolve(puzzle);
			unsolved.solve(puzzle);
			IOWriter writer=new IOWriter();
			writer.print(unsolved, puzzle, outputPath);
	}
}
