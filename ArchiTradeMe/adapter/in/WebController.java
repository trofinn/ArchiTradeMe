package adapter.in;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.AfficheConsultantCommand;
import application.port.in.DTOs.InscriptionCommand;
import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.AfficheConsultantUseCase;
import application.port.in.UseCases.InscriptionUseCase;
import application.port.in.UseCases.RenseignementsUseCase;
import domain.Competence;
import domain.Consultant;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class WebController {
    private final InscriptionUseCase inscriptionUseCase;
    private final RenseignementsUseCase renseignementsUseCase;
    private final AfficheConsultantUseCase afficheConsultantUseCase;
    private final PersistanceAdapter persistanceAdapter;

    public WebController(InscriptionUseCase inscriptionUseCase, RenseignementsUseCase renseignementsUseCase, AfficheConsultantUseCase afficheConsultantUseCase, PersistanceAdapter persistanceAdapter) {
        this.inscriptionUseCase = inscriptionUseCase;
        this.renseignementsUseCase = renseignementsUseCase;
        this.afficheConsultantUseCase = afficheConsultantUseCase;
        this.persistanceAdapter = persistanceAdapter;
    }

    @PostMapping("/consultants")
    public Consultant inscription(@RequestBody @Valid Consultant consultant) {
        return inscriptionUseCase.inscription(new InscriptionCommand(consultant.getEmail(),consultant.getNom(),consultant.getPrenom()));
        //curl -X POST localhost:8080/consultants -H 'Content-type:application/json' -d '{"email": "trofin2@gmail.com", "nom": "trofin", "prenom": "nicu"}'
    }

    @GetMapping("/consultants/{email}")
    public Consultant affiche_consultant(@PathVariable String email) {
        return afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        //curl -v localhost:8080/consultants/trofin2@gmail.com
    }

    @PutMapping("/consultants/{email}/competence")
    public Consultant add_competence(@PathVariable String email, @RequestBody Competence competence) {
        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        return renseignementsUseCase.add_competence(new RenseignementsCommand(consultant,competence));
        // curl -X PUT localhost:8080/consultants/trofin2@gmail.com/competences/ -H 'Content-type:application/json' -d '{"val": "C++"}'
    }

    @GetMapping("/consultants")
    public ArrayList<Consultant> affiche_tous() {
        return persistanceAdapter.findAll();
        // curl -v localhost:8080/consultants
    }

}
