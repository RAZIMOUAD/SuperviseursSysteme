package org.example.models;


import java.util.Objects;

public class Incident {
    private int reference;
    private String time;
    private String status;
    private Membre membre;

    public Incident(int reference, String time, String status) {
        this.reference = reference;
        this.time = time;
        this.status = status;
    }
    public Membre getMembre() {
        return membre;
    }
    public void setMembre(Membre membre) {
        this.membre = membre;
        if (membre != null && !membre.getIncidents().contains(this)) {
            membre.ajouterIncident(this);
        }
    }
    public int getReference() {
        return reference;
    }
    public void setReference(int reference) {
        this.reference = reference;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
     this.time = time;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Incident{" +
                "reference=" + reference +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", membre=" + (membre != null ? membre.getIdentifier() : "null") +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Incident incident = (Incident) obj;
        return reference == incident.reference;
    }
}
