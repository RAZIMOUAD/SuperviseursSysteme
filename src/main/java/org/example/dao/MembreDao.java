package org.example.dao;

import org.example.models.Incident;
import org.example.models.Membre;

import java.util.List;

public interface MembreDao {

    boolean inserer(Membre membre);
    List<Incident> chargerListIncidents(String identifiant);
    List<Membre> listerTous();
}
