package shared;
import java.util.ArrayList;
import java.io.Serializable;

public class Puzzle implements Serializable{
	private int rows;
	private int cols;
	
	private ArrayList<Tile> puzzleTile=new ArrayList<Tile>();
	private ArrayList<Tile> copiedPuzzle=new ArrayList<Tile>();
	
	public Puzzle(){}
	
	public void setRows(int i){
		rows=i;
	}
	
	public int getRows(){
		return rows;
	}
	
	public void setCols(int j){
		cols=j;
	}
	
	public int getCols(){
		return cols;
	}
	
	public void addTile(Tile p){
		puzzleTile.add(p);
	}
	
	public void addToCopiedPuzzle(Tile p){
		copiedPuzzle.add(p);
	}
	
	public Tile getTile(int i, int j)
	{
		return puzzleTile.get(i*cols+j);
	}
	
	public Tile getTileFromCopiedPuzzle(int i, int j){
		return copiedPuzzle.get(i*cols+j);
	}
	
	public void setTile(int i, int j, Tile value){
		puzzleTile.set(i*cols+j, value);
	}
	
	public ArrayList<Tile> getTileList(){
		return puzzleTile;
	}
	
	public ArrayList<Tile> getCopiedPuzzle(){
		return copiedPuzzle;
	}
	
}
 