package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(email_contact, clientDto.email_contact) && Objects.equals(nom, clientDto.nom) && Objects.equals(prenom, clientDto.prenom) && Objects.equals(offres, clientDto.offres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email_contact, nom, prenom, offres);
    }
}
