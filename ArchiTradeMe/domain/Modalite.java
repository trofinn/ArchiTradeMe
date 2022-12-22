package domain;

public enum Modalite {
    Presenciel,
    Distanciel,

    Modalite() {};

    public String get_status() {
        return this.name();
    }
}
