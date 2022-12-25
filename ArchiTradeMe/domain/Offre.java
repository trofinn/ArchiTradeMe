package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;

public class Offre {

    @JsonProperty
    private String id;
    @JsonProperty
    private String TJM;
    @JsonProperty
    private ArrayList<Competence> comeptences_necessaires;
    @JsonProperty
    private ArrayList<Modalite> modalites;
    @JsonProperty
    private String date_debut;
    @JsonProperty
    private String duration;

    public Offre(String id, String TJM, ArrayList<Competence> comeptences_necessaires,
                 ArrayList<Modalite> modalites,
                 String date_debut, String duration) {
        this.id = id;
        this.TJM = TJM;
        this.comeptences_necessaires = comeptences_necessaires;
        this.modalites = modalites;
        this.date_debut = date_debut;
        this.duration = duration;
    }

    Offre() {}

    @Override
    public String toString() {
        return "Offre{" +
                "id='" + id + '\'' +
                ", TJM='" + TJM + '\'' +
                ", comeptences_necessaires=" + comeptences_necessaires +
                ", modalites=" + modalites +
                ", date_debut=" + date_debut +
                ", duration='" + duration + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getTJM() {
        return TJM;
    }

    public ArrayList<Competence> getComeptences_necessaires() {
        return comeptences_necessaires;
    }

    public ArrayList<Modalite> getModalites() {
        return modalites;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDuration() {
        return duration;
    }
}
