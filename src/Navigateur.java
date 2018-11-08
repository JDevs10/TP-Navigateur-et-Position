import java.util.ArrayList;

public class Navigateur implements Comparable<Navigateur> {
	private String nomDuNavigateur;
	private String nom = "";
	private ArrayList<Position> listPos;
	
	public Navigateur(String nomNavigateur) {
		nomDuNavigateur = nomNavigateur;
		listPos = new ArrayList<Position>();
	}
	
	@Override
	public int compareTo(Navigateur n) {
		//codage de l’algorithme de tri de 2 objets Profile.
		// 1 : sur le nom sans tenir compte des majuscules et minuscules
		int r = nom.compareTo(n.nom);
		// 2
		//int r = nom.toUpperCase().compareTo(n.nom.toUpperCase());
		//3
		// int r = (age > n.age) ? 1 : -1;
		//System.out.println("texte:" + nom + " n.texte:" + n.nom);
		return r;
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
