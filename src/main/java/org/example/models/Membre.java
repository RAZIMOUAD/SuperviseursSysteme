package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Membre {

    private String identifiant;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private List<Incident> incidents;

    public Membre(String identifiant, String nom, String prenom, String email, String phone) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.incidents = new ArrayList<>();
    }
public String getIdentifier() {
        return identifiant;
}
public void setIdentifier(String identifiant) {
        this.identifiant = identifiant;
}
public String getPrenom(){
        return prenom;
}
public void setPrenom(String prenom) {
        this.prenom = prenom;
}
public String getEmail() {
        return email;
}
public void setEmail(String email) {
        this.email = email;
}
public String getPhone() {
        return phone;
}
public void setPhone(String phone) {
        this.phone = phone;
}
    public String getNom() {
        return nom;
    }

   public void setNom(String nom) {
        this.nom =nom;
   }

    public List<Incident> getIncidents() {
        return incidents;
    }

    @Override
    public String toString() {
        return "Membre{" +
                "identifiant=" + identifiant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone +
                '}';
    }
    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        Membre membre = (Membre) o ;
        return Objects.equals(identifiant,membre.identifiant);
    }
    @Override
    public int hashCode() {
        return Objects.hash(identifiant);
    }
    public void ajouterIncident(Incident incident) {
        if (incident != null && !incidents.contains(incident)) {
            incidents.add(incident);
            incident.setMembre(this);
        }

    }
}
