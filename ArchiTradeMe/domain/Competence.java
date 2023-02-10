package domain;


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
}
