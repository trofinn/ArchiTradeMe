package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;

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
}
