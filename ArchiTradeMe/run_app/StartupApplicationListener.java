package run_app;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.InscriptionCommand;
import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.InscriptionUseCase;
import application.port.in.UseCases.RenseignementsUseCase;
import kernel.CommandBus;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final CommandBus commandBus;
    private final PersistanceAdapter persistanceAdapter;
    private final InscriptionUseCase inscriptionUseCase;
    private final RenseignementsUseCase renseignementsUseCase;

    public StartupApplicationListener(CommandBus commandBus, PersistanceAdapter persistanceAdapter, InscriptionUseCase inscriptionUseCase, RenseignementsUseCase renseignementsUseCase) {
        this.commandBus = commandBus;
        this.persistanceAdapter = persistanceAdapter;
        this.inscriptionUseCase = inscriptionUseCase;
        this.renseignementsUseCase = renseignementsUseCase;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        commandBus.register(InscriptionCommand.class, inscriptionUseCase);
        commandBus.register(RenseignementsCommand.class, renseignementsUseCase);
    }
}
