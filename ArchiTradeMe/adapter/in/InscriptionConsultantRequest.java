package adapter.in;

import javax.validation.constraints.NotNull;

public class InscriptionConsultantRequest {
    @NotNull
    public String email;
    @NotNull
    public String nom;
    @NotNull
    public String prenom;
}
