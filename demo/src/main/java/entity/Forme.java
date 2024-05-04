package entity;

public class Forme {
    private int id_forme;
    private String forme;

    public Forme(int id_forme, String forme) {
        this.id_forme = id_forme;
        this.forme = forme;
    }

    @Override
    public String toString() {
        return forme;
    }

}
