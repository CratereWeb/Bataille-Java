package fr.afieve.bataille;


// Programme de jeu principal
/*
 * Propriétés :
 * - un deck de 62 cartes (4 couleurs, 13 cartes par couleur)
 * - deux joueurs (un joueurs humain et un ordinateur)
 * Méthodes : 
 * - Initialise le paquet de cartes et les mélange aléatoirement (Math.random)
 * - Effectue une boucle de jeu :
 * 		- Le joueur, puis l'ordinateur affichant les scores (dans la console)
 * 		- Affiche le vainqueur de la partie s'il y en a un
 */

// Importer la class native HashMap (dictionnaire en Java)
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;


public class Bataille {


	public static void main(String[] args) {
		
		// Initialiser le deck de 52 cartes
		ArrayList<String> mainDeck = initMainDeck();
		

		System.out.println("Bataille de cartes");
		
		System.out.println(mainDeck);
		
		/* -- Création d'un joueur
		//  Demander au joueur son nom
		Scanner sc = new Scanner(System.in);
		System.out.print("Quel est votre nom ? ");
		String playerName = sc.nextLine();
		
		
		Player computer = new Player("computer");
		
		Player player = new Player(playerName);
		System.out.println("Bonjour " + player.getName());
		*/
		
		
		
		// Get random card from main deck
		String randomCard = mainDeck.get((int)Math.ceil(Math.random() * (mainDeck.size() - 2) + 2));
		System.out.println(randomCard);
		mainDeck.remove(randomCard);
		System.out.println(mainDeck);
		
		
		
		//mainDeck.get(3);
		//System.out.println(randomCard);
		//Card computerCard = new Card();
		
		
		// FIN DU JEU
		
		// Détruire le scanner
		//* sc.close();
		
	}
	
	
	private static ArrayList<String> initMainDeck() {
		
		// Initialiser le deck
		ArrayList<String> mainDeck = new ArrayList<String>();

		int[] values = {2,3,4,5,6,7,8,9,10,11,12,13};
		char[] colors = {'♥', '♦', '♠', '♣'};


		for(int v = 0; v < values.length; v++) {
			for(int c = 0; c < colors.length; c++) {
				mainDeck.add("" +  values[v] + colors[c]);
			}
		}
		
		// Mélanger le deck
		Collections.shuffle(mainDeck);

		return mainDeck;
				
	}
	
	private static char valueToChar(int value) {
		// Cette fonction n'est appliqué que pour rendre au joueur une indication lisible de la valeur de sa carte lorsqu'elle est supérieure à 10 (valet, dame, roi, as)
		char charV = 0;
		switch(value) {
			case 11: charV = 'J';
			case 12: charV = 'Q';
			case 13: charV = 'K';
			case 14: charV = 'A';
		}
		return charV;
	}
}

/* Classes / Méthodes / mots clés qui pourraient être utiles (ou pas) :
 * - ArrayList
 * - Collections
 * - compareTo
 */