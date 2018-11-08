
public class Position {
	private double coordonneeX = 0;
	private double coordonneeY = 0;

	public Position(double longitude , double latitude) {
		coordonneeX = longitude;
		coordonneeY = latitude;
	}
	
	//accesseurs
	public double getCoordonneeY() {
		return coordonneeY;
	}
	
	public double getCoordonneeX() {
		return coordonneeX;
	}
	
	//Surchage de String
	@Override
	public String toString() {
		return getCoordonneeX()+" ; "+getCoordonneeY();
	}
}
