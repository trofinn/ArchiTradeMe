package application.port.in.DTOs;

import domain.Client;
import domain.Competence;
import domain.Modalite;
import domain.Offre;

import java.time.LocalDate;
import java.util.ArrayList;

public class AjouterOffreCommand {
    public Client client;
    public Offre offre;

    public AjouterOffreCommand(Client client, Offre offre) {
        this.client = client;
        this.offre = offre;
    }

    public Client getClient() {
        return client;
    }

    public Offre getOffre() {
        return offre;
    }
}
