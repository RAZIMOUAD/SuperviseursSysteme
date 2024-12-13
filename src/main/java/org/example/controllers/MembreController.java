package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.models.Membre;
import org.example.service.MembreService;
import org.example.dao.MembreDaoImpl;
import org.example.utils.SceneManager;

import java.io.File;
import java.util.Set;

public class MembreController {

    public Label messageLabel; // Label pour afficher les messages
    public TableView<Membre> membresTable;
    public TableColumn<Membre, String> nomColumn;
    public TableColumn<Membre, String> prenomColumn;
    public TableColumn<Membre, String> emailColumn;
    public TableColumn<Membre, String> phoneColumn;

    private MembreService membreService = new MembreService(); // Service pour lire les fichiers CSV
    private MembreDaoImpl membreDao = new MembreDaoImpl(); // DAO pour gérer les membres

    public void handleImporterCSV() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner un fichier CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers CSV", "*.csv"));

        File fichier = fileChooser.showOpenDialog(new Stage());
        if (fichier != null) {
            Set<Membre> membres = membreService.chargerListeMembre(fichier.getAbsolutePath());

            for (Membre membre : membres) {
                membreDao.inserer(membre);
            }

            // Mettre à jour la TableView
            membresTable.setItems(FXCollections.observableArrayList(membreDao.listerTous()));

            messageLabel.setText("Importation terminée. Membres ajoutés : " + membres.size());
        } else {
            messageLabel.setText("Aucun fichier sélectionné.");
        }
    }
    public void navigateToAjouterMembre() {
        SceneManager.switchScene("AjouterMembre");
    }

    public void handleAfficherMembres() {
        // Charger les membres dans une liste observable pour la table
        ObservableList<Membre> membresList = FXCollections.observableArrayList(membreDao.listerTous());
        membresTable.setItems(membresList);
    }
}
