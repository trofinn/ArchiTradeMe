package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Competence {

    @JsonProperty
    private String val;

    public Competence(String val) {
        this.val = val;
    }

    Competence() {}

}
