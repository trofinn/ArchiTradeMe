package adapter;

import adapter.out.PersistanceAdapter;
import application.events.ConsultantAccountCreatedEvent;
import application.port.in.UseCases.AfficheConsultantUseCase;
import application.port.in.UseCases.InscriptionUseCase;
import application.port.in.UseCases.RenseignementsUseCase;
import application.services.ConsultantAccountCreatedEventHandler;
import kernel.EventDispatcher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final PersistanceAdapter persistanceAdapter;
    private final InscriptionUseCase inscriptionUseCase;
    private final RenseignementsUseCase renseignementsUseCase;
    private final AfficheConsultantUseCase afficheConsultantsUseCase;
    private final ConsultantAccountCreatedEventHandler consultantAccountCreatedEventHandler;
    private final EventDispatcher eventDispatcher;
    public StartupApplicationListener(PersistanceAdapter persistanceAdapter, InscriptionUseCase inscriptionUseCase, RenseignementsUseCase renseignementsUseCase, AfficheConsultantUseCase afficheConsultantsUseCase, ConsultantAccountCreatedEventHandler consultantAccountCreatedEventHandler, EventDispatcher eventDispatcher) {
        this.persistanceAdapter = persistanceAdapter;
        this.inscriptionUseCase = inscriptionUseCase;
        this.renseignementsUseCase = renseignementsUseCase;
        this.afficheConsultantsUseCase = afficheConsultantsUseCase;
        this.consultantAccountCreatedEventHandler = consultantAccountCreatedEventHandler;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        eventDispatcher.register(ConsultantAccountCreatedEvent.class, consultantAccountCreatedEventHandler);
    }
}
