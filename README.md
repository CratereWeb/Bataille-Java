# Bataille-Java

https://esling.github.io/documents/cours1.pdf

## Déroulement d'une partie

- Le jeu distribue les 52 cartes équitablement entre les 2 joueurs. Chaque joueur a alors un paquet.
- Chaque joueur tire la carte située au-dessus de son paquet et la pose face visible sur la table.
- Celui qui a la carte la plus forte (les couleurs ne comptent pas, uniquement les valeurs) ramasse les autres cartes. L'as est la carte la plus forte, puis roi, dame, valet, 10, ...
- Si les deux joueurs posent en même temps une carte de même valeur, il y a "BATAILLE". Les joueurs doivent alors poser la carte suivante face cachée sur le dessus du paquet, puis une seconde carte face visible. La carte la plus forte remporte les deux piles.

## Logique de programmation

### Logique 1 : il n'y a pas de pile propre à chaque joueur au départ

- Le deck de 52 cartes (Bataille.deck) est un dictionnaire, dont les clés sont les couleurs ( ♥, ♦, ♠, ♣ ) et les valeurs un tableau des valeurs de cartes ( 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A ).
- Le deck de chaque joueur (Joueur.deck) est un tableau (plus précisément une file) d'une longueur de 52/2 = 26 cartes. 


- La boucle de jeu (Bataille) appelle à chaque tour une instance de Carte() pour chaque joueur. Ces cartes sont retirées de l'objet Bataille.deck().

- 
 
- La pile de cartes des joueurs est un tableau vide au premier tour.
- A chaque tour, deux éléments du deck de 52 cartes sont respectivement transférés à la pile de chaque joueur.
- Si une carte est plus forte que l'autre, les deux cartes vont à la fin  va dans le deck du joueur ayant la carte la plus forte.
- Si les deux cartes sont de valeurs égales ("bataille") : une carte supplémentaire va du deck à la pile de chaque joueur.
- On compare une nouvelle fois les cartes. S'il y a encore bataille, on recommence jusqu'à ce qu'il y ait un gagnant. Si une carte est plus forte, toutes les cartes sur table vont dans la pile du joueur.


