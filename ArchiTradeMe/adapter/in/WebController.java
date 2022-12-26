package adapter.in;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.*;
import application.port.in.UseCases.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import domain.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
public class WebController {

    private final InscriptionConsultantUseCase inscriptionConsultantUseCase;
    private final RenseignementsUseCase renseignementsUseCase;
    private final AfficheConsultantUseCase afficheConsultantUseCase;
    private final InscriptionClientUseCase inscriptionClientUseCase;
    private final AjouterOffreUseCase ajouterOffreUseCase;
    private final AfficheClientUseCase afficheClientUseCase;
    private final PersistanceAdapter persistanceAdapter;

    public WebController(InscriptionConsultantUseCase inscriptionConsultantUseCase, RenseignementsUseCase renseignementsUseCase, AfficheConsultantUseCase afficheConsultantUseCase, InscriptionClientUseCase inscriptionClientUseCase, AjouterOffreUseCase ajouterOffreUseCase, AfficheClientUseCase afficheClientUseCase, PersistanceAdapter persistanceAdapter) {
        this.inscriptionConsultantUseCase = inscriptionConsultantUseCase;
        this.renseignementsUseCase = renseignementsUseCase;
        this.afficheConsultantUseCase = afficheConsultantUseCase;
        this.inscriptionClientUseCase = inscriptionClientUseCase;
        this.ajouterOffreUseCase = ajouterOffreUseCase;
        this.afficheClientUseCase = afficheClientUseCase;
        this.persistanceAdapter = persistanceAdapter;
    }

    @PostMapping("/consultants")
    public Consultant inscription(@RequestBody @Valid Consultant consultant) {
        return inscriptionConsultantUseCase.inscription(new InscriptionConsultantCommand(consultant.getEmail(),consultant.getNom(),consultant.getPrenom()));
        //curl -X POST localhost:8080/consultants -H 'Content-type:application/json' -d '{"email": "trofin2@gmail.com", "nom": "trofin", "prenom": "nicu"}'
    }

    @GetMapping("/consultants/{email}")
    public Consultant affiche_consultant(@PathVariable String email) {
        return afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        //curl -v localhost:8080/consultants/trofin2@gmail.com
    }

    @PutMapping("/consultants/{email}/add/competence")
    public Consultant add_competence(@RequestBody @Valid Competence competence, @PathVariable String email) {

        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        return renseignementsUseCase.add_competence(new RenseignementsCommand(consultant,competence));
        // curl -X PUT localhost:8080/consultants/trofin2@gmail.com/add/competence/ -H 'Content-type:application/json' -d '{"val": "C++"}'
    }

    @GetMapping("/consultants")
    public ArrayList<Consultant> affiche_tous() {
        return persistanceAdapter.findAll();
        // curl -v localhost:8080/consultants
    }

    @PutMapping("/consultants/{email}/delete/competence")
    public Consultant delete_competence(@RequestBody @Valid Competence competence, @PathVariable String email) {
        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        return renseignementsUseCase.delete_competence(new RenseignementsCommand(consultant,competence));
        // curl -X PUT localhost:8080/consultants/trofin2@gmail.com/delete/competence/ -H 'Content-type:application/json' -d '{"val" : "C++"}'
    }

    @PutMapping("/consultants/{email}/add/modalite")
    public Consultant add_modalite(@RequestBody @Valid Modalite modalite, @PathVariable String email) {
        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        return renseignementsUseCase.add_modalite(new RenseignementsCommand(consultant,modalite));
        // curl -X PUT localhost:8080/consultants/trofin2@gmail.com/add/modalite -H 'Content-type:application/json' -d '"Presenciel"'
    }

    @PutMapping("/consultants/{email}/delete/modalite")
    public Consultant delete_modalite(@RequestBody @Valid Modalite modalite, @PathVariable String email) {
        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        return renseignementsUseCase.delete_modalite(new RenseignementsCommand(consultant,modalite));
        // curl -X PUT localhost:8080/consultants/trofin2@gmail.com/delete/modalite -H 'Content-type:application/json' -d '"Presenciel"'
    }

    @PutMapping("/consultants/{email}/TJM")
    public Consultant set_TJM(@RequestBody @Valid String TJM, @PathVariable String email) {
        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        return renseignementsUseCase.set_TJM(new RenseignementsCommand(consultant,TJM));
        // curl -X PUT localhost:8080/consultants/trofin2@gmail.com/TJM -H 'Content-type:application/json' -d '{"TJM": "300"}'
    }


    @PutMapping("/consultants/{email}/add/dispo")
    @JsonDeserialize(using = LocalDateDeserializer.class)

    public Consultant add_dispo(@RequestBody @Valid @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date, @PathVariable String email) {
        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        return renseignementsUseCase.add_dispo(new RenseignementsCommand(consultant,date));
        // curl -X PUT localhost:8080/consultants/trofin2@gmail.com/add/dispo -H 'Content-type:application/json' -d '{""}'
    }

    @PostMapping("/inscription/client")
    public Client inscription(@RequestBody @Valid Client client) {
        return inscriptionClientUseCase.inscription(new InscriptionClientCommand(client.getEmail(), client.getNom(), client.getPrenom()));
        //curl -X POST localhost:8080/inscription/client -H 'Content-type:application/json' -d '{"email_contact": "trofin2@gmail.com", "nom": "trofin", "prenom": "nicu"}'
    }

    @GetMapping("/clients/{email}")
    public Client affiche_client(@PathVariable String email) {
        return afficheClientUseCase.affiche_client(new AfficheClientCommand(email));
        //curl -v localhost:8080/clients/trofin2@gmail.com
    }


    @PutMapping("/client/{email}/add_offre")
    public Client add_offre(@RequestBody Offre offre, @PathVariable String email) {
        Client client = afficheClientUseCase.affiche_client(new AfficheClientCommand(email));
        return ajouterOffreUseCase.ajouter_offre(new AjouterOffreCommand(client,offre));
    }
    /*
    curl -X PUT localhost:8080/client/trofin2@gmail.com/add_offre -H 'Content-type:application/json' -d '{
  "id" : "123",
  "TJM" : "100",
  "comeptences_necessaires" : [ {
    "val" : "C++"
  } ],
  "modalites" : [ "Presenciel" ],
  "date_debut" : "lundi",
  "duration" : "10"
}'
     */
}
