package adapter;

import adapter.out.PersistanceAdapter;
import application.port.in.UseCases.InscriptionUseCase;
import application.port.in.UseCases.RenseignementsUseCase;
import application.services.InscriptionService;
import application.services.RenseignementsService;
import kernel.BusFactory;
import kernel.CommandBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public PersistanceAdapter persistanceAdapter() {
        return new PersistanceAdapter();
    }

    @Bean
    public CommandBus commandBus() {
        return BusFactory.defaultCommandBus();
    }

    @Bean
    public InscriptionUseCase inscriptionUseCase() {
        return new InscriptionService(persistanceAdapter());
    }

    @Bean
    public RenseignementsUseCase renseignementsUseCase() {
        return new RenseignementsService(persistanceAdapter());
    }
}
