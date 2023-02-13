package domain;

import adapter.in.*;
import adapter.mapper.CompetenceDtoMapper;
import adapter.mapper.OffreDtoMapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertJavaObjectToJson {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Competence offre = newCompetence();
        ArrayList<CompetenceDto> competences = new ArrayList<>();
        competences.add(CompetenceDtoMapper.toDto(offre));
        InscriptionConsultantRequest consultant = newConsultant();
        CompetenceDto competenceDto = new CompetenceDto("c++");
        ModaliteDto modaliteDto = ModaliteDto.Presenciel;
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatedDateTime = date.format(formatter);
        InscriptionClientRequest client = new InscriptionClientRequest("client@gmail.com","client","client");
        ArrayList<ModaliteDto> modalites = new ArrayList<>();
        modalites.add(modaliteDto);
        OffreDto offreDto = new OffreDto("123","100",competences,modalites,"2023-02-27T10:00:00","10");

        try {
            mapper.writeValue(new File("offre.json"), offreDto);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(offreDto);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InscriptionConsultantRequest newConsultant() {
        return new InscriptionConsultantRequest("trofin@gmail.com","trofin","nicu");
    }

    private static Offre newOffre() {
        ArrayList<Competence> competences= new ArrayList<>();
        competences.add(new Competence("C++"));

        ArrayList<Modalite> modalites = new ArrayList<>();
        modalites.add(Modalite.Presenciel);

        Offre offre = new Offre("123","100",competences,modalites,"lundi","10");


        return offre;
    }

    private static Competence newCompetence() {
       return new Competence("C++");
    }
}

