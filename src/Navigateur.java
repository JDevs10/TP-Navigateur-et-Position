import java.util.ArrayList;

public class Navigateur {
	private String nomDuNavigateur;
	private ArrayList<Position> listPos;
	
	public Navigateur(String nomNavigateur) {
		nomDuNavigateur = nomNavigateur;
		listPos = new ArrayList<Position>();
	}
	
	public Navigateur() {
		this.nomDuNavigateur = "";
	}
	
	public void addPosition(Position positions2) {
		listPos.add(positions2);
	}
	
	//position dans la liste
	public Position extractListPosition(int position) {
		return listPos.get(position);
	}
	
	public String getNavAt(int position) {
		return listPos.get(position).toString();
	}
	
	public ArrayList<Position> getAllNavList(){
		return listPos;
	}
	
	public String getNavName() {
		return nomDuNavigateur;
	}
	
	//Surchage de String
	@Override
	public String toString() {
		return "Le nom du navigateur: "+nomDuNavigateur;
	}

}
