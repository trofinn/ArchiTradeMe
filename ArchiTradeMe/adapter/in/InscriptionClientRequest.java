package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class InscriptionClientRequest {
    @JsonProperty
    private String email_contact;
    @JsonProperty
    private String nom;
    @JsonProperty
    private String prenom;

    public String getEmail_contact() {
        return email_contact;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public InscriptionClientRequest(String email_contact, String nom, String prenom) {
        this.email_contact = email_contact;
        this.nom = nom;
        this.prenom = prenom;
    }

    InscriptionClientRequest() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscriptionClientRequest that = (InscriptionClientRequest) o;
        return Objects.equals(email_contact, that.email_contact) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email_contact, nom, prenom);
    }
}
