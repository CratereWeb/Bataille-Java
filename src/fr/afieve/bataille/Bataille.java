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
		
		boolean play = false;
		
		System.out.println("Bataille de cartes");
		System.out.println("Pour commencer une nouvelle partie, entrez votre nom et appuyez sur ENTREE.\n");
		
		
		// Initialiser le deck de 52 cartes
		ArrayList<Card> mainDeck = initMainDeck();
		// System.out.println(mainDeck);
		
		
		// Création des joueurs
		Scanner sc = new Scanner(System.in);
		String playerName = sc.nextLine();
		if(playerName.length() > 1) {
			play = true;						
		}
		
		Player player = new Player(playerName, new ArrayList<Card>(), new ArrayList<Card>());			
		Player computer = new Player("computer", new ArrayList<Card>(), new ArrayList<Card>());
		
		System.out.println("\nBienvenue " + player.getName() + "!");
		
		// Distribution des cartes du deck équitablement à chaque joueur
		for(int i = 0; i < mainDeck.size(); i+=2) {
			computer.addCardToOwnDeck(mainDeck.get(i));
			player.addCardToOwnDeck(mainDeck.get(i+1));
		}
		
		
		do {
			
			// DO boucle de jeu
			// WHILE le score d'un joueur n'est pas égal à 52, c'est-à-dire quand il a toutes les cartes
			do {				
				// LANCEMENT DU JEU
				System.out.println("La partie peut commencer ! Vous allez affronter l'ordinateur.");
				
				System.out.println("\n------- SCORES -------");
				System.out.println("Vous   " + player.getScore() + " - " + computer.getScore() + "   Ordinateur");
				//player.logCards();
				//computer.logCards();
				
				System.out.println("\nAppuyer sur ENTREE pour tirer une carte.");
				String nextRound = sc.nextLine();
				
				
				if(nextRound == "") {
					
					Player winner = null;
					Player loser = null;
					Card playerCard = null;
					Card computerCard = null;
					Card playerHiddenCard = null;
					Card computerHiddenCard = null;
					
					do {
						playerCard = player.getCardFromOwnDeck();
						computerCard = computer.getCardFromOwnDeck();
						
						winner = fight(player, playerCard, computer, computerCard);
						
						if(winner == null) {
							System.out.println("Appuyer sur Entrée tirer une autre carte !");
							String playBataille = sc.nextLine();
							if(playBataille == "") {
								System.out.println("Chaque joueur pose une carte face cachée... puis...");
								// Chaque joueur joue une carte face cachée
								playerHiddenCard = player.getCardFromOwnDeck();
								computerHiddenCard = computer.getCardFromOwnDeck();
								continue;
							}
							
						} else if(winner == player) {
							loser = computer;
						} else {
							loser = player;
						}
						
					} while(winner == null);
					
					// Le gagnant ajoute à son deck sa propre pile et celle du perdant
					for(int i= 0; i < loser.pileSize(); i++) {
						winner.addCardToOwnDeck(loser.getPile().get(i));
					}
					for(int i= 0; i < winner.pileSize(); i++) {
						winner.addCardToOwnDeck(winner.getPile().get(i));
					}
					winner.clearPile();
					loser.clearPile();
				}
				
			} while (player.getScore() < 52 && computer.getScore() < 52);
			
			System.out.println("\n\nFIN DE PARTIE !");
			if(player.getScore() == 52) {
				System.out.println("\n\nBravo ! Vous remportez la partie !");
			} else {				
				System.out.println("\n\nEt bien... on dirait bien que c'est l'ordinateur qui a gagné cette fois...");
			}
			
			
			
			play = false;
			System.out.println("\nPour rejouer une partie, appuyez sur + puis sur ENTREE.");
			System.out.println("Pour quitter le jeu, écrivez 'bye' et appuyer sur ENTREE.");
			
			String replayInput = sc.nextLine();
			if(replayInput == "+") {
				play = true;
			} else if(replayInput == "bye" || replayInput == "BYE" || replayInput == "Bye") {
				play = false;
			}
			
			
		} while(play = true);
		
		play = false;
		sc.close();
		System.out.println("Bye bye " + player.getName() + " !");
				
	}
	
	
	private static ArrayList<Card> initMainDeck() {
		
		// Initialiser le deck
		ArrayList<Card> mainDeck = new ArrayList<Card>();

		int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};
		char[] colors = {'♥', '♦', '♠', '♣'};


		for(int v = 0; v < values.length; v++) {
			for(int c = 0; c < colors.length; c++) {
				mainDeck.add(new Card(values[v], colors[c]));
			}
		}
		
		// Mélanger le deck
		Collections.shuffle(mainDeck);

		return mainDeck;
				
	}
	
	private static Player fight(Player player, Card playerCard, Player computer, Card computerCard) {
		
		System.out.print("\nVous jouez ");
		if(playerCard.isCardValueHigh() == true) {
			System.out.print("" + playerCard.getValueInChar() + playerCard.getColor());
		} else {
			System.out.print("" + playerCard.getValue() + playerCard.getColor());
		}
		
		
		System.out.print("\nL'ordinateur joue ");
		if(computerCard.isCardValueHigh() == true) {
			System.out.print("" + computerCard.getValueInChar() + computerCard.getColor());
		} else {
			System.out.print("" + computerCard.getValue() + computerCard.getColor());
		}
		
		
		
		if(playerCard.getValue() > computerCard.getValue()) {
			System.out.print("\nVous remportez la manche.");
			return player;
		} else if(playerCard.getValue() < computerCard.getValue()){
			System.out.print("\nL'ordinateur remporte la manche.");
			return computer;
		} else {
			System.out.print("\n/!\\ BATAILLE ! ");
			return null;
		}
		
		
	}
	
	
}