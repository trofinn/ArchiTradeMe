package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Consultant {

    private final String email;
    private final String nom;
    private final String prenom;
    private ArrayList<Competence> competences = new ArrayList<Competence>();
    private int TJM;
    private ArrayList<LocalDateTime> disponibilites = new ArrayList<LocalDateTime>();
    private ArrayList<Modalite> modalites = new ArrayList<Modalite>();


    public Consultant(String email, String nom, String prenom) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Consultant add_competence(Competence competence) {
        competences.add(competence);
        return this;
    }

    public Consultant delete_competence(Competence competence) {
        competences.remove(competence);
        return this;
    }

    public void set_TJM(int value) {
        this.TJM = value;
    }

    public void add_dispo(LocalDateTime date) {
        disponibilites.add(date);
    }

    public void delete_dispo(LocalDateTime date) {
        disponibilites.remove(date);
    }

    public void add_modalite(Modalite modalite) {
        modalites.add(modalite);
    }

    public void delete_modalite(Modalite modalite) {
        modalites.remove(modalite);
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

    @Override
    public String toString() {
        return "Consultant{" +
                "email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", competences=" + competences +
                ", TJM=" + TJM +
                ", disponibilites=" + disponibilites +
                ", modalites=" + modalites +
                '}';
    }
}
