package application.events;

import kernel.Event;

public class ClientAccountCreatedEvent implements Event {
    private final String email;
    private final String nom;
    private final String prenom;

    public ClientAccountCreatedEvent(String email, String nom, String prenom) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
