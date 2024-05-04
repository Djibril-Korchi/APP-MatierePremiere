package entity;

public class Piece {
    private int id_piece;
    private String libelle;
    private int longueur;
    private int quantite;
    private int ref_systeme;

    public Piece(int id_piece, String libelle, int longueur, int quantite, int ref_systeme) {
        this.id_piece = id_piece;
        this.libelle = libelle;
        this.longueur = longueur;
        this.quantite = quantite;
        this.ref_systeme = ref_systeme;
    }

    @Override
    public String toString() {
        return libelle;
    }
}
