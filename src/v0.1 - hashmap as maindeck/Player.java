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
	private ArrayList<String> deck = new ArrayList<String>();
	
	// constructor method
	public Player(String name) {
		this.name = name;
		this.deck = null;
	}
	
	public String getName() {
		return name;
	}
	
	public void addCardToPlayerFile(String cardName) {
		deck.add(cardName);
	}
	
	
	
	
}
