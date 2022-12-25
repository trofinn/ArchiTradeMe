package application.port.in.DTOs;

public class InscriptionClientCommand {
    private final String email;
    private final String nom;
    private final String prenom;

    public InscriptionClientCommand(String email, String nom, String prenom) {
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
