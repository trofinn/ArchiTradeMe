package adapter.in;

import adapter.mapper.ClientDtoMapper;
import adapter.mapper.CompetenceDtoMapper;
import adapter.mapper.ConsultantDtoMapper;
import adapter.mapper.OffreDtoMapper;
import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.*;
import application.port.in.UseCases.*;
import application.port.in.UseCases.RenseignementsUseCases.*;
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
    private final AfficheConsultantUseCase afficheConsultantUseCase;
    private final InscriptionClientUseCase inscriptionClientUseCase;
    private final AjouterOffreUseCase ajouterOffreUseCase;
    private final AfficheClientUseCase afficheClientUseCase;
    private final PersistanceAdapter persistanceAdapter;
    private final AddCompetenceUseCase addCompetenceUseCase;
    private final AddDispoUseCase addDispoUseCase;
    private final AddModaliteUseCase addModaliteUseCase;
    private final DeleteCompetenceUseCase deleteCompetenceUseCase;
    private final DeleteDispoUseCase deleteDispoUseCase;
    private final DeleteModaliteUseCase deleteModaliteUseCase;
    private final SetTJMUseCase setTJMUseCase;

    public WebController(InscriptionConsultantUseCase inscriptionConsultantUseCase, AfficheConsultantUseCase afficheConsultantUseCase,
                         InscriptionClientUseCase inscriptionClientUseCase, AjouterOffreUseCase ajouterOffreUseCase, AfficheClientUseCase afficheClientUseCase,
                         PersistanceAdapter persistanceAdapter, AddCompetenceUseCase addCompetenceUseCase, AddDispoUseCase addDispoUseCase,
                         AddModaliteUseCase addModaliteUseCase, DeleteCompetenceUseCase deleteCompetenceUseCase, DeleteDispoUseCase deleteDispoUseCase,
                         DeleteModaliteUseCase deleteModaliteUseCase, SetTJMUseCase setTJMUseCase) {
        this.inscriptionConsultantUseCase = inscriptionConsultantUseCase;
        this.afficheConsultantUseCase = afficheConsultantUseCase;
        this.inscriptionClientUseCase = inscriptionClientUseCase;
        this.ajouterOffreUseCase = ajouterOffreUseCase;
        this.afficheClientUseCase = afficheClientUseCase;
        this.persistanceAdapter = persistanceAdapter;
        this.addCompetenceUseCase = addCompetenceUseCase;
        this.addDispoUseCase = addDispoUseCase;
        this.addModaliteUseCase = addModaliteUseCase;
        this.deleteCompetenceUseCase = deleteCompetenceUseCase;
        this.deleteDispoUseCase = deleteDispoUseCase;
        this.deleteModaliteUseCase = deleteModaliteUseCase;
        this.setTJMUseCase = setTJMUseCase;
    }

    @PostMapping("/consultants")
    public ConsultantDto inscription(@RequestBody @Valid InscriptionConsultantRequest consultant) {
        Consultant consultant1 =  inscriptionConsultantUseCase.inscription(new InscriptionConsultantCommand(consultant.email,consultant.nom,consultant.prenom));
        return ConsultantDtoMapper.toDto(consultant1);
        //curl -X POST localhost:8080/consultants -H 'Content-type:application/json' -d '{"email": "trofin2@gmail.com", "nom": "trofin", "prenom": "nicu"}'
    }

    @GetMapping("/consultants/{email}")
    public ConsultantDto affiche_consultant(@PathVariable String email) {
        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        return ConsultantDtoMapper.toDto(consultant);
        //curl -v localhost:8080/consultants/trofin2@gmail.com
    }

    @PutMapping("/consultants/{email}/add/competence")
    public ConsultantDto add_competence(@RequestBody @Valid CompetenceDto competence, @PathVariable String email) {

        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        addCompetenceUseCase.add_competence(new RenseignementsCommand(consultant, CompetenceDtoMapper.toDomain(competence)));
        return ConsultantDtoMapper.toDto(consultant);
        // curl -X PUT localhost:8080/consultants/trofin2@gmail.com/add/competence/ -H 'Content-type:application/json' -d '{"val": "C++"}'
    }

    @GetMapping("/consultants")
    public ArrayList<ConsultantDto> affiche_tous() {
        ArrayList<Consultant> list_consultant =  persistanceAdapter.findAll();
        ArrayList<ConsultantDto> list_return = new ArrayList<>();
        for(Consultant i : list_consultant) {
            list_return.add(ConsultantDtoMapper.toDto(i));
        }
        return list_return;
        // curl -v localhost:8080/consultants
    }

    @PutMapping("/consultants/{email}/delete/competence")
    public ConsultantDto delete_competence(@RequestBody @Valid CompetenceDto competence, @PathVariable String email) {
        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        deleteCompetenceUseCase.delete_competence(new RenseignementsCommand(consultant,CompetenceDtoMapper.toDomain(competence)));
        return ConsultantDtoMapper.toDto(consultant);
        // curl -X PUT localhost:8080/consultants/trofin2@gmail.com/delete/competence/ -H 'Content-type:application/json' -d '{"val" : "C++"}'
    }

    @PutMapping("/consultants/{email}/add/modalite")
    public ConsultantDto add_modalite(@RequestBody @Valid ModaliteDto modalite, @PathVariable String email) {
        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        addModaliteUseCase.add_modalite(new RenseignementsCommand(consultant,Modalite.valueOf(modalite.name())));
        return ConsultantDtoMapper.toDto(consultant);
        // curl -X PUT localhost:8080/consultants/trofin2@gmail.com/add/modalite -H 'Content-type:application/json' -d '"Presenciel"'
    }

    @PutMapping("/consultants/{email}/delete/modalite")
    public ConsultantDto delete_modalite(@RequestBody @Valid ModaliteDto modalite, @PathVariable String email) {
        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        deleteModaliteUseCase.delete_modalite(new RenseignementsCommand(consultant,Modalite.valueOf(modalite.name())));
        return ConsultantDtoMapper.toDto(consultant);
        // curl -X PUT localhost:8080/consultants/trofin2@gmail.com/delete/modalite -H 'Content-type:application/json' -d '"Presenciel"'
    }

    @PutMapping("/consultants/{email}/TJM")
    public ConsultantDto set_TJM(@RequestBody @Valid String TJM, @PathVariable String email) {
        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        setTJMUseCase.set_TJM(new RenseignementsCommand(consultant,TJM));
        return ConsultantDtoMapper.toDto(consultant);
        // curl -X PUT localhost:8080/consultants/trofin2@gmail.com/TJM -H 'Content-type:application/json' -d '{"TJM": "300"}'
    }


    @PutMapping("/consultants/{email}/add/dispo")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public ConsultantDto add_dispo(@RequestBody @Valid @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date, @PathVariable String email) {
        Consultant consultant = afficheConsultantUseCase.recherche_consultant(new AfficheConsultantCommand(email));
        addDispoUseCase.add_dispo(new RenseignementsCommand(consultant,date));
        return ConsultantDtoMapper.toDto(consultant);
        // curl -X PUT localhost:8080/consultants/trofin2@gmail.com/add/dispo -H 'Content-type:application/json' -d '{""}'
    }

    @PostMapping("/inscription/client")
    public ClientDto inscription(@RequestBody @Valid InscriptionClientRequest client) {
        Client client1 = inscriptionClientUseCase.inscription(new InscriptionClientCommand(client.getEmail_contact(), client.getNom(), client.getPrenom()));
        return ClientDtoMapper.toDto(client1);
        //curl -X POST localhost:8080/inscription/client -H 'Content-type:application/json' -d '{"email_contact": "trofin2@gmail.com", "nom": "trofin", "prenom": "nicu"}'
    }

    @GetMapping("/clients/{email}")
    public ClientDto affiche_client(@PathVariable String email) {
        Client client = afficheClientUseCase.affiche_client(new AfficheClientCommand(email));
        return ClientDtoMapper.toDto(client);
        //curl -v localhost:8080/clients/trofin2@gmail.com
    }


    @PutMapping("/client/{email}/add_offre")
    public ClientDto add_offre(@RequestBody OffreDto offre, @PathVariable String email) {
        Client client = afficheClientUseCase.affiche_client(new AfficheClientCommand(email));
        ajouterOffreUseCase.ajouter_offre(new AjouterOffreCommand(client, OffreDtoMapper.toDomain(offre)));
        return ClientDtoMapper.toDto(client);
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
