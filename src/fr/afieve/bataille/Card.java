package fr.afieve.bataille;

public class Card {
	// Contient un constructeur pour créer une carte
	// Attributs: couleur, valeur
		// parmi un tableau
	// Méthodes: accesseurs, modificateurs, comparateur
	
	private char cardValue; // 2 || 3 || 4 || 5 || 6 || 7 || 8 || 9 || 10 || 11 || 12 || 13 
	private char cardColor; // ♥ || ♦ || ♠ || ♣
	
	// constructor method
	public Card(char value, char color) {
		cardColor = color;
		cardValue = value;
	}
	
	
	// return card to string
	public String toString() {
		return "" + cardValue + cardColor;
	}
	
	
}
