package entity;

public class System{

    private int idSysteme;
    private String libelle;

    public System(int idSysteme, String libelle) {
        this.idSysteme = idSysteme;
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return this.libelle;
    }

    public int getIdSysteme() {
        return idSysteme;
    }

    public String getLibelle() {
        return libelle;
    }
}
