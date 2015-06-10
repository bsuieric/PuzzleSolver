package server;
import java.rmi.*;
import java.rmi.server.*;
import shared.Puzzle;
import shared.SolverAlgorithm;

public class PuzzleToSolve extends UnicastRemoteObject implements SolverAlgorithm {
	
	public PuzzleToSolve()throws RemoteException{}
	
	public class RemainingPuzzle extends Thread{
		int count;
		Puzzle puzzle=new Puzzle();
		public RemainingPuzzle(int n, Puzzle p){
			count=n;
			puzzle=p;
		}
		public void run(){
			for(int j=1; j<puzzle.getCols(); ++j){
				boolean present=false;
				for(int z=0; z<puzzle.getCopiedPuzzle().size() && !present; ++z){
					if(puzzle.getCopiedPuzzle().get(z).get_id_ovest().equals(puzzle.getTile(count, j-1).get_id_pezzo())){
						puzzle.setTile(count, j, puzzle.getCopiedPuzzle().get(z));
						present=true;
					}
				}
			}
			
		}
	}
	
	public Puzzle solve(Puzzle puzzle){
		solveFirstCol(puzzle);
		for(int i=0;i<puzzle.getRows();++i){
			this.new RemainingPuzzle(i, puzzle).start();
		}
		return puzzle;
	}
	
	private void solveFirstCol(Puzzle puzzle){
		String aux="VUOTO";
		for(int i=0; i<puzzle.getRows();++i){
			boolean ok=true;
			for(int z=0; z< puzzle.getCopiedPuzzle().size() && ok ; ++z){
				if(puzzle.getCopiedPuzzle().get(z).get_id_nord().equals(aux) && puzzle.getCopiedPuzzle().get(z).get_id_ovest().equals("VUOTO")){
						puzzle.setTile(i, 0, puzzle.getCopiedPuzzle().get(z));
						aux=puzzle.getCopiedPuzzle().get(z).get_id_pezzo();
						ok= false;
				}
			}
		}
	}
	
}
