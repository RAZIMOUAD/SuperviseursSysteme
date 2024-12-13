package org.example.dao;

import org.example.models.Incident;

import java.util.HashSet;
import java.util.Set;

public class IncidentDaoImpl implements IncidentDao {
    private Set<Incident> incidents = new HashSet<>();

    @Override
    public boolean inserer (Incident incident) {
        if(incident==null){
            return false;
        }

        return incidents.add(incident);
    }
    @Override
    public boolean inserer(Set<Incident> incidents){
        if(incidents==null || incidents.isEmpty()){
            return false;
        }
        return this.incidents.addAll(incidents);
    }
    public Set<Incident> getIncidents() {
        return new HashSet<>(incidents); 
    }
}
