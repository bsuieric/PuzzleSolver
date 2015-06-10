package puzzle;
import java.util.ArrayList;

public class PuzzleToSolve implements SolverAlgorithm {
	private ArrayList<Tile> copiedPuzzle=new ArrayList<Tile>();
	private Puzzle puzzle;
	
	public PuzzleToSolve(String path){
		puzzle=new Puzzle(path);
		copyArrayList();
	}
	
	public class RemainingPuzzle extends Thread{
		int count;
		public RemainingPuzzle(int n){
			count=n;
		}
		public void run(){
			for(int j=1; j<puzzle.getCols(); ++j){
				boolean present=false;
				for(int z=0; z<copiedPuzzle.size() && !present; ++z){
					if(copiedPuzzle.get(z).get_id_ovest().equals(puzzle.getTile(count, j-1).get_id_pezzo())){
						puzzle.setTile(count, j, copiedPuzzle.get(z));
						present=true;
					}
				}
			}
			
		}
	}
	
	public void solve(){
		solveFirstCol();
		for(int i=0;i<this.getPuzzle().getRows();++i){
			this.new RemainingPuzzle(i).start();
		}
	}
	
	private void copyArrayList(){
		for(int i=0;i<puzzle.getTileList().size();++i){
			copiedPuzzle.add(puzzle.getTileList().get(i));
		}
	}
	
	private void solveFirstCol(){
		String aux="VUOTO";
		for(int i=0; i<puzzle.getRows();++i){
			boolean ok=true;
			for(int z=0; z< copiedPuzzle.size() && ok ; ++z){
				if(copiedPuzzle.get(z).get_id_nord().equals(aux) && copiedPuzzle.get(z).get_id_ovest().equals("VUOTO")){
						puzzle.setTile(i, 0, copiedPuzzle.get(z));
						aux=copiedPuzzle.get(z).get_id_pezzo();
						ok= false;
				}
			}
		}
	}
	
	public ArrayList<Tile> getTileCopiedList(){
		return copiedPuzzle;
	}
	
	public Puzzle getPuzzle(){
		return puzzle;
	}
}
