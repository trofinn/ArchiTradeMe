package adapter;

import adapter.out.PersistanceAdapter;
import application.events.ClientAccountCreatedEvent;
import application.events.ConsultantAccountCreatedEvent;
import application.events.OffertAddedEvent;
import application.events.Renseignements.RenseignementsAddedEvent;
import application.port.in.UseCases.AfficheConsultantUseCase;
import application.port.in.UseCases.InscriptionConsultantUseCase;
import application.services.event_handlers.ClientAccountCreatedEventHandler;
import application.services.event_handlers.ConsultantAccountCreatedEventHandler;
import application.services.event_handlers.OffertAddedEventHandler;
import application.services.event_handlers.enseignements_handlers.*;
import kernel.EventDispatcher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final PersistanceAdapter persistanceAdapter;
    private final InscriptionConsultantUseCase inscriptionConsultantUseCase;
    private final AfficheConsultantUseCase afficheConsultantsUseCase;
    private final ConsultantAccountCreatedEventHandler consultantAccountCreatedEventHandler;
    private final ClientAccountCreatedEventHandler clientAccountCreatedEventHandler;
    private final OffertAddedEventHandler offertAddedEventHandler;
    private final CompetenceAddedEventHandler competenceAddedEventHandler;
    private final CompetenceDeletedEventHandler competenceDeletedEventHandler;
    private final DispoAddedEventHandler dispoAddedEventHandler;
    private final DispoDeletedEventHandler dispoDeletedEventHandler;
    private final ModaliteAddedEventHandler modaliteAddedEventHandler;
    private final ModaliteDeletedEventHandler modaliteDeletedEventHandler;
    private final TJMUpdatedEventHandler tjmUpdatedEventHandler;
    private final EventDispatcher eventDispatcher;

    public StartupApplicationListener(PersistanceAdapter persistanceAdapter, InscriptionConsultantUseCase inscriptionConsultantUseCase,
                                      AfficheConsultantUseCase afficheConsultantsUseCase,
                                      ConsultantAccountCreatedEventHandler consultantAccountCreatedEventHandler,
                                      ClientAccountCreatedEventHandler clientAccountCreatedEventHandler,
                                      OffertAddedEventHandler offertAddedEventHandler, CompetenceAddedEventHandler competenceAddedEventHandler,
                                      CompetenceDeletedEventHandler competenceDeletedEventHandler, DispoAddedEventHandler dispoAddedEventHandler,
                                      DispoDeletedEventHandler dispoDeletedEventHandler, ModaliteAddedEventHandler modaliteAddedEventHandler,
                                      ModaliteDeletedEventHandler modaliteDeletedEventHandler, TJMUpdatedEventHandler tjmUpdatedEventHandler, EventDispatcher eventDispatcher) {

        this.persistanceAdapter = persistanceAdapter;
        this.inscriptionConsultantUseCase = inscriptionConsultantUseCase;
        this.afficheConsultantsUseCase = afficheConsultantsUseCase;
        this.consultantAccountCreatedEventHandler = consultantAccountCreatedEventHandler;
        this.clientAccountCreatedEventHandler = clientAccountCreatedEventHandler;
        this.offertAddedEventHandler = offertAddedEventHandler;
        this.competenceAddedEventHandler = competenceAddedEventHandler;
        this.competenceDeletedEventHandler = competenceDeletedEventHandler;
        this.dispoAddedEventHandler = dispoAddedEventHandler;
        this.dispoDeletedEventHandler = dispoDeletedEventHandler;
        this.modaliteAddedEventHandler = modaliteAddedEventHandler;
        this.modaliteDeletedEventHandler = modaliteDeletedEventHandler;
        this.tjmUpdatedEventHandler = tjmUpdatedEventHandler;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        eventDispatcher.register(ConsultantAccountCreatedEvent.class, consultantAccountCreatedEventHandler);
        eventDispatcher.register(ClientAccountCreatedEvent.class, clientAccountCreatedEventHandler);
        eventDispatcher.register(OffertAddedEvent.class, offertAddedEventHandler);
        eventDispatcher.register(RenseignementsAddedEvent.class, competenceAddedEventHandler);
        eventDispatcher.register(RenseignementsAddedEvent.class, competenceDeletedEventHandler);
        eventDispatcher.register(RenseignementsAddedEvent.class, dispoAddedEventHandler);
        eventDispatcher.register(RenseignementsAddedEvent.class, dispoDeletedEventHandler);
        eventDispatcher.register(RenseignementsAddedEvent.class, modaliteAddedEventHandler);
        eventDispatcher.register(RenseignementsAddedEvent.class, modaliteDeletedEventHandler);
        eventDispatcher.register(RenseignementsAddedEvent.class, tjmUpdatedEventHandler);
    }
}
