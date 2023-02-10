package domain;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertJavaObjectToJson {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Competence offre = newCompetence();

        try {
            mapper.writeValue(new File("offre.json"), offre);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(offre);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
