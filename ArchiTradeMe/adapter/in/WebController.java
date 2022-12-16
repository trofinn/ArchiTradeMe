package adapter.in;

import application.port.in.DTOs.InscriptionCommand;
import domain.Consultant;
import kernel.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
public class WebController {

    private final CommandBus commandBus;

    @Autowired
    public WebController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public InscriptionConsultantResponse create(@RequestBody @Valid InscriptionConsultantRequest inscriptionConsultantRequest)
    {
        Consultant consultant = (Consultant) commandBus.post(
                new InscriptionCommand(
                            inscriptionConsultantRequest.email,
                            inscriptionConsultantRequest.nom,
                            inscriptionConsultantRequest.prenom));
        return new InscriptionConsultantResponse(consultant);
    }

}
