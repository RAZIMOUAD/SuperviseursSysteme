# Superviseurs Systeme

## Description
Ce projet est un **mini-projet JavaFX** visant à gérer les membres d'une équipe de superviseurs ainsi que les incidents associés. Il a été conçu pour apprendre :
- Les bases de la **programmation orientée objet (POO)**.
- La gestion des **interfaces graphiques** avec JavaFX.
- L'importation de données à partir de fichiers CSV
## Fonctionnalités
1. **Gestion des membres** :
   - Ajout d'un nouveau membre via un formulaire.
   - Importation de membres à partir d'un fichier CSV (avec gestion des doublons).
   - Affichage des membres dans une interface graphique.

2. **Gestion des incidents** :
   - Création et association d'incidents à des membres.
   - Visualisation des incidents d'un membre spécifique.

3. **Navigation dans l'application** :
   - Deux écrans principaux :
     - **Écran Importation des Membres**.
     - **Écran Ajout d'un Membre**.
   - Navigation fluide entre les écrans.
## Technologies utilisées
- **Langage** : Java (JDK 22)
- **Interface graphique** : JavaFX
- **Structure du projet** : POO (Programmation Orientée Objet)
- **Gestion des données** : Collections Java (`Map`, `Set`, `List`)
## **Structure du projet**
Voici la structure principale du projet :

```
src/
├── main/
│   ├── java/
│   │   ├── org.example/
│   │   │   ├── controllers/          # Contrôleurs des écrans FXML
│   │   │   │   ├── ImportMembresController.java
│   │   │   │   ├── AjouterMembreController.java
│   │   │   ├── dao/                  # Interfaces et implémentations DAO
│   │   │   │   ├── MembreDao.java
│   │   │   │   ├── MembreDaoImpl.java
│   │   │   ├── models/               # Modèles de données
│   │   │   │   ├── Membre.java
│   │   │   │   ├── Incident.java
│   │   │   ├── services/             # Service pour gérer les fichiers CSV
│   │   │   │   ├── MembreService.java
│   │   │   ├── utils/                # Outils utilitaires
│   │   │   │   ├── DatabaseConnection.java
│   │   │   │   ├── SceneManager.java
│   │   │   └── MainApp.java          # Classe principale
│   ├── resources/
│   │   ├── fxml/                     # Fichiers FXML pour les interfaces
│   │   │   ├── importMembres.fxml
│   │   │   ├── ajouterMembre.fxml
│   │   └── membres.csv               # Fichier de test CSV
```
---

## **Installation et exécution**

### **Prérequis**
- **JDK 22** ou version compatible.
- **JavaFX SDK** (téléchargeable depuis [OpenJFX](https://openjfx.io/)).

  ### **Étapes**
1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/RAZIMOUAD/SuperviseursSysteme.git
   cd SuperviseursSysteme
   ```

2. **Configurer JavaFX dans votre IDE** :
   Ajoutez les arguments VM suivants dans votre configuration d'exécution :
   ```plaintext
   --module-path "chemin/vers/javafx/lib" --add-modules javafx.controls,javafx.fxml
   ```

3. **Lancer l'application** :
   Exécutez la classe principale `MainApp.java` pour démarrer l'interface.

---

## **Exemple de fichier CSV**
Voici un aperçu du format attendu pour les fichiers CSV à importer :
```csv
Jean, Dupont, jean.dupont@example.com, 123456789
Alice, Martin, alice.martin@example.com, 987654321
Paul, Durand, paul.durand@example.com, 123450987
Jean, Dupont, jean.dupont@example.com, 123456789
```

---
---

## **Auteur**
Projet réalisé par **RAZI MOUAD**, étudiant en **ingénierie informatique**.

---
## **Améliorations possibles**
- Ajouter des fonctionnalités supplémentaires pour la gestion des incidents.
- Créer un écran de visualisation détaillée des incidents d'un membre.
- Ajouter des tests unitaires pour valider les fonctionnalités principales.
