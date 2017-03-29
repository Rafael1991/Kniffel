import java.util.*;

// Klasse enthält printMenu, die Spielbeschreibung und initializePlayer
public class Kniffel {
	
	private	Scanner scanner = new Scanner(System.in);
	private static Scanner input = new Scanner(System.in);
	private static int runden = 13;

	
	// druckt das Menü
		public void printMenu() {

			System.out.println("\n**********Menue**********");
			System.out.println("1. Kniffel spielen?");
			System.out.println("2. Kniffel_light (ohne Full House, Strassen etc.) spielen?"); 	// funktioniert noch nicht
			System.out.println("3. Kniffel Funktionen testen?");		// funktioniert noch nicht
			System.out.println("4. Hilfe");
			System.out.println("5. Beenden.");
			System.out.println("**************************\n");
			System.out.print("Deine Auswahl:");

		}

		
		//Option 4 Hilfe/Spielbeschreibung
		public void kniffelHilfe() {
			System.out.println("Das Spiel geht 13 Runden lang, jeder Spieler hat 3 Versuche pro Runde"
								+ "\netwas aus der Liste abzuhaken. Andernfalls muss man etwas streichen,"
								+ "\ndies kann man dann nicht mehr wuerfeln."
								+ "\nZiel des Spiels ist es moeglichst alles auf der Liste zu wuerfeln"
								+ "\nund die meisten Punkte zu ergattern. Viel Spass!");
		}
		
		
		//Anzahl und Namen der Spieler bestimmen
		public Spieler[] initializePlayer() {	// gibt ein Array vom Typ Spieler zurück; später zum Durchlaufen der Züge verwendet
			
			int anzahl_Spieler;
			
			while(true) {

				System.out.println("Anzahl der Spieler?");		
				  anzahl_Spieler = input.nextInt();		//Eingabe bestimmt Spieleranzahl
						if(anzahl_Spieler>=1 || anzahl_Spieler<=4) {	//Korrekter Bereich von Spielern

							Spieler myGruppe[] = new Spieler[anzahl_Spieler];	// Array wird erstellt
								for (int j = 0; j< myGruppe.length; j++) {
										myGruppe[j]= new Spieler();		// Array wird mit Spieler-Objekten gefüllt
										System.out.println("Bitte geben Sie Spielernamen "+(j+1)+ " ein.");
			 							myGruppe[j].name = scanner.next();
								}						
								return myGruppe;	//gibt Namen der Spieler wieder
						}
						else {
							System.out.println("nur 2-4 Spieler");	//inkorrekter Fall
						}
			 }

			 
		}
}


