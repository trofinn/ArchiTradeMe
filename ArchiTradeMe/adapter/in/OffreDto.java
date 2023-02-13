package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;

public class OffreDto {
    @JsonProperty
    private String id;
    @JsonProperty
    private String TJM;
    @JsonProperty
    private ArrayList<CompetenceDto> comeptences_necessaires;
    @JsonProperty
    private ArrayList<ModaliteDto> modalites;
    @JsonProperty
    private String date_debut;
    @JsonProperty
    private String duration;

    public OffreDto(String id, String TJM, ArrayList<CompetenceDto> comeptences_necessaires,
                 ArrayList<ModaliteDto> modalites,
                 String date_debut, String duration) {
        this.id = id;
        this.TJM = TJM;
        this.comeptences_necessaires = comeptences_necessaires;
        this.modalites = modalites;
        this.date_debut = date_debut;
        this.duration = duration;
    }

    OffreDto() {}

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

    public ArrayList<CompetenceDto> getComeptences_necessaires() {
        return comeptences_necessaires;
    }

    public ArrayList<ModaliteDto> getModalites() {
        return modalites;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffreDto offreDto = (OffreDto) o;
        return Objects.equals(id, offreDto.id) && Objects.equals(TJM, offreDto.TJM) && Objects.equals(comeptences_necessaires, offreDto.comeptences_necessaires) && Objects.equals(modalites, offreDto.modalites) && Objects.equals(date_debut, offreDto.date_debut) && Objects.equals(duration, offreDto.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, TJM, comeptences_necessaires, modalites, date_debut, duration);
    }
}
