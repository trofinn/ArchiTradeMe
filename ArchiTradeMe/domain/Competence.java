package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Competence {

    @JsonProperty
    private String val;

    public Competence(String val) {
        this.val = val;
    }

    Competence() {}

    @Override
    public String toString() {
        return "Competence{" +
                "val='" + val + '\'' +
                '}';
    }
}
