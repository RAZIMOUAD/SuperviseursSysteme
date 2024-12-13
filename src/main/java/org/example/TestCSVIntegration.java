package org.example;

import org.example.models.Membre;
import org.example.service.MembreService;
import org.example.dao.MembreDaoImpl;

import java.util.Set;

public class TestCSVIntegration {
    public static void main(String[] args) {
        // Initialisation des classes nécessaires
        MembreService membreService = new MembreService();
        MembreDaoImpl membreDao = new MembreDaoImpl();

        // Fichier CSV pour le test
        String cheminFichierCSV = "src/main/resources/membres.csv"; // Chemin vers le fichier CSV
        Set<Membre> membres = membreService.chargerListeMembre(cheminFichierCSV);

        System.out.println("Membres chargés depuis le fichier CSV :");
        for (Membre membre : membres) {
            System.out.println(membre.getNom() + " " + membre.getPrenom());
        }

        // Insérer les membres dans le DAO
        for (Membre membre : membres) {
            boolean success = membreDao.inserer(membre);
            if (success) {
                System.out.println("Membre inséré dans le DAO : " + membre.getNom() + " " + membre.getPrenom());
            } else {
                System.out.println("Échec d'insertion : " + membre.getNom() + " " + membre.getPrenom());
            }
        }

        // Vérifier les membres dans le DAO
        System.out.println("Membres dans le DAO après insertion :");
        for (Membre membre : membreDao.listerTous()) {
            System.out.println(membre.getNom() + " " + membre.getPrenom());
        }
    }
}
