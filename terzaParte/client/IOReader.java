package client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import shared.Puzzle;
import shared.Tile;

public class IOReader {
	public void readContent(String inputPath,Puzzle p){
		int i=0,j=0;
		BufferedReader br= null;
		try{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath), "UTF-8"));
			String line = null;
			while((line=br.readLine()) != null){
				String[] tokens=line.split("\\	");
				Tile tile=new Tile(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
				if(tile.get_id_nord().equals("VUOTO"))
					j++;
				if(tile.get_id_ovest().equals("VUOTO"))
					i++;
				p.addTile(tile);
				p.addToCopiedPuzzle(tile);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(br != null)
					br.close();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		p.setRows(i);
		p.setCols(j);
	}
}
