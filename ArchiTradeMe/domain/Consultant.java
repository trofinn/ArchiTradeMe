package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Consultant {

    @JsonProperty
    private String email;
    @JsonProperty
    private String nom;
    @JsonProperty
    private String prenom;
    @JsonProperty("competences")
    private ArrayList<Competence> competences = new ArrayList<>();
    @JsonProperty("TJM")
    private String TJM;
    @JsonProperty("disponibilites")
    private ArrayList<LocalDateTime> disponibilites = new ArrayList<>();
    @JsonProperty("modalites")
    private ArrayList<Modalite> modalites = new ArrayList<>();


    public Consultant(String email, String nom, String prenom) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Consultant() {}

    public Consultant add_competence(Competence competence) {
        competences.add(competence);
        return this;
    }

    public Consultant delete_competence(Competence competence) {
        competences.remove(competence);
        return this;
    }

    public Consultant set_TJM(String value) {
        this.TJM = value;
        return this;
    }

    public Consultant add_dispo(LocalDateTime date) {
        disponibilites.add(date);
        return this;
    }

    public Consultant delete_dispo(LocalDateTime date) {
        disponibilites.remove(date);
        return this;
    }

    public Consultant add_modalite(Modalite modalite) {
        modalites.add(modalite);
        return this;
    }

    public Consultant delete_modalite(Modalite modalite) {
        modalites.remove(modalite);
        return this;
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
