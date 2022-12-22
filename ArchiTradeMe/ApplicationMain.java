import adapter.in.Controller;
import adapter.out.PersistanceAdapter;
import application.port.in.UseCases.AfficheConsultantUseCase;
import application.port.in.UseCases.InscriptionUseCase;
import application.port.in.UseCases.RenseignementsUseCase;
import application.services.AfficheConsultantsService;
import application.services.InscriptionService;
import application.services.RenseignementsService;
import domain.Competence;
import domain.Consultant;

public class ApplicationMain {

    public static void main(String[] args) {

        PersistanceAdapter persistanceAdapter = new PersistanceAdapter();
        InscriptionUseCase inscriptionUseCase = new InscriptionService(persistanceAdapter);
        RenseignementsUseCase renseignementsUseCase = new RenseignementsService(persistanceAdapter);
        AfficheConsultantUseCase afficheConsultantUseCase = new AfficheConsultantsService(persistanceAdapter);
        Controller controller = new Controller(inscriptionUseCase,renseignementsUseCase,afficheConsultantUseCase);

        Consultant consultant = controller.inscription("test@gmail.com","trofin","nicu");
        System.out.println(consultant);

        Competence competence = new Competence("C++");
        controller.add_competence(consultant,competence);

        System.out.println(consultant);
        System.out.println("aaaaaaaaaa\n"+controller.affiche_consultant("test@gmail.com"));
        controller.delete_competence(consultant,competence);
        System.out.println(persistanceAdapter.findAll());

    }
}
