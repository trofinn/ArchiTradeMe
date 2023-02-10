package adapter;

import adapter.out.LogNotification;
import adapter.out.PersistanceAdapter;
import application.port.in.UseCases.*;
import application.port.in.UseCases.RenseignementsUseCases.*;
import application.services.*;
import application.services.event_handlers.ClientAccountCreatedEventHandler;
import application.services.event_handlers.ConsultantAccountCreatedEventHandler;
import application.services.event_handlers.OffertAddedEventHandler;
import application.services.event_handlers.enseignements_handlers.*;
import application.services.renseignements_services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kernel.DefaultEventDispatcher;
import kernel.EventDispatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public PersistanceAdapter persistanceAdapter() {
        return new PersistanceAdapter();
    }

    @Bean
    public EventDispatcher eventDispatcher() {
        return DefaultEventDispatcher.create();
    }

    @Bean
    public InscriptionConsultantUseCase inscriptionUseCase() {
        return new InscriptionConsultantService(persistanceAdapter(), eventDispatcher());}

    @Bean
    public AfficheConsultantUseCase afficheConsultantsUseCase() { return new AfficheConsultantsService(persistanceAdapter());}

    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

    @Bean
    public InscriptionClientUseCase inscriptionClientUseCase() {return new InscriptionClientService(persistanceAdapter(), eventDispatcher());}

    @Bean
    public AjouterOffreUseCase ajouterOffreUseCase() { return  new OffresService(persistanceAdapter(), eventDispatcher());}

    @Bean
    public AfficheClientUseCase afficheClientUseCase() { return new AfficheClientService(persistanceAdapter());}

    @Bean
    AddCompetenceUseCase addCompetenceUseCase() { return new AddCompetenceService(persistanceAdapter(), eventDispatcher());}

    @Bean
    DeleteCompetenceUseCase deleteCompetenceUseCase() { return new DeleteCompetenceService(persistanceAdapter(), eventDispatcher());}

    @Bean
    AddModaliteUseCase addModaliteUseCase() { return new AddModaliteService(persistanceAdapter(), eventDispatcher()); }

    @Bean
    DeleteModaliteUseCase deleteModaliteUseCase() { return new DeleteModaliteService(persistanceAdapter(), eventDispatcher());}

    @Bean
    AddDispoUseCase addDispoUseCase() { return new AddDispoService(persistanceAdapter(), eventDispatcher());}

    @Bean
    DeleteDispoUseCase deleteDispoUseCase() { return new DeleteDispoService(persistanceAdapter(), eventDispatcher());}

    @Bean
    SetTJMUseCase setTJMUseCase() { return new SetTJMService(persistanceAdapter(), eventDispatcher());}

    @Bean
    public LogNotification notifications() {
        return new LogNotification();
    }

    @Bean
    public ConsultantAccountCreatedEventHandler consultantAccountCreatedEventHandler() { return new ConsultantAccountCreatedEventHandler(notifications());}

    @Bean
    public ClientAccountCreatedEventHandler clientAccountCreatedEventHandler() { return new ClientAccountCreatedEventHandler(notifications());}

    @Bean
    public OffertAddedEventHandler offertAddedEventHandler() { return new OffertAddedEventHandler(notifications());}

    @Bean
    public CompetenceAddedEventHandler competenceAddedEventHandler() { return new CompetenceAddedEventHandler(notifications());}

    @Bean
    public CompetenceDeletedEventHandler competenceDeletedEventHandler() { return new CompetenceDeletedEventHandler(notifications());}

    @Bean
    public DispoAddedEventHandler dispoAddedEventHandler() { return new DispoAddedEventHandler(notifications());}

    @Bean
    public DispoDeletedEventHandler dispoDeletedEventHandler() { return new DispoDeletedEventHandler(notifications()); }

    @Bean
    public ModaliteAddedEventHandler modaliteAddedEventHandler() { return new ModaliteAddedEventHandler(notifications()); }

    @Bean
    public ModaliteDeletedEventHandler modaliteDeletedEventHandler() { return new ModaliteDeletedEventHandler(notifications()); }

    @Bean
    public TJMUpdatedEventHandler tjmUpdatedEventHandler() { return new TJMUpdatedEventHandler(notifications()); }

}
