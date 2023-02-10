package adapter.in;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.AfficheConsultantCommand;
import application.port.in.DTOs.InscriptionConsultantCommand;
import application.port.in.UseCases.*;
import application.port.in.UseCases.RenseignementsUseCases.*;
import domain.Consultant;


public class Controller {
    private final InscriptionConsultantUseCase inscriptionConsultantUseCase;
    private final AfficheConsultantUseCase afficheConsultantUseCase;
    private final InscriptionClientUseCase inscriptionClientUseCase;
    private final AjouterOffreUseCase ajouterOffreUseCase;
    private final AfficheClientUseCase afficheClientUseCase;
    private final PersistanceAdapter persistanceAdapter;
    private final AddCompetenceUseCase addCompetenceUseCase;
    private final AddDispoUseCase addDispoUseCase;
    private final AddModaliteUseCase addModaliteUseCase;
    private final DeleteCompetenceUseCase deleteCompetenceUseCase;
    private final DeleteDispoUseCase deleteDispoUseCase;
    private final DeleteModaliteUseCase deleteModaliteUseCase;
    private final SetTJMUseCase setTJMUseCase;

    public Controller(InscriptionConsultantUseCase inscriptionConsultantUseCase, AfficheConsultantUseCase afficheConsultantUseCase, InscriptionClientUseCase inscriptionClientUseCase, AjouterOffreUseCase ajouterOffreUseCase, AfficheClientUseCase afficheClientUseCase, PersistanceAdapter persistanceAdapter, AddCompetenceUseCase addCompetenceUseCase, AddDispoUseCase addDispoUseCase, AddModaliteUseCase addModaliteUseCase, DeleteCompetenceUseCase deleteCompetenceUseCase, DeleteDispoUseCase deleteDispoUseCase, DeleteModaliteUseCase deleteModaliteUseCase, SetTJMUseCase setTJMUseCase) {
        this.inscriptionConsultantUseCase = inscriptionConsultantUseCase;
        this.afficheConsultantUseCase = afficheConsultantUseCase;
        this.inscriptionClientUseCase = inscriptionClientUseCase;
        this.ajouterOffreUseCase = ajouterOffreUseCase;
        this.afficheClientUseCase = afficheClientUseCase;
        this.persistanceAdapter = persistanceAdapter;
        this.addCompetenceUseCase = addCompetenceUseCase;
        this.addDispoUseCase = addDispoUseCase;
        this.addModaliteUseCase = addModaliteUseCase;
        this.deleteCompetenceUseCase = deleteCompetenceUseCase;
        this.deleteDispoUseCase = deleteDispoUseCase;
        this.deleteModaliteUseCase = deleteModaliteUseCase;
        this.setTJMUseCase = setTJMUseCase;
    }


    public Consultant inscription(String email, String nom, String prenom) {
        return inscriptionConsultantUseCase.inscription(new InscriptionConsultantCommand(email,nom,prenom));
    }

    public Consultant affiche_consultant(String email) {
        return afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
    }

}
