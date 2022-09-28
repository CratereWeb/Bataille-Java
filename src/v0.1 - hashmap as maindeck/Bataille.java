package fr.afieve.bataille;

//Programme de jeu principal


/*
* Propriétés :
* - un deck de 62 cartes (4 couleurs, 13 cartes par couleur)
* - deux joueurs (un joueurs humain et un ordinateur)
* Méthodes : 
* - Initialise le paquet de cartes et les mélange aléatoirement (Math.random)
* 		(note: ici les cartes ne sont pas mélangés, c'est le générateur de cartes qui prend une carte au hasard)
* - Effectue une boucle de jeu :
* 		- Le joueur, puis l'ordinateur affichant les scores (dans la console)
* 		- Affiche le vainqueur de la partie s'il y en a un
*/

//Importer la class native HashMap (dictionnaire en Java)
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Bataille {

	public static void main(String[] args) {

		HashMap<Character, int[]> mainDeck = new HashMap<Character, int[]>();
		System.out.println("Bataille de cartes");
		
		// Demander au joueur son nom
		Scanner sc = new Scanner(System.in);
		
		
		/* -- Création du joueur
		 * System.out.print("Quel est votre nom ? ");
		 * String playerName = sc.nextLine();
		 * Player computer = new Player("computer");
		 * Player player = new Player(playerName);
		 * System.out.println("Bonjour " + player.getName());
		*/

		
		// Initialiser le deck de 52 cartes
		mainDeck = initMainDeck(mainDeck); // Le paquet est ordonné
		// Mélanger le paquet
		
		// Obtenir un élément du paquet
		getCardFromMainDeck(mainDeck, 13, '♥');
		
		
		// FIN DU JEU
		// Détruire le scanner
		sc.close();		
		
	}
	
	private static HashMap<Character, int[]> initMainDeck(HashMap<Character, int[]> mainDeck) {
		
		// ♥, ♦, ♠, ♣ 
		int[] values = {2,3,4,5,6,7,8,9,10,11,12,13};
		char[] colors = {'♥', '♦', '♠', '♣'};
		
		for(int c = 0; c < colors.length; c++) {
			mainDeck.put(colors[c], values);
			System.out.println(colors[c] + " : " + Arrays.toString(values));
		}
		
		return mainDeck; // deck ordonné
	}
	
	
	
	
	private static void getCardFromMainDeck(HashMap<Character, int[]> mainDeck, int value, char color) {
		// log un élément
		
		// System.out.println(mainDeck.values().stream().mapToInt(value -> value[0]).toArray());
		// System.out.println(mainDeck.get('♥'));
		int[] oldValues = mainDeck.get(color);
		int[] newValues = new int[mainDeck.get(color).length - 1];
		
		
		for(int i = 0; i < oldValues.length; i++) {
			if(oldValues[i] != value) {
				newValues[i] = oldValues[i];
			}
		}
		
		
		System.out.println("old values :");
		System.out.println(Arrays.toString(oldValues));
		System.out.println(Arrays.stream(oldValues).anyMatch(i -> i == value));
		
		mainDeck.replace(color, newValues);
		
		System.out.println("new values");
		System.out.println(Arrays.toString(newValues));
		System.out.println(Arrays.stream(newValues).anyMatch(i -> i == value));
		
		
		
	}
}

/* Classes / Méthodes / mots clés qui pourraient être utiles (ou pas) :
* - ArrayList
* - Collections
* - compareTo
*/