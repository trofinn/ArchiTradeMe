package application.events;

import domain.Competence;
import domain.Modalite;
import kernel.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ConsultantAccountCreatedEvent implements Event {
    private final String email;
    private final String nom;
    private final String prenom;

    public ConsultantAccountCreatedEvent(String email, String nom,
                                         String prenom) {
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
