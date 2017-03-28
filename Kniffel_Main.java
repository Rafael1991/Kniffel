import java.util.*;

public class Kniffel_Main {
	
		public static void main (String[] args) {

			int max_round = 13;		//Maximale Runden
			
			Scanner sc = new Scanner(System.in);		// Scanner zum Einlesen


			 
			Kniffel spiel = new Kniffel();		// Spiel wird erstellt
			boolean gameMenue = false;
			
			while(gameMenue == false) {
				
				spiel.printMenu();
				int auswahl = sc.nextInt();
			
				switch(auswahl) {


				case 1:

					Spieler freunde[];
					freunde = spiel.initializePlayer();

					for (int round = 0;round < max_round; round++ ) {


						for (int dran = 0; dran < freunde.length ; dran++ ) {
							System.out.println("\n\nDu bist dran " +freunde[dran].name+ " !\nDein Wurf:");
							freunde[dran].hand = freunde[dran].zug();
							freunde[dran].auswertung(freunde[dran].hand);
						}
						
					}


					gameMenue = true;



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
			

