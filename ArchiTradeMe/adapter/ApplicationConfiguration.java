package adapter;

import adapter.out.PersistanceAdapter;
import application.port.in.UseCases.*;
import application.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
    public InscriptionUseCase inscriptionUseCase() {
        return new InscriptionService(persistanceAdapter());
    }

    @Bean
    public RenseignementsUseCase renseignementsUseCase() {
        return new RenseignementsService(persistanceAdapter());
    }

    @Bean
    public AfficheConsultantUseCase afficheConsultantsUseCase() { return new AfficheConsultantsService(persistanceAdapter());}

    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

    @Bean
    public InscriptionClientUseCase inscriptionClientUseCase() {return new ClientService(persistanceAdapter());
    }

    @Bean
    public AjouterOffreUseCase ajouterOffreUseCase() { return  new OffresService(persistanceAdapter());
    }

    @Bean
    public AfficheClientUseCase afficheClientUseCase() { return new AfficheClientService(persistanceAdapter());}
}
