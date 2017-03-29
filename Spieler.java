import java.util.*;

// Klasse enthält die Methoden wuerfeln, print_Array, auswertung und zug

public class Spieler {
		
		protected int punkte = 0;
		protected String name = null;	// null meint die String variable zeigt auf nichts
		protected int[] hand = new int[5];	// mit Hand sollen die Würfel gespeichert und "ausgewertet werden
		protected Scanner scanner = new Scanner(System.in);
		
	
	public void print_Array(int[] array) {		// druckt das gewuerfelte Ergebnis
		
		for(int i=0; i<array.length; i++ ) {
			System.out.print(array[i]);
		}
		System.out.print("\n");
	}
	
	public static int wuerfeln() {		// gibt Zahlen zwischen 1-6 zurueck
		Random chaos = new Random();
		return chaos.nextInt(7-1)+1;	//(7-1)+1 weil man eine Zahl von 1 bis 6 würfeln will, ohne +1 wäre es von 0 bis 6
	}	
	
	public void auswertung(int[] myArray) {		// myArray ist die Bezeichnung fuer das wahre Argument
		
		/*			
		
		int 1_Paar;
		int 2_Paar;
		int 3_Paar;	
		int 4_Paar;
		int 5_Paar;
		int 6_Paar;
		
		int drei_Pasch;
		int vier_Pasch;
		int full_House;
		int kl_Strasse;
		int gr_Stasse;
		int kniffel;
		int Chance;
		*/
			//Zum erkennen von Paaren
			for(int i =0; i<myArray.length; i++) {		// hält Elemente im Array fest, falls myArray an Stelle i=j dann ++, sonst nicht
					
				for(int j=0; j<myArray.length; j++) {		
						
					if(myArray[i] == myArray[j] && i!=j) {		/* myArray[i] muss gleich myArray[j] 
																sein aber die Zahlen an der selben 
																Position duerfen sich nicht gleichen*/
					//System.out.println("Du hast doppelt "+myArray[i]+" gewuerfelt.");
					}
					
				}
				
			}

			
			// zum erkennen der grossen Strasse
			if((myArray[0] < myArray[1]) && (myArray[1] < myArray[2]) && (myArray[2] < myArray[3]) && (myArray[3] < myArray[4]) && (myArray[4] < myArray[5]))  
				/*(myArray[0] == 1 && myArray[1] == 2 && myArray[2] == 3 && myArray[3] == 4 && myArray[4] == 5 ||
				   myArray[1] == 2 && myArray[2] == 3 && myArray[3] == 4 && myArray[4] == 5 && myArray[5] == 6)*/
			{
					System.out.println("Du hast eine grosse Strasse gewuerfelt und erhaelst 40 Punkte.");
					punkte+=40;
				}
			//zum erkennen der kleinen Strasse		
			 if(myArray[0] == 1 && myArray[1] == 2 && myArray[2] == 3 && myArray[3] == 4 ||
			   myArray[1] == 2 && myArray[2] == 3 && myArray[3] == 4 && myArray[4] == 5 ||
			   myArray[2] == 3 && myArray[3] == 4 && myArray[4] == 5 && myArray[5] == 6)
			
			/*(myArray[0] < myArray[1] && myArray[1] < myArray[2] && myArray[2] < myArray[3] || 
			   myArray[1] < myArray[2] && myArray[2] < myArray[3] && myArray[3] < myArray[4] ||
			   myArray[0] < myArray[1] && myArray[1] < myArray[2] && myArray[2] < myArray[3] && myArray[3] == myArray[4] || 
			   myArray[0] == myArray[1] &&  myArray[1] < myArray[2] && myArray[2] < myArray[3] && myArray[3] < myArray[4]) */
				{
				   System.out.println("Du hast eine kleine Strasse gewuerfelt und erhaelst 30 Punkte.");
				   punkte+=30;
				}
			System.out.println("Punkte: "+punkte);
		}
		
		/*public Spieler[] getGruppe() {
		return Kniffel.Gruppe;
		}*/
	
public int[] zug() {
			
			 int wuerfel = 5;	// alle 5 wuerfel werden gewuerfelt
			 int[] wurf = new int[5];	//Speicherstellen fuer die Werte der Wuerfel innerhalb dieser Methode
			 int anzahl_Wuerfe = 3;
			 int zweiter_Wurf;
			 int temp=0;
					
					for (int l = 0; l<wuerfel; l++) {		// l wird hochgezaehlt bis wuerfel damit er alle 5 Wuerfel gleichzeitig wuerfelt
						wurf[l] = wuerfeln();	
					}	
						for(int k=0; k<anzahl_Wuerfe; k++) {		// Bis zu 3x wuerfeln
												
								Arrays.sort(wurf);
								print_Array(wurf);
								auswertung(wurf);
								System.out.println("\n\tDu hast diese Runde noch "+(anzahl_Wuerfe -(k+1))+" Versuche, erneut wuerfeln? J/N");
								 String answer = scanner.nextLine();
								 	if(anzahl_Wuerfe==0) {
								 		break;	//hier zum naechsten spieler wechseln
								 	}
									 if(answer.equals("N") || answer.equals("n")) {
										 break; //hier zum naechsten spieler wechseln
									 }
									 
									 if(answer.equals("J") || answer.equals("j")) {
										
										 System.out.println("\n\tWie viele moechtest du aendern?");
										 int aenderung = scanner.nextInt();		//liest  wieviele Würfel geändert werden sollen
										 scanner.nextLine();
										 if(aenderung<=0 || aenderung>=6){
												System.out.println("ungueltige Zahl, Bitte nur Werte zwischen 1 und 5 angeben.");
												continue;
										 }
											 for(int h=0; h<aenderung; h++) {	//läuft solange bis die Zahl von aenderung erreicht ist
												 System.out.println("\n\tWelche Wuerfel von sollen erneut gewuerfelt werden ?");
												 zweiter_Wurf = scanner.nextInt();		// 
												 wurf[zweiter_Wurf-1] = wuerfeln();
												 scanner.nextLine();
													 if(temp==zweiter_Wurf) {	// vergleicht temporäre Variable mit zweiter_Wurf
														 System.out.println("\n\tDu darfst nicht zweimal die gleiche Zahl waehlen");
														 h= h-1; 	// krehrt einen Schritt zurück zur for-Schleife
														continue;
													 }
													 temp=zweiter_Wurf;
													if(zweiter_Wurf<=0 || zweiter_Wurf>=6){
														System.out.println("ungueltige Zahl, Bitte nur Werte zwischen 1 und 5 angeben.");
														continue;
													}
											 }
											 
									  }
						
							}
							
							Arrays.sort(wurf);	//sortiert gewürfeltes Ergebnis
							return wurf;		//druckt gewürfeltes Ergebnis
				}
	
}
