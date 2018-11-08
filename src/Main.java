import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {
	private static Scanner sc;
	private static String userReply="";
	private static Navigateur nav1,nav2,nav3,nav4;
	
	private static String[] navName = new String[]{"joyeux","Atchoum","Simplet","Grincheux"}; 
	private static double[][] positions = new double[][]{{1.2,4.2,0,12.3,42,55},		//x = 1.2	; y = 4.2
														{4,120,1.5,8.5,45,55},
														{8,10,48,57,78,55},
														{41,85,58,75,357,55}};

											
	public static void main(String[] args) {
		
		nav1 = new Navigateur(navName[0]);
		nav2 = new Navigateur(navName[1]);
		nav3 = new Navigateur(navName[2]);
		nav4 = new Navigateur(navName[3]);

		
		for (int i = 0, j = 1; i < (positions.length+2) && j < (positions.length+2); i=i+2, j=j+2) {
			nav1.addPosition(new Position(positions[0][i],positions[0][j]));
		}
		
		for (int i = 0, j = 1; i < (positions.length+2) && j < (positions.length+2); i=i+2, j=j+2) {
			nav2.addPosition(new Position(positions[1][i],positions[1][j]));
		}
		
		for (int i = 0, j = 1; i < (positions.length+2) && j < (positions.length+2); i=i+2, j=j+2) {
			nav3.addPosition(new Position(positions[2][i],positions[2][j]));
		}
		
		for (int i = 0, j = 1; i < (positions.length+2) && j < (positions.length+2); i=i+2, j=j+2) {
			nav4.addPosition(new Position(positions[3][i],positions[3][j]));
		}
		
		writeToCSV();
		userNavInput();
		
		String[] navList = {nav1.getNavName(), nav2.getNavName(), nav3.getNavName(), nav4.getNavName()};
		List<String> listNav = Arrays.asList(navList);
		
		Collections.sort(listNav, String.CASE_INSENSITIVE_ORDER);
		 //affichage de la liste triée.
		 for(int i=0 ; i < listNav.size();i++) {
		 System.out.println(listNav.get(i).toString());
		 }

	}
	
	private static void writeToCSV() {
		try {
			PrintWriter pw = new PrintWriter(new File("test1.csv"));
			
			pw.println(nav1.getNavName()+","+nav1.getNavAt(0)+","+nav1.getNavAt(1)+","+nav1.getNavAt(2));
			pw.println(nav2.getNavName()+","+nav2.getNavAt(0)+","+nav2.getNavAt(1)+","+nav2.getNavAt(2));
			pw.println(nav3.getNavName()+","+nav3.getNavAt(0)+","+nav3.getNavAt(1)+","+nav3.getNavAt(2));
			pw.println(nav4.getNavName()+","+nav4.getNavAt(0)+","+nav4.getNavAt(1)+","+nav4.getNavAt(2));
			pw.flush();
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void userNavInput() {
		//Tant que l’utilisateur le désire  
		
		System.out.println("Voulez-vous afficher les positions d'un navigateur y|n ?");
		sc = new Scanner(System.in);
		userReply = sc.nextLine();
		
		//demande à l’utilisateur de saisir le nom du navigateur. 
		if(userReply.trim().equals("y")) {
			String navname;
			System.out.print("Entrer le nom du navigateur: ");
			sc = new Scanner(System.in);
			navname = sc.nextLine();

			for(int i=0; i < navName.length; i++) {
				if(navname.trim().equals(navName[i])) {
					//recherche et extrait dans le fichier la ligne correspondant.
					String navList;
					switch(navname) {
						case "joyeux": navList = nav1.getAllNavList().toString(); break;
						case "Atchoum": navList = nav2.getAllNavList().toString(); break;
						case "Simplet": navList = nav3.getAllNavList().toString(); break;
						case "Grincheux": navList = nav4.getAllNavList().toString(); break;
						default: navList = "nothing";
						
					}
					//affiche les données
					System.out.println("\nNom Navigateur: "+navname+"\n"+"Navigateur position: "+navList); break;
					
				}else {
					System.out.println("Le nom du navigateur n'existe pas"); break;
				}
			}
		}
	}
}
