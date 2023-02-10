package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ConsultantDto {
    @JsonProperty
    private String email;
    @JsonProperty
    private String nom;
    @JsonProperty
    private String prenom;
    @JsonProperty("competences")
    private ArrayList<CompetenceDto> competences = new ArrayList<>();
    @JsonProperty("TJM")
    private String TJM;
    @JsonProperty("disponibilites")
    private ArrayList<LocalDateTime> disponibilites = new ArrayList<>();
    @JsonProperty("modalites")
    private ArrayList<ModaliteDto> modalites = new ArrayList<>();


    public ConsultantDto(String email, String nom, String prenom) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
    }

    public ConsultantDto(String email, String nom, String prenom, ArrayList<CompetenceDto> competences,
                         String TJM, ArrayList<LocalDateTime> disponibilites, ArrayList<ModaliteDto> modalites) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.competences = competences;
        this.TJM = TJM;
        this.disponibilites = disponibilites;
        this.modalites = modalites;
    }

    public ConsultantDto() {}

    public ConsultantDto add_competence(CompetenceDto competence) {
        competences.add(competence);
        return this;
    }

    public ConsultantDto delete_competence(CompetenceDto competence) {
        competences.remove(competence);
        return this;
    }

    public ConsultantDto set_TJM(String value) {
        this.TJM = value;
        return this;
    }

    public ConsultantDto add_dispo(LocalDateTime date) {
        disponibilites.add(date);
        return this;
    }

    public ConsultantDto delete_dispo(LocalDateTime date) {
        disponibilites.remove(date);
        return this;
    }

    public ConsultantDto add_modalite(ModaliteDto modalite) {
        modalites.add(modalite);
        return this;
    }

    public ConsultantDto delete_modalite(ModaliteDto modalite) {
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

    public ArrayList<CompetenceDto> getCompetences() {
        return competences;
    }

    public String getTJM() {
        return TJM;
    }

    public ArrayList<LocalDateTime> getDisponibilites() {
        return disponibilites;
    }

    public ArrayList<ModaliteDto> getModalites() {
        return modalites;
    }

    @Override
    public String toString() {
        return "ConsultantDto{" +
                "email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", competences=" + competences +
                ", TJM='" + TJM + '\'' +
                ", disponibilites=" + disponibilites +
                ", modalites=" + modalites +
                '}';
    }
}
