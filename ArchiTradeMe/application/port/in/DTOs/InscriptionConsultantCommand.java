package application.port.in.DTOs;

import javax.validation.constraints.NotNull;

public class InscriptionConsultantCommand {
    @NotNull
    private final String email;
    @NotNull
    private final String nom;
    @NotNull
    private final String prenom;

    public InscriptionConsultantCommand(String email, String nom, String prenom) {
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
