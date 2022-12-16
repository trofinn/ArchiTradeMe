package domain;

public class Competence {

    private final String val;

    public Competence(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Competence{" +
                "val='" + val + '\'' +
                '}';
    }
}
