package org.example.service;

import org.example.models.Membre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MembreService {

    public Set<Membre> chargerListeMembre(String nomFichier){
        Set<Membre> members = new HashSet<>();
        try(BufferedReader br = new BufferedReader(new FileReader(nomFichier))){
            String ligne;
            while((ligne= br.readLine() )!= null){
                String[] tokens = ligne.split(",");
                if (tokens.length == 4){
                    String nom = tokens[0].trim();
                    String prenom = tokens[1].trim();
                    String email = tokens[2].trim();
                    String phone = tokens[3].trim();
                    String identifiant = nom + prenom;
                    Membre membre = new Membre(identifiant, nom, prenom, email, phone);
                    members.add(membre);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return members;
    }
}
