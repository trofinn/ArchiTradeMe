package adapter.out;

import adapter.StartupApplicationListener;
import adapter.in.Controller;
import application.port.in.UseCases.*;
import application.port.in.UseCases.RenseignementsUseCases.*;
import application.services.*;
import application.services.event_handlers.ClientAccountCreatedEventHandler;
import application.services.event_handlers.ConsultantAccountCreatedEventHandler;
import application.services.event_handlers.OffertAddedEventHandler;
import application.services.event_handlers.enseignements_handlers.*;
import application.services.renseignements_services.*;
import domain.Competence;
import domain.Consultant;
import kernel.DefaultEventDispatcher;
import kernel.EventDispatcher;

public class ApplicationMain {

    public static void main(String[] args) {

        PersistanceAdapter persistanceAdapter = new PersistanceAdapter();
        EventDispatcher eventDispatcher = DefaultEventDispatcher.create();
        InscriptionConsultantUseCase inscriptionConsultantUseCase = new InscriptionConsultantService(persistanceAdapter, eventDispatcher);
        AfficheConsultantUseCase afficheConsultantUseCase = new AfficheConsultantsService(persistanceAdapter);
        final InscriptionClientUseCase inscriptionClientUseCase = new InscriptionClientService(persistanceAdapter, eventDispatcher);
        final AjouterOffreUseCase ajouterOffreUseCase = new OffresService(persistanceAdapter, eventDispatcher);
        final AfficheClientUseCase afficheClientUseCase = new AfficheClientService(persistanceAdapter);
        final AddCompetenceUseCase addCompetenceUseCase = new AddCompetenceService(persistanceAdapter, eventDispatcher);
        final AddDispoUseCase addDispoUseCase = new AddDispoService(persistanceAdapter,eventDispatcher);
        final AddModaliteUseCase addModaliteUseCase = new AddModaliteService(persistanceAdapter, eventDispatcher);
        final DeleteCompetenceUseCase deleteCompetenceUseCase = new DeleteCompetenceService(persistanceAdapter, eventDispatcher);
        final DeleteDispoUseCase deleteDispoUseCase = new DeleteDispoService(persistanceAdapter, eventDispatcher);
        final DeleteModaliteUseCase deleteModaliteUseCase = new DeleteModaliteService(persistanceAdapter, eventDispatcher);
        final SetTJMUseCase setTJMUseCase = new SetTJMService(persistanceAdapter, eventDispatcher);


        Controller controller = new Controller(inscriptionConsultantUseCase,afficheConsultantUseCase, inscriptionClientUseCase, ajouterOffreUseCase,
                afficheClientUseCase, persistanceAdapter, addCompetenceUseCase, addDispoUseCase, addModaliteUseCase, deleteCompetenceUseCase,
                deleteDispoUseCase, deleteModaliteUseCase, setTJMUseCase);

       Consultant consultant = controller.inscription("test@gmail.com","trofin","nicu");
       System.out.println(consultant);
        controller.affiche_consultant("test@gmail.com");

        Competence competence = new Competence("C++");

        //System.out.println(consultant);
        System.out.println("aaaaaaaaaa\n"+controller.affiche_consultant("test@gmail.com"));
        System.out.println(persistanceAdapter.findAll());

    }
}
