package domain;


import java.util.Objects;

public class Competence {

    private String val;

    public Competence(String val) {
        this.val = val;
    }

    Competence() {}

    public String getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "Competence{" +
                "val='" + val + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competence that = (Competence) o;
        return Objects.equals(val, that.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
