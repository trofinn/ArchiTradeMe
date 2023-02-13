package domain;

import java.util.ArrayList;
import java.util.Objects;

public class Offre {

    private String id;
    private String TJM;
    private ArrayList<Competence> comeptences_necessaires;
    private ArrayList<Modalite> modalites;
    private String date_debut;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offre offre = (Offre) o;
        return Objects.equals(id, offre.id) && Objects.equals(TJM, offre.TJM) && Objects.equals(comeptences_necessaires, offre.comeptences_necessaires) && Objects.equals(modalites, offre.modalites) && Objects.equals(date_debut, offre.date_debut) && Objects.equals(duration, offre.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, TJM, comeptences_necessaires, modalites, date_debut, duration);
    }
}
