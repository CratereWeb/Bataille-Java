package fr.afieve.bataille;

public class Card {
	// Contient un constructeur pour créer une carte
	// Attributs: couleur, valeur
		// parmi un tableau
	// Méthodes: accesseurs, modificateurs, comparateur
	
	private int value; // 2 || 3 || 4 || 5 || 6 || 7 || 8 || 9 || 10 || 11 || 12 || 13 || 14
	private char color; // ♥ || ♦ || ♠ || ♣
	
	// constructor method
	public Card(int value, char color) {
		this.color = color;
		this.value = value;
	}
	
	
	// return card to string
	public String toString() {
		return "" + this.value + this.color;
	}
	
	public boolean isCardValueHigh() {
		if(this.value > 10) {
			return true;
		} else {
			return false;
		}
	}
	
	public char getValueInChar() {
		// Cette fonction est appliquée pour rendre lisible au joueur la valeur de sa carte lorsqu'elle est supérieure à 10 (valet, dame, roi, as)
		char charV;
		switch(this.value) {
			case 11: charV = 'J'; break;
			case 12: charV = 'Q'; break;
			case 13: charV = 'K'; break;
			case 14: charV = 'A'; break;
			default: return '?'; // ne devrait pas se produire, mais je n'arrive pas à gérer le problème de scope
		}
		return charV;
	}
	
	public int getValue() {
		return this.value;
	}

	public char getColor() {
		return this.color;
	}	
	
	
}
