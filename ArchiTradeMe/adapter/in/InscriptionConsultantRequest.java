package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InscriptionConsultantRequest {
    @JsonProperty
    public String email;
    @JsonProperty
    public String nom;
    @JsonProperty
    public String prenom;
}
