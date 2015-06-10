package puzzle;

import java.util.ArrayList;

public class PuzzleToSolve implements SolverAlgorithm {
	private ArrayList<Tile> copiedPuzzle=new ArrayList<Tile>();
	
	public PuzzleToSolve(Puzzle p){
		copyArrayList(p);
	}
	
	public void solve(Puzzle p){
		solveFirstCol(copiedPuzzle, p);
		solveRemainingTile(copiedPuzzle, p);
	}
	
	private void copyArrayList(Puzzle p){
		for(int i=0;i<p.getTileList().size();++i){
			copiedPuzzle.add(p.getTileList().get(i));
		}
	}
	
	private void solveFirstCol(ArrayList<Tile> a, Puzzle p){
		String aux="VUOTO";
		for(int i=0; i<p.getRows();++i){
			boolean ok=true;
			for(int z=0; z< a.size() && ok ; ++z){
				if(a.get(z).get_id_nord().equals(aux) && a.get(z).get_id_ovest().equals("VUOTO")){
						p.setTile(i, 0, a.get(z));
						aux=a.get(z).get_id_pezzo();
						ok= false;
				}
			}
		}
	}
	
	private void solveRemainingTile(ArrayList<Tile> a, Puzzle p){
		for(int i=0;i<p.getRows(); ++i){
			for(int j=1; j<p.getCols(); ++j){
				boolean present=false;
				for(int z=0; z<a.size() && !present; ++z){
					if(a.get(z).get_id_ovest().equals(p.getTile(i, j-1).get_id_pezzo())){
						p.setTile(i, j, a.get(z));
						present=true;
					}
				}
			}
		}
	}
	
	public ArrayList<Tile> getTileCopiedList(){
		return copiedPuzzle;
	}
}
