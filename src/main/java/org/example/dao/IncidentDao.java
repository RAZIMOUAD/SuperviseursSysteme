package org.example.dao;

import org.example.models.Incident;

import java.util.Set;

public interface IncidentDao {
    boolean inserer(Incident incident);
    boolean inserer(Set<Incident> incidents);
}
