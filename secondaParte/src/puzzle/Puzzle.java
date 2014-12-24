package puzzle;
import java.util.ArrayList;
import puzzle.Tile;
import puzzle.IOReader;

public class Puzzle{
	private int rows;
	private int cols;
	private IOReader pf = new IOReader();
	private String inputPath;
	
	private ArrayList<Tile> puzzleTile=new ArrayList<Tile>();
	
	public Puzzle(String path){
		inputPath = path;
		pf.readContent(inputPath, this );
	}
	
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
	
	public Tile getTile(int i, int j)
	{
		return puzzleTile.get(i*cols+j);
	}
	
	public void setTile(int i, int j, Tile value){
		puzzleTile.set(i*cols+j, value);
	}
	
	public ArrayList<Tile> getTileList(){
		return puzzleTile;
	}
	
}
 