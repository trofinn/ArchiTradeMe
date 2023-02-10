package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ClientDto {
    @JsonProperty
    private String email_contact;
    @JsonProperty
    private String nom;
    @JsonProperty
    private String prenom;
    @JsonProperty
    private ArrayList<OffreDto> offres = new ArrayList<>();

    ClientDto() {}

    public ClientDto(String email_contact, String nom, String prenom) {
        this.email_contact = email_contact;
        this.nom = nom;
        this.prenom = prenom;
    }

    public ClientDto(String email_contact, String nom, String prenom, ArrayList<OffreDto> offres) {
        this.email_contact = email_contact;
        this.nom = nom;
        this.prenom = prenom;
        this.offres = offres;
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

    public ArrayList<OffreDto> getOffres() {
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
