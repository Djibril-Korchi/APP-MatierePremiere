package entity;

public class Classe {
    private int id_classe;
    private String libelle;
    private int ref_filiere;
    public Classe(int id_classe, String libelle, int ref_filiere) {
        this.id_classe = id_classe;
        this.libelle = libelle;
        this.ref_filiere = ref_filiere;
    }
    public String toString(){
        return libelle;
    }

}
