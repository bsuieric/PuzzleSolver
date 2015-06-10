package shared;
import java.io.Serializable;

public class Tile implements Serializable{
	private String id_pezzo;
	private String carattere;
	private String id_nord;
	private String id_est;
	private String id_sud;
	private String id_ovest;
	
	public Tile(String p, String c, String n, String e, String s, String o){
		id_pezzo=p;
		carattere=c;
		id_nord=n;
		id_est=e;
		id_sud=s;
		id_ovest=o;
	}
	
	public String get_id_pezzo(){return id_pezzo;}
	public String get_carattere(){return carattere;}
	public String get_id_nord(){return id_nord;}
	public String get_id_est(){return id_est;}
	public String get_id_sud(){return id_sud;}
	public String get_id_ovest(){return id_ovest;}	
}
