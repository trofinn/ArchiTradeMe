package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetenceDto that = (CompetenceDto) o;
        return Objects.equals(val, that.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
