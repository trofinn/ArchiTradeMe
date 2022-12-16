import adapter.in.Controller;
import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.InscriptionCommand;
import application.port.in.DTOs.RenseignementsCommand;
import application.services.InscriptionService;
import application.services.RenseignementsService;
import domain.Competence;
import domain.Consultant;
import kernel.BusFactory;
import kernel.CommandBus;
/*
public class ApplicationMain {

    public static void main(String[] args) {

        PersistanceAdapter persistanceAdapter = new PersistanceAdapter();
        CommandBus commandBus = BusFactory.defaultCommandBus();
        commandBus.register(InscriptionCommand.class, new InscriptionService(persistanceAdapter));
        commandBus.register(RenseignementsCommand.class, new RenseignementsService(persistanceAdapter));

        Controller controller = new Controller(commandBus);

        Consultant consultant = controller.inscription("test@gmail.com","trofin","nicu");
        System.out.println(consultant);

        Competence competence = new Competence("C++");
        controller.add_competence(consultant,competence);

        System.out.println(consultant);
        System.out.println(persistanceAdapter.findAll());
        //controller.delete_competence(consultant,competence);
        //System.out.println(persistanceAdapter.findAll());

    }
}*/
