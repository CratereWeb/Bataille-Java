package fr.afieve.bataille;

public class Card {
	// Contient un constructeur pour créer une carte
	// Attributs: couleur, valeur
		// parmi un tableau
	// Méthodes: accesseurs, modificateurs, comparateur
	
	private int value; // 2 || 3 || 4 || 5 || 6 || 7 || 8 || 9 || 10 || 11 || 12 || 13 || 14
	private char color; // ♥ || ♦ || ♠ || ♣
	
	// Constructeur
	public Card(int value, char color) {
		this.color = color;
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public char getColor() {
		return this.color;
	}
	
	// Retourner la couleur et la valeur de la carte en chaîne de caractères
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
	
	// Convertir les valeurs hautes en caractères alphabétiques
	public char getValueInChar() {
		char charV;
		switch(this.value) {
			case 11: charV = 'J'; break;
			case 12: charV = 'Q'; break;
			case 13: charV = 'K'; break;
			case 14: charV = 'A'; break;
			default: return '?'; // ce cas ne devrait pas se produire, mais j'y ai recours car je n'arrive pas à gérer le scope autrement
		}
		return charV;
	}
	
	

	
	
}
