## TP4 BREUZON - OPSOMMER

### Fonctionalités
Le projet permet de gérer une petite bibliotheque de livres.
Il a notamment la possibilité d'ajouter des livres dans un panier de commande (ou de les
retirer). Puis de passer une commande.
Il est possible d'accéder à cette fonctionnalité via le détail d'un livre.
Si un livre n'est plus en stock, il est impossible de l'ajouter au panier.

### Utilitites
L'url principale du projet est : localhost:8080/books
`mvn clean package tomee:run` pour lancer le serveur
attention à bien arrêter le serveur en ligne de commande dans le terminal : `exit` ou `quit`

### Tests
Le projet est testé à 27% de couverture.
La difficulté résidant dans la façon de tester les beans et les servlets.

### Code & Architecture
Les Beans sont dans le répertoire entity, les servlets dans le répertoire servlet.
Chaque servlet à sa propre fonctionnalité.
	- Ajouter au panier un livre
	- Afficher les livres et le panier
	- Créer un livre
	- Accéder au détail d'un livre
	- Passer une commande
	- Supprimer un livre du panier
	



 