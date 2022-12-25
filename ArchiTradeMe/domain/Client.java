package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Client {

    @JsonProperty
    private String email_contact;
    @JsonProperty
    private String nom;
    @JsonProperty
    private String prenom;
    @JsonProperty
    private ArrayList<Offre> offres = new ArrayList<>();

    Client() {}

    public Client(String email_contact, String nom, String prenom) {
        this.email_contact = email_contact;
        this.nom = nom;
        this.prenom = prenom;
    }


    public Client add_offre(Offre offre) {
        offres.add(offre);
        return this;
    }

    public String getEmail() {
        return email_contact;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ArrayList<Offre> getOffres() {
        return offres;
    }


    @Override
    public String toString() {
        return "Client{" +
                "email_contact='" + email_contact + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", offres=" + offres +
                '}';
    }
}