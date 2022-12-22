package adapter.in;

import application.port.in.DTOs.AfficheConsultantCommand;
import application.port.in.DTOs.InscriptionCommand;
import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.AfficheConsultantUseCase;
import application.port.in.UseCases.InscriptionUseCase;
import application.port.in.UseCases.RenseignementsUseCase;
import domain.Competence;
import domain.Consultant;


public class Controller {
    private final InscriptionUseCase inscriptionUseCase;
    private final RenseignementsUseCase renseignementsUseCase;
    private final AfficheConsultantUseCase afficheConsultantUseCase;

    public Controller(InscriptionUseCase inscriptionUseCase, RenseignementsUseCase renseignementsUseCase, AfficheConsultantUseCase afficheConsultantUseCase) {
        this.inscriptionUseCase = inscriptionUseCase;
        this.renseignementsUseCase = renseignementsUseCase;
        this.afficheConsultantUseCase = afficheConsultantUseCase;
    }


    public Consultant inscription(String email, String nom, String prenom) {
        return inscriptionUseCase.inscription(new InscriptionCommand(email,nom,prenom));
    }

    public Consultant add_competence(Consultant consultant, Competence competence) {
        return renseignementsUseCase.add_competence(new RenseignementsCommand(consultant,competence));
    }

    public Consultant affiche_consultant(String email) {
        return afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
    }

    public Consultant delete_competence(Consultant consultant, Competence competence) {
        return renseignementsUseCase.delete_competence(new RenseignementsCommand(consultant,competence));
    }
}
