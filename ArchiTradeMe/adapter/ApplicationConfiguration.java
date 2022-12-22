package adapter;

import adapter.out.PersistanceAdapter;
import application.port.in.UseCases.AfficheConsultantUseCase;
import application.port.in.UseCases.InscriptionUseCase;
import application.port.in.UseCases.RenseignementsUseCase;
import application.services.AfficheConsultantsService;
import application.services.InscriptionService;
import application.services.RenseignementsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public PersistanceAdapter persistanceAdapter() {
        return new PersistanceAdapter();
    }

    @Bean
    public InscriptionUseCase inscriptionUseCase() {
        return new InscriptionService(persistanceAdapter());
    }

    @Bean
    public RenseignementsUseCase renseignementsUseCase() {
        return new RenseignementsService(persistanceAdapter());
    }

    @Bean
    public AfficheConsultantUseCase afficheConsultantsUseCase() { return new AfficheConsultantsService(persistanceAdapter());}

}
