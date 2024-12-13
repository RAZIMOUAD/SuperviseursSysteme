package org.example.dao;

import org.example.models.Incident;
import org.example.models.Membre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MembreDaoImpl implements MembreDao {
    private Map<String, Membre> members = new HashMap<>();
    private Map<String, List<Incident>> incidentsMembers = new HashMap<>();

    @Override
    public boolean inserer(Membre membre) {
        if (membre==null || members.containsKey(membre.getIdentifier())){
            return false;
        }
        members.put(membre.getIdentifier(), membre);
        incidentsMembers.put(membre.getIdentifier(), new ArrayList<>());
        return true;
    }
    @Override
    public List<Incident> chargerListIncidents(String identifiant){
        return incidentsMembers.getOrDefault(identifiant, new ArrayList<>());
    }
    public boolean ajouterIncident(String identifiantMembre, Incident incident) {
        Membre membre = members.get(identifiantMembre);
        if (membre == null || incident == null) {
            return false;
        }
        membre.ajouterIncident(incident);
        return true;
    }
    @Override
    public List<Membre> listerTous() {
        return new ArrayList<>(members.values());
    }

}
