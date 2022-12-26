package adapter;

import adapter.out.PersistanceAdapter;
import application.events.ClientAccountCreatedEvent;
import application.events.ConsultantAccountCreatedEvent;
import application.events.OffertAddedEvent;
import application.events.RenseignementsAddedEvent;
import application.port.in.UseCases.AfficheConsultantUseCase;
import application.port.in.UseCases.InscriptionConsultantUseCase;
import application.port.in.UseCases.RenseignementsUseCase;
import application.services.event_handlers.ClientAccountCreatedEventHandler;
import application.services.event_handlers.ConsultantAccountCreatedEventHandler;
import application.services.event_handlers.OffertAddedEventHandler;
import application.services.event_handlers.RenseignementsAddedEventHandler;
import kernel.EventDispatcher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final PersistanceAdapter persistanceAdapter;
    private final InscriptionConsultantUseCase inscriptionConsultantUseCase;
    private final RenseignementsUseCase renseignementsUseCase;
    private final AfficheConsultantUseCase afficheConsultantsUseCase;
    private final ConsultantAccountCreatedEventHandler consultantAccountCreatedEventHandler;
    private final ClientAccountCreatedEventHandler clientAccountCreatedEventHandler;
    private final OffertAddedEventHandler offertAddedEventHandler;
    private final RenseignementsAddedEventHandler renseignementsAddedEventHandler;
    private final EventDispatcher eventDispatcher;

    public StartupApplicationListener(PersistanceAdapter persistanceAdapter, InscriptionConsultantUseCase inscriptionConsultantUseCase,
                                      RenseignementsUseCase renseignementsUseCase,
                                      AfficheConsultantUseCase afficheConsultantsUseCase,
                                      ConsultantAccountCreatedEventHandler consultantAccountCreatedEventHandler,
                                      ClientAccountCreatedEventHandler clientAccountCreatedEventHandler,
                                      OffertAddedEventHandler offertAddedEventHandler, RenseignementsAddedEventHandler renseignementsAddedEventHandler, EventDispatcher eventDispatcher) {

        this.persistanceAdapter = persistanceAdapter;
        this.inscriptionConsultantUseCase = inscriptionConsultantUseCase;
        this.renseignementsUseCase = renseignementsUseCase;
        this.afficheConsultantsUseCase = afficheConsultantsUseCase;
        this.consultantAccountCreatedEventHandler = consultantAccountCreatedEventHandler;
        this.clientAccountCreatedEventHandler = clientAccountCreatedEventHandler;
        this.offertAddedEventHandler = offertAddedEventHandler;
        this.renseignementsAddedEventHandler = renseignementsAddedEventHandler;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        eventDispatcher.register(ConsultantAccountCreatedEvent.class, consultantAccountCreatedEventHandler);
        eventDispatcher.register(ClientAccountCreatedEvent.class, clientAccountCreatedEventHandler);
        eventDispatcher.register(OffertAddedEvent.class, offertAddedEventHandler);
        eventDispatcher.register(RenseignementsAddedEvent.class, renseignementsAddedEventHandler);
    }
}
