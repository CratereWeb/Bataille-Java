package fr.afieve.bataille;

import java.util.ArrayList;

public class Player {
	/*
	 *  Propriétés :
	 *		- cartes dans son jeu (tableau)
	 *		- compteur de points
	 *	Méthodes :
	 *		- tirer une carte de son paquet
	 *		- poser la carte et la jouer
	 *		
	 */
	private String name;
	private ArrayList<Card> pile = new ArrayList<Card>(); // Cartes sur la table. Contient plusieurs cartes s'il y a bataille.
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	// Constructeur
	public Player(String name, ArrayList<Card> deck, ArrayList<Card> pile) {
		this.name = name;
		this.deck = deck;
	}
	
	public String getName() {
		return name;
	}
	
	public Card getCardFromOwnDeck() {
		Card card = deck.get(0);
		this.deck.remove(card);
		this.pile.add(card);
		return card;
	}
	
	// Ajouter une carte au paquet du joueur
	public void addCardToOwnDeck(Card card) {
		deck.add(card);
	}
	
	public ArrayList<Card> getPile() {
		return this.pile;
	}
	
	public int pileSize() {
		return this.pile.size();
	}
		
	public void clearPile() {
		this.pile.clear();
	}
	
	public int getScore() {
		return this.deck.size();
	}
	
	// logger les cartes dans la console, sous forme de tableau des cartes
	public void logCards() {
		System.out.print("\n"+this.name);
		System.out.print("[");
		this.deck.forEach(card -> {
			System.out.print(card+",");
		});
		System.out.print("]");
		System.out.print("("+this.deck.size()+")");
	}
	
}
