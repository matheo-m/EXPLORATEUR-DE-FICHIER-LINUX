# Explorateur de fichiers en Java

Mathéo Moussé

Ce projet implémente un explorateur de fichiers simple écrit en Java. Il permet de naviguer dans une arborescence virtuelle de fichiers et de dossiers, en utilisant des commandes similaires à celles d'un terminal Unix.

---

## Fonctionnalités principales

1. **Exploration de l'arborescence de fichiers :**
   - Commande `ls` pour lister les fichiers et dossiers.
   - Commande `cd <chemin>` pour naviguer entre les dossiers.
   - Commande `mkdir <nom>` pour créer un nouveau dossier.
   - Commande `touch <nom>` pour créer un nouveau fichier.

2. **Affichage dynamique du chemin courant :**
   - Le chemin courant est affiché avant chaque prompt `>`.
   - Exemple :
     ```plaintext
     / > mkdir test
     Directory created: test
     / > cd test
     Changed directory to test
     /test >
     ```

3. **Commande `pwd` :**
   - La commande `pwd` affiche le chemin courant dans l'arborescence.
   - Exemple :
     ```plaintext
     /test > pwd
     /test
     ```

4. **Deux interfaces utilisateur :**
   - **Interface texte (`text`)** : Un terminal interactif où l'utilisateur peut entrer des commandes.
   - **Interface HTTP (`http`)** : Une interface web accessible via un navigateur.

5. **Diagramme UML :**
   - Un diagramme UML (`UML.png`) est inclus pour illustrer la structure de l'application et les relations entre les classes.
   - Le fichier source PlantUML (`UML.plantuml`) est également fourni.

---

## Améliorations apportées

### 1. Ajout du chemin dynamique (`pwd`) dans le prompt
Le chemin actuel est désormais affiché avant le prompt `>` dans l'interface texte. Cela améliore la lisibilité et la navigation en permettant de savoir où l'on se situe dans l'arborescence à tout moment. 

Exemple :
```plaintext
/ > mkdir Documents
Directory created: Documents
/ > cd Documents
Changed directory to Documents
/Documents >
