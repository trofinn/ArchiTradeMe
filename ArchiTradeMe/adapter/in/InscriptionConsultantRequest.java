package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class InscriptionConsultantRequest {
    @JsonProperty
    public String email;
    @JsonProperty
    public String nom;
    @JsonProperty
    public String prenom;

    public InscriptionConsultantRequest(String email, String nom, String prenom) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
    }

    InscriptionConsultantRequest() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscriptionConsultantRequest that = (InscriptionConsultantRequest) o;
        return Objects.equals(email, that.email) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, nom, prenom);
    }
}
