import java.util.*;

// die main führt das Spielmenü über while-Schleife aus und über for-Schleife wechselt man zum nächsten Spieler
public class Kniffel_Main {
	
		public static void main (String[] args) {

			int max_round = 13;		//Maximale Runden
			
			Scanner sc = new Scanner(System.in);		// Scanner zum Einlesen


			Kniffel spiel = new Kniffel();		// Spiel wird erstellt
			boolean gameMenue = false;
			
			while(gameMenue == false) {
				
				spiel.printMenu();		//SpielMenü erscheint
				int auswahl = sc.nextInt();		
			
				switch(auswahl) {

				case 1:

					Spieler freunde[];
					freunde = spiel.initializePlayer();		//Spiel startet

					for (int round = 0;round < max_round; round++ ) {


						for (int dran = 0; dran < freunde.length ; dran++ ) {	//wechselt zum nächsten Spieler
							System.out.println("\n\nDu bist dran " +freunde[dran].name+ " !\nDein Wurf:");
							freunde[dran].hand = freunde[dran].zug();
							freunde[dran].auswertung(freunde[dran].hand);
						}
						
					}
					
					gameMenue = true;		//Ende while-Schleife

				//case 2:
					
				//case 3:
				
				case 4:
					spiel.kniffelHilfe();	//Spielanleitung
					break;
				case 5: 
					System.out.println("Auf Wiedersehen ;) "
										+"\n Spiel beendet");
					gameMenue = true; // Spiel beenden
					break;
					
				default: 
					System.out.println("Fehlerhafte Eingabe");
					break;
				}
			}
		}

	}
			

