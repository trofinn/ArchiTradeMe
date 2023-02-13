package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultantDto that = (ConsultantDto) o;
        return Objects.equals(email, that.email) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(competences, that.competences) && Objects.equals(TJM, that.TJM) && Objects.equals(disponibilites, that.disponibilites) && Objects.equals(modalites, that.modalites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, nom, prenom, competences, TJM, disponibilites, modalites);
    }
}
