package org.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.dao.MembreDao;
import org.example.dao.MembreDaoImpl;
import org.example.models.Membre;
import org.example.utils.SceneManager;

import java.util.UUID;

public class AjouterMembreController {

    @FXML
    private TextField Namespace;
    @FXML
    private TextField Personalnamespace;
    @FXML
    private TextField fieldEmail;
    @FXML
    private TextField fieldPhone;

    private MembreDao membreDao= new MembreDaoImpl();

    @FXML
    private void BouttonInserer(){
        String nom = Namespace.getText();
        String prenom = Personalnamespace.getText();
        String email = fieldEmail.getText();
        String phone = fieldPhone.getText();

        if(nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || phone.isEmpty() ){
            afficherAlert(Alert.AlertType.ERROR,"Erreur lors de l'Entrée","Tous les champs asidi doivent etre remplis !!");
        }else {
            String identifier = UUID.randomUUID().toString();
            Membre membre = new Membre(identifier, nom,prenom,email,phone);
            boolean success = membreDao.inserer(membre);
            if(success){
                afficherAlert(Alert.AlertType.INFORMATION,"Good", "Membre ajouté with success !");
                resetFields();
            }else {
                afficherAlert(Alert.AlertType.ERROR,"PROBLEME","Echec lors de l'ajout asidi");
            }
        }
    }
    private void afficherAlert(Alert.AlertType alertType,String titre, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(titre);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
    private void resetFields(){
        Namespace.clear();
        Personalnamespace.clear();
        fieldEmail.clear();
        fieldPhone.clear();
    }
    public void navigateToImportMembres() {
        SceneManager.switchScene("ImportMembres");
    }
}
