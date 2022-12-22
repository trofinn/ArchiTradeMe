package adapter;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.AfficheConsultantCommand;
import application.port.in.DTOs.InscriptionCommand;
import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.AfficheConsultantUseCase;
import application.port.in.UseCases.InscriptionUseCase;
import application.port.in.UseCases.RenseignementsUseCase;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final PersistanceAdapter persistanceAdapter;
    private final InscriptionUseCase inscriptionUseCase;
    private final RenseignementsUseCase renseignementsUseCase;
    private final AfficheConsultantUseCase afficheConsultantsUseCase;

    public StartupApplicationListener(PersistanceAdapter persistanceAdapter, InscriptionUseCase inscriptionUseCase, RenseignementsUseCase renseignementsUseCase, AfficheConsultantUseCase afficheConsultantsUseCase) {
        this.persistanceAdapter = persistanceAdapter;
        this.inscriptionUseCase = inscriptionUseCase;
        this.renseignementsUseCase = renseignementsUseCase;
        this.afficheConsultantsUseCase = afficheConsultantsUseCase;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }
}
