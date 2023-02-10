package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompetenceDto {
    @JsonProperty
    private String val;

    public CompetenceDto(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    CompetenceDto() {}

    @Override
    public String toString() {
        return "CompetenceDto{" +
                "val='" + val + '\'' +
                '}';
    }
}
